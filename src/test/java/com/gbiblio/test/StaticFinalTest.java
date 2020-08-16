package com.gbiblio.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class StaticFinalTest {
	
	@Mock
	GetMe getMe;
	
	StaticFinal staticFinal;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);	
		staticFinal = new StaticFinal(getMe);
		
	}

	@Test
	public void testStatique() {
		Mockito.when(getMe.getInt()).thenReturn(99);
		int i = staticFinal.statique();
		assertTrue(i == 99);
	}
	
//	@Test
//	public void testFinale() {
//		StaticFinal staticFinal = new StaticFinal();
//		final boolean s = staticFinal.finale();
//		assertTrue(s);
//	}

}
