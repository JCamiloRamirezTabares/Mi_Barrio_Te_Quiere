package model;

public class User {

	private TD typeD;
	private String in;
	
	//Constructor
	public User(TD typeD, String in) {
		this.typeD = typeD;
		this.in = in;
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
	
}
