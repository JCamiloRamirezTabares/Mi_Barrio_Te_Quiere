package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import exceptions.DayAndIdException;
import exceptions.NoTIException;

class UserTest {
	
	User u = null;

	public void setupScenary1(TD t, String n) {
		try {
			u = new User(t, n);
		} catch (NoTIException e) {
			fail();
		}
	}
	
	public void setupScenary2(TD t, String n) {
		try {
			u = new User(t, n);
			fail();
		} catch (NoTIException e) {}
	}
	
	public void setupScenary3(TD t, String n) {
		
		try {
			u = new User(t, n);
			try {
				u.CanSignIn();
				fail();
			} catch (DayAndIdException e) {}
		} catch (NoTIException e) {
			fail();
		}
		
		
	}

	@Test
	public void testUser() {
		
		setupScenary1(TD.CC, "123456");
		
	}
	
	@Test
	public void testTIException() {
		
		setupScenary2(TD.TI, "123456");
		
	}
	
	@Test
	public void testDayAndIdException() {
		
		setupScenary3(TD.CC, "123456");
		
	}

}
