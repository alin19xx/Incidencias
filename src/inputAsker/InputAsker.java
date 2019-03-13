package inputAsker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputAsker {

	public InputAsker() {
		
	}
	
	/**
     * Metodo que pide un entero por teclado Como parametro se le pasa un texto
     * que sera el mensaje para el usuario
     *
     * @param texto
     * @return
     */
    public static int pedirEntero(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean error;
        do {
            try {
                System.out.println(texto);
                num = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("Debes introducir un número entero del 0 al 11.");
                error = true;
            }
        } while (error);
        return num;
    }

    /**
     * Metodo que pide una cadena por teclado Como parametro se le pasa un texto
     * que sera el mensaje para el usuario
     *
     * @param texto
     * @return
     */
    public static String pedirCadena(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        do {
            try {
                System.out.println(texto);
                cadena = br.readLine();
                if (cadena.equals("")) {
                    System.out.println("No se puede dejar el campo en blanco.");
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
            }
        } while (cadena.equals(""));
        return cadena;
    }
	
}
