package namegenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.TreeSet;

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
		long total = 0;
		
		TreeSet<Integer> arbol = new TreeSet<Integer>();
		
		for (int i = 0; i < 50000; i++) {
			
			if(arbol.add(rand.nextInt(500000-1)+1))
				total++;
		}
		
		salida.println(total);
		
		for (int i = 0; i < total; i++) {
			
			if(i%2 == 0){
				salida.print(arbol.first());
				arbol.remove(arbol.first());
			}
			else{
				salida.print(arbol.last());
				arbol.remove(arbol.last());
			}
			
			
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
