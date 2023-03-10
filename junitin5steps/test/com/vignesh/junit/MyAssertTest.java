package com.vignesh.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

	@Test
	void test() {
		boolean test = todos.contains("AWS");
		boolean test1= todos.contains("GCP");
//		assertEquals(true, test);	
		assertEquals(3, todos.size());
		assertTrue(test);
		assertFalse(test1);
//		assertFalse assertNull assertNotNull
		assertArrayEquals(new int[] { 1, 2 }, new int[] { 2, 3 });
	}

}
