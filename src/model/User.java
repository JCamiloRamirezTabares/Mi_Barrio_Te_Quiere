package model;

import java.time.LocalDateTime;

import exceptions.DayAndIdException;
import exceptions.NoTIException;

public class User {

	private TD typeD;
	private String in;
	
	private int day = LocalDateTime.now().getDayOfMonth();
	
	//Constructor
	public User(TD typeD, String in) throws NoTIException {
		if(typeD == TD.TI) {
			this.typeD = typeD;
			this.in = in;
			throw new NoTIException();
		} else {
			this.typeD = typeD;
			this.in = in;
		}
	}


	//Getters
	public TD getTypeD() {
		return typeD;
	}

	public String getIn() {
		return in;
	}
	
	public int getPenultimate() {
		String[] a = in.split("");
		
		return Integer.parseInt(a[(a.length-2)]);
	}
	
	public void CanSignIn() throws DayAndIdException {
	
		if(day%2 == 0 && getPenultimate()%2 != 0) {
		} else if(day%2 != 0 && getPenultimate()%2 == 0) {
		} else {
			throw new DayAndIdException();
		}
		
	}
	
}
