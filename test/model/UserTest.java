package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import exceptions.DayAndIdException;
import exceptions.NoTIException;

class UserTest {
	
	private int day = LocalDateTime.now().getDayOfMonth();
	private User u = null;

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
		
		TD type = TD.CC;
		String id = "123456";
		
		setupScenary1(type, id);
		
	}
	
	@Test
	public void testTIException() {
		
		TD type = TD.TI;
		String id = "123456";
		
		setupScenary2(type, id);
		
	}
	
	@Test
	public void testDayAndIdException() {
		
		TD type = TD.CC;
		String id = "";
		
		if(day%2 == 0) {
			id = "1234567";
		} else {
			id = "123456";
		}
		
		setupScenary3(type, id);
		
	}

}
