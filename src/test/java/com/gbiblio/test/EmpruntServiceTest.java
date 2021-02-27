package com.gbiblio.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gbiblio.dao.IDocumentDao;
import com.gbiblio.dao.IEmpruntDao;
import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;
import com.gbiblio.service.EmpruntServiceImp;
import com.gbiblio.service.IEmpruntService;
import com.gbiblio.test.LibraryServiceTest.MyArgMatcher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class EmpruntServiceTest {

	@Mock
	private IEmpruntDao empruntDao;

	@Mock
	private IDocumentDao documentDao;

	@InjectMocks
	private IEmpruntService empruntService = new EmpruntServiceImp();

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Mock
	private LibraryService service;

	@Mock
	private LibraryService.DAO dao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAdd_ok() throws GBiblioException {

		Livre livre_1 = new Livre(1L, "DOCKER", true);
		Livre livre_2 = new Livre(1L, "DOCKER", false);
		Adherent adherent_1 = new Adherent(1L);
		Emprunt emprunt_1 = new Emprunt(new Date(), new Date(), adherent_1, livre_1);

		Mockito.when(documentDao.findOne(1L)).thenReturn(livre_1);
		doNothing().when(empruntDao).persist(emprunt_1);
		Mockito.when(documentDao.update(Mockito.any(Document.class))).thenReturn(livre_2);

		Emprunt emprunt_2 = empruntService.add(emprunt_1);

		assertNotNull(emprunt_2);
		assertEquals(emprunt_1, emprunt_2);
		// on verifie que qu'on a passe le bon argument
		verify(documentDao).findOne(argThat(new ArgThatFindOne(1L)));

	}

	@Test
	public void testAdd_exception() throws GBiblioException {

		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("args null");

		Livre livre_1 = new Livre(1L, "DOCKER", true);
		Livre livre_2 = new Livre(1L, "DOCKER", false);
		Adherent adherent_1 = new Adherent(1L);
		Emprunt emprunt_1 = new Emprunt(new Date(), new Date(), adherent_1, livre_1);

		Mockito.when(documentDao.findOne(1L)).thenReturn(livre_1);
		doNothing().when(empruntDao).persist(emprunt_1);
		Mockito.when(documentDao.update(livre_2)).thenReturn(livre_2);

		Emprunt emprunt_2 = empruntService.add(null);

	}

	@Test
	public void testCustomArgMatcher() {
		when(service.hasBookWithId(argThat(isValid()))).thenReturn(true);

		assertTrue(service.hasBookWithId(42));
		assertFalse(service.hasBookWithId(-42));
	}

	private MyArgMatcher isValid() {
		return new MyArgMatcher();
	}

	public static class MyArgMatcher implements ArgumentMatcher<Integer> {

		Integer argument;

		@Override
		public boolean matches(Integer argument) {
			this.argument = argument;
			return argument != null && argument > 0;
		}

		@Override
		public String toString() {
			return String.format("%d must be a positive integer", argument);
		}
	}
	
	private class ArgThatFindOne implements ArgumentMatcher<Long> {
		private Long id;
		
		public ArgThatFindOne(Long id) {
			this.id = id;
		}

		@Override
		public boolean matches(Long argument) {
			return this.id.equals(argument);
		}

	}

}
