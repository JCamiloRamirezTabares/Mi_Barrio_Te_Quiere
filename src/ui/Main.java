package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import exceptions.DayAndIdException;
import exceptions.NoTIException;
import model.TD;
import model.User;

public class Main {
	
	private BufferedReader br;
	private List<User> usersJoined; 
	
	//Constructor
	public Main() {
		br = new BufferedReader(new InputStreamReader(System.in));
		usersJoined = new ArrayList<User>();
	}

	public static void main(String[]juank) {
		
		Main ppal = new Main();
		
		System.out.println("======================================\n"
				+ "== Bienvenido a Mi Barrio Te Quiere ==\n"
				+ "===========  Mini-Mercado  ===========\n"
				+ "======================================\n\n");
		
		int count = 0;
		int option = -1;
		do {
			String line = "";
			
			do {
				System.out.print(ppal.Menu());
				
				try {
					line = ppal.readALine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while(line.equals(""));
			
			option = Integer.parseInt(line);
			
			switch(option) {
			case 1:
				ppal.signInUser();
				count++;
				break;
			case 2:
				System.out.println("Actualmente han intentado ingresar " + count + " personas al mini mercado\n");
				break;
			case 3:
				option = 0;
				System.out.println("Hasta la proxima :D");
				break;
			}
			
		} while(option != 0);
		
	}
	
	public String Menu() {
		return "Escoge la opcion que desea realizar:\n"
				+ "( 1 ) Para registrar el ingreso de un usuario\n"
				+ "( 2 ) Para mostrar el numero de personas que han intentado ingresar\n"
				+ "( 3 ) Para salir del programa\n\n"
				+ "Opcion: ";
	}
	
	public void signInUser(){
		
		System.out.print("Por favor escoge el tipo de documento que posee:\n"
				+ "( 1 ) Tarjeta de Identidad (TI)\n"
				+ "( 2 ) Cedula de Ciudadania (CC)\n"
				+ "( 3 ) Pasaporte (PP)\n"
				+ "( 4 ) Cedula de Extranjeria (CE)\n\n"
				+ "Opcion: ");
		
		String line = "";
		
		do {
			try {
				line = readALine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(line.equals(""));
		
		int o = Integer.parseInt(line);
		TD type = null;
		
		switch(o) {
		case 1:
			type = TD.TI;
			break;
		case 2:
			type = TD.CC;
			break;
		case 3:
			type = TD.PP;
			break;
		case 4:
			type = TD.CE;
			break;
		}
		
		
		String id = "";
		do {
			System.out.print("Ingrese el numero de documento de Identidad: ");
			
			try {
				id = readALine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(id.equals(""));
		
		User us = null;
		try {
			us = new User(type, id);
		} catch(NoTIException e) {
			System.out.println("\n===========================================\n"
					+ "No se acepta tarjeta de identidad como documento valido"
					+ "\n===========================================\n");
		}
		
		if(us != null) {
			try {
				us.CanSignIn();
				usersJoined.add(us);
				System.out.println("\n===========================================\n"
						+ "El usuario ha ingresado correctamente al mini mercado"
						+ "\n===========================================\n");
			} catch(DayAndIdException e) {
				System.out.println("\n===========================================\n"
						+ "El usuario ingresado no le corresponde ingresar hoy"
						+ "\n===========================================");
			}
		}	
	}
	
	public String readALine() throws IOException {
		
		String line = br.readLine();
		
		return line;
	}
}
