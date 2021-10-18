package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Market;
import model.TD;

public class Main {
	
	private BufferedReader br;
	private Market miniMarket;
	
	//Constructor
	public Main() {
		br = new BufferedReader(new InputStreamReader(System.in));
		miniMarket = new Market();
	}

	public static void main(String[]juank) {
		
		Main ppal = new Main();
		
		System.out.println("======================================\n"
				+ "== Bienvenido a Mi Barrio Te Quiere ==\n"
				+ "===========  Mini-Mercado  ===========\n"
				+ "======================================\n\n");
		
		int option = -1;
		do {
			option = ppal.evaluateOption();
		} while(option != 0);
		
		System.out.println("Hasta la proxima nun");
		
	}
	
	public String Menu() {
		return "Escoge la opcion que desea realizar:\n"
				+ "( 1 ) Para registrar el ingreso de un usuario\n"
				+ "( 2 ) Para mostrar el numero de personas que han intentado ingresar\n"
				+ "( 3 ) Para salir del programa\n\n"
				+ "Opcion: ";
	}
	
	public int evaluateOption() {
		String line = "";
		int option = -1;
		
		do {
			System.out.print(Menu());
			
			try {
				line = readALine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(line.equals(""));
		
		option = Integer.parseInt(line);
		
		switch(option) {
		case 1:
			signInUser();
			break;
		case 2:
			System.out.println("Actualmente han intentado ingresar " + miniMarket.getCount() + " personas al mini mercado\n");
			break;
		case 3:
			option = 0;
			break;
		}
		
		return option;
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
		
		System.out.println(miniMarket.SignIn(type, id));	
	}
	
	
	
	public String readALine() throws IOException {
		
		String line = br.readLine();
		
		return line;
	}
}
