/**
 * Clase Archivo
 * Descripcion:
     Clase que permite obtener datos de un archivo de texto plano con extencion .txt 
 * Autor: Jose Eduardo Hernandez
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
    // Constructor de la clase Archivo
    public Archivo() {
    }
    // Metodo que permite obtener los datos de un archivo
    public List<Moneda> obtenerDatos(String carpeta, String nombreArchivo){
        // Lista que almacena monedas
        List<Moneda> lista = new ArrayList<Moneda>();
        try {
            Scanner entrada = new Scanner(new File(carpeta+"/"+nombreArchivo));
            // Se obtiene los datos de cada linea del archivo
            while( entrada.hasNext() ){
                String [] linea = entrada.nextLine().split(" ");
                lista.add( new Moneda( Integer.parseInt(linea[0]) , Double.parseDouble(linea[1]) ) );
            }
        // Manejador de error
        } catch (FileNotFoundException ex) {
            System.out.println("En la clase Archivo:\n" + ex);
        }
        return lista;
    }

}
