package com.gbiblio.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class TestArgumentCaptor {

	//@Captor ArgumentCaptor<Long> acLong;
	ArgumentCaptor<Long> acLong = ArgumentCaptor.forClass(Long.class);

//	Need below method if using @Captor annotation
//	@BeforeEach
//	void setup() {
//		MockitoAnnotations.initMocks(this);
//	}
	
//	@Test
//	public void testCaptor() {
//		MathUtils mockMathUtils = mock(MathUtils.class);
//		when(mockMathUtils.add(1, 1)).thenReturn(2);
//		when(mockMathUtils.isInteger(anyString())).thenReturn(true);
//
//		ArgumentCaptor<Integer> acInteger = ArgumentCaptor.forClass(Integer.class);
//		ArgumentCaptor<String> acString = ArgumentCaptor.forClass(String.class);
//
//		assertEquals(2, mockMathUtils.add(1, 1));
//		assertTrue(mockMathUtils.isInteger("1"));
//		assertTrue(mockMathUtils.isInteger("999"));
//
//		verify(mockMathUtils).add(acInteger.capture(), acInteger.capture());
//		List<Integer> allValues = acInteger.getAllValues();
//		
//		assertEquals(Arrays.asList(1, 1), allValues);
//		verify(mockMathUtils, times(2)).isInteger(acString.capture());
//		List<String> allStringValues = acString.getAllValues();
//		assertEquals(Arrays.asList("1", "999"), allStringValues);
//		
//		when(mockMathUtils.squareLong(2L)).thenReturn(4L);
//		assertEquals(4L, mockMathUtils.squareLong(2L));
//		
//		verify(mockMathUtils).squareLong(acLong.capture());
//		assertTrue(2 == acLong.getValue());
//	}
}

//class MathUtils {
//	public int add(int x, int y) {
//		return x + y;
//	}
//
//	public boolean isInteger(String s) {
//		try {
//			Integer.parseInt(s);
//		} catch (NumberFormatException e) {
//			return false;
//		}
//		return true;
//	}
//	
//	public long squareLong(long l) {
//		return l*l;
//	}
//}