package codigoJhon;

import java.util.Scanner;

public class juego {

	public static void main(String[] args) {
		int iteradorCategorias = 0;
		int puntaje = 0;
		String pregunta = "";
		String respuesta = "";
		String continuar = "y";
		String nombre = "";
		boolean flag = true;
		//Creando instancias
		Jugador objJugador = new Jugador();
		DataExcel objExcel = new DataExcel();
		ExcelPuntaje objPuntaje = new ExcelPuntaje();
		
		Scanner in = new Scanner (System.in); //Creando objeto Scanner
		System.out.println("Ingrese su nombre: ");	    
		nombre = in.nextLine();
		objJugador.setNombre(nombre);
		while(flag && iteradorCategorias<5) {
			GetUniqueRandomNumbers objRandom = new GetUniqueRandomNumbers();
			int numRandom = objRandom.obtenerRandom();
	        pregunta = objExcel.obtenerPregunta(iteradorCategorias, numRandom);
	        String[] parts = pregunta.split(";");
	        System.out.println("");
	        for(int k=0;k<5;k++) {
	        	System.out.println(parts[k]);
	        }
	        System.out.println("");
 	        System.out.println("¿Desea responder? [y/n] ");	    
 	        continuar = in.nextLine();
 	        if(!continuar.equals("y"))
 	        	break;
	        System.out.println("Seleccione una opcion: ");
	        respuesta = in.nextLine (); 
	        if(parts[5].equals(respuesta)) {
	        	System.out.println("Respuesta Correcta");
	 	       iteradorCategorias++;
	 	        puntaje += 100*iteradorCategorias;
	 	       System.out.println("");
	 	       System.out.println("Puntaje acumulado: "+puntaje);
	        }else {
	        	System.out.println("Respuesta Incorrecta");
	        	puntaje = 0;
	        	flag=false;
	        }
		}
		System.out.println("");
		System.out.println("Puntaje obtenido: "+puntaje);
		objJugador.setPuntaje(puntaje);
		objPuntaje.guardarPuntaje();
		in.close();
	}
}
