package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.DayAndIdException;
import exceptions.NoTIException;

public class Market {

	private List<User> userJoined;
	private List<User> allUsers;
	
	private int count;
	
	public Market()
	{
		userJoined = new ArrayList<User>();
		allUsers = new ArrayList<User>();
		count = 0;
	}
	
	public String SignIn(TD type, String id){
		
		User user = null;
		count++;
		
		String confirmation = "";
		
		try {
			user = new User(type, id);
			allUsers.add(user);
			
			try {
				user.CanSignIn();
				userJoined.add(new User(type, id));
				
				confirmation = "El usuario ha ingresado correctamente";
			} catch(DayAndIdException e) {
				confirmation = "El usuario no le corresponde ingresar hoy";
			}
		} catch (NoTIException e) {
			allUsers.add(user);
			confirmation = "No se permite Tarjeta de Identidad como documento valido";
		}
		
		return confirmation;
    }

    public int getCount() {
        return count;
    }

	public List<User> getUserJoined() {
		return userJoined;
	}

	public List<User> getAllUsers() {
		return allUsers;
	}

}
