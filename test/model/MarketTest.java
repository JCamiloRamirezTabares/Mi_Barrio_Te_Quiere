package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import exceptions.NoTIException;

class MarketTest {

	Market miniMarket;
	int day = LocalDateTime.now().getDayOfMonth();
	
	public void setupScenary1(TD type, String id) {
		miniMarket = new Market();
		
		miniMarket.SignIn(type, id);
	}
	
	@Test
	void testCanSignIn() {
		
		TD type = TD.CC;
		String id = "";
		
		if(day%2 == 0) {
			id = "1234";
		} else {
			id = "12345";
		}
		
		setupScenary1(type, id);
		try {
			assertTrue(miniMarket.getUserJoined().contains(new User(type, id)));
		} catch (NoTIException e) {}
	}

}
