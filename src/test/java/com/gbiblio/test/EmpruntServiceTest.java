package com.gbiblio.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gbiblio.dao.IDocumentDao;
import com.gbiblio.dao.IEmpruntDao;
import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;
import com.gbiblio.service.IEmpruntService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class EmpruntServiceTest {

	@Mock
	private IEmpruntDao empruntDao;
	
	@Mock
	private IDocumentDao documentDao;

	@Autowired
	@InjectMocks
	private IEmpruntService empruntService;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAdd_ok() throws GBiblioException {
		final ArgumentCaptor<Livre> captor = ArgumentCaptor.forClass(Livre.class);
			    
		Livre livre_1 = new Livre(1L, "DOCKER", true);
		Livre livre_2 = new Livre(1L, "DOCKER", false);
		Adherent adherent_1 = new Adherent(1L);
		Emprunt emprunt_1 = new Emprunt(new Date(), new Date(), adherent_1, livre_1);

		Mockito.when(documentDao.findOne(1L)).thenReturn(livre_1);
		doNothing().when(empruntDao).persist(emprunt_1);
		Mockito.when(documentDao.update(Mockito.any(Document.class))).thenReturn(livre_2);

		Emprunt emprunt_2 = empruntService.add(emprunt_1);
		

		verify(documentDao).update(captor.capture());
		Livre livreCaptor = captor.getValue();
		
		assertNotNull(emprunt_2);
		assertEquals(emprunt_1, emprunt_2);

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
	

}
