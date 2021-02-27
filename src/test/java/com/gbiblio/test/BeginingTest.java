package com.gbiblio.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;


import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gbiblio.main.BeanTest;


public class BeginingTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void testCaptor() {
		MathUtils mockMathUtils = mock(MathUtils.class);
		when(mockMathUtils.add(1, 1)).thenReturn(2);
		when(mockMathUtils.isInteger(anyString())).thenReturn(true);

		ArgumentCaptor<Integer> acInteger = ArgumentCaptor.forClass(Integer.class);
		ArgumentCaptor<String> acString = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Long> acLong = ArgumentCaptor.forClass(Long.class);


		assertEquals(2, mockMathUtils.add(1, 1));
		assertTrue(mockMathUtils.isInteger("1"));
		assertTrue(mockMathUtils.isInteger("999"));

		verify(mockMathUtils).add(acInteger.capture(), acInteger.capture());
		List<Integer> allValues = acInteger.getAllValues();
		assertEquals(Arrays.asList(1, 1), allValues);
		
		verify(mockMathUtils, times(2)).isInteger(acString.capture());
		List<String> allStringValues = acString.getAllValues();
		assertEquals(Arrays.asList("1", "999"), allStringValues);
		
		when(mockMathUtils.squareLong(2L)).thenReturn(4L);
		assertEquals(4L, mockMathUtils.squareLong(2L));
		
		verify(mockMathUtils).squareLong(acLong.capture());
		assertTrue(2 == acLong.getValue());
	}
	
	

}

class MathUtils {
	public int add(int x, int y) {
		return x + y;
	}

	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public long squareLong(long l) {
		return l*l;
	}
}
