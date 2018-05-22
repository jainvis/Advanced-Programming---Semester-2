package assignment;

/**
 * JUnit Test for Adult Class
 * This is used to run unit test on a concrete class
 * @author Natalie Sy 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdult {
	
	Adult profile1;
	Adult profile2;
	Adult profile3;
	
	@BeforeEach
	void setUp() {
		profile1 = new Adult("john nash",30,"Mathematician");
		profile2 = new Adult("eleanor stier",30,"Nurse");
		profile3 = new Adult("alan turing",42,"Computer Scientist");
		
	}

	@Test
	public void testName() {
	assertEquals("john nash", profile1.getName());
	}
	
	
	@Test
	public void testfailName() {
	assertEquals("john nash", profile2.getName());
	}
	
	@Test
	public void testAge() {
	assertEquals(30, profile1.getAge());
	}
	
	@Test
	public void testfailAge() {
	assertEquals(20, profile1.getAge());
	}
	
	@Test
	public void testStatus() {
		assertEquals("Computer Scientist", profile3.getStatus());
	}
	
	@Test
	public void testfailStatus() {
		assertEquals("Computer Scientist", profile1.getStatus());
	}
	
	@Test
	public void testNotNull() {
		assertNotNull(profile3);
	}

	
}
