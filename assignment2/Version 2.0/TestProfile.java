import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestProfile {
	
	Profile profile1;
	Profile profile2;
	Profile profile3;
	
	@BeforeEach
	void setUp() {
		profile1 = new Profile("john nash",30,"Mathematician");
		profile2 = new Profile("eleanor stier",30,"Nurse");
		profile3 = new Profile("alan turing",42,"Computer Scientist");
		
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
