package namegenerator;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generator {
	
	private String [] apellidos = {"Lima", "Casaux", "Aimar", "Cala", "Lopez","Perez", "Diaz", 
			"Salas", "Dominguez", "Morgera", "Talavera", "Fernandez", 
			"Gonzalez", "Estevez", "Godin", "Messi", "Suarez"};
	private String [] nombres = {"Maxi", "Nico", "Diego", "Federico", "Lautaro", "Macarena", "Lucia",
		"Carla", "Julieta", "Juan", "Carlos", "Esteban", "Alan", "Paula", "Monica",
		"Sebastian", "Lara", "Lionel", "Silvia", "Gustavo"};
	
	public static void main(String[] args) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter("h_clinicas.in"));
		Random rand = new Random();
		Generator gen = new Generator();
		
		salida.println(40000);
		
		for (int i = 0; i < 40000; i++) {
			
			salida.print(rand.nextInt(500000-1)+1);
			salida.print(" "+gen.getApellidos()+" ");
			salida.println(gen.getNombres());
		}
		
		salida.close();

	}

	public String getApellidos() {
		int rnd = new Random().nextInt(apellidos.length);
		return apellidos[rnd];
	}

	public String getNombres() {
		int rnd = new Random().nextInt(nombres.length);
		return nombres[rnd];
	}
	
	

}
