package com.gbiblio.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.gbiblio.config.CoreConfig;
import com.gbiblio.config.MvcWebConfig;
import com.gbiblio.controller.MyController;
import com.gbiblio.dao.IDocumentDao;
import com.gbiblio.dao.IEmpruntDao;
import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;
import com.gbiblio.service.EmpruntServiceImp;
import com.gbiblio.service.IAdherentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // pas necessaire si on utilise standaloneSetup
//@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml", "classpath:/spring/appconfig-mvc.xml"})
@ContextConfiguration(classes = { MvcWebConfig.class, CoreConfig.class })
public class ControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Mock
	IAdherentService adherentService;

	@InjectMocks
	@Autowired
	private MyController myController;
	
	
	@Mock
	private IEmpruntDao empruntDao;
	
	@Mock
	private IDocumentDao documentDao;

//	@Autowired
	@InjectMocks
	private EmpruntServiceImp empruntService;
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(myController)
//	                                 .setViewResolvers(viewResolver())
//	                                 .build();	

//	  this.mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void testAccueil() throws Exception {
		List<Adherent> listAdherent = new ArrayList<Adherent>();
		listAdherent.add(new Adherent(1L, "EL MARZOUQY", "Zineb"));
		Mockito.when(adherentService.listAll()).thenReturn(listAdherent);
		// Exécution de la requête HTTP
//	  Mockito.when(commandeImpl.showCommande()).thenReturn("iam mocked ...");
		this.mockMvc.perform(get("/myController/index"))
				// Affichage des traces
				.andDo(print())
				// Vérification de l'objet du model passé à la vue
				// .andExpect(model().attribute("message", "iam mocked ..."))
				// Vérification de l'affichage de la vue en retour
				.andExpect(view().name("index"))
				// Vérification du statut la response HTTP (Code 200)
				.andExpect(status().isOk());
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

	private InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:/views/");
		viewResolver.setSuffix(".html");
		return viewResolver;
	}

}
