package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptions.DayAndIdException;
import exceptions.NoTIException;
import model.TD;
import model.User;

public class Main {
	
	private int day;
	private BufferedReader br;
	private List<User> usersJoined; 
	
	//Constructor
	public Main() {
		br = new BufferedReader(new InputStreamReader(System.in));
		usersJoined = new ArrayList<User>();
		
		day = LocalDateTime.now().getDayOfMonth();
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
				try {
					try {
						ppal.signInUser();
					} catch (DayAndIdException e) {
						System.out.println("El usuario no le corresponde ingresar hoy");
					}
				} catch (NoTIException e) {
					System.out.println("El tipo de documento no puede ser TI\n\n");
				}
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
	
	public void signInUser() throws NoTIException, DayAndIdException {
		
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
		
		if(Integer.parseInt(line) == 1) {
			throw new NoTIException();
		} else {
			int option = Integer.parseInt(line);
			TD type = null;
			boolean accept = false;
			
			switch(option) {
			case 1:
				type = TD.CC;
				accept = true;
				break;
			case 2:
				type = TD.PP;
				accept = true;
				break;
			case 3:
				type = TD.CE;
				accept = true;
				break;
			}
			
			if(accept) {
				String id = "";
				do {
					System.out.print("Ingrese el numero de documento de Identidad: ");
					
					try {
						id = readALine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} while(id.equals(""));
				
				User u = new User(type, id);
				
				if(day%2 == 0 && u.getPenultimate()%2 != 0) {
					
					usersJoined.add(u);
					System.out.println("El usuario ha podido ingresar correctamente");
					
				} else if(day%2 != 0 && u.getPenultimate()%2 == 0) {
					
					usersJoined.add(u);
					System.out.println("El usuario ha podido ingresar correctamente");
					
				} else {
					throw new DayAndIdException();
				}
				
			} else {
				System.out.println("Ingresa una opcion valida");
			}
		}
	}
	
	public String readALine() throws IOException {
		
		String line = br.readLine();
		
		return line;
	}
}
