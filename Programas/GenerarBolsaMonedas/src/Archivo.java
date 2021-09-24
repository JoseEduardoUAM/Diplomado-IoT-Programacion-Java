/**
 * Clase Archivo
 * Descripcion:
     Clase que permite obtener datos de un archivo de texto plano con extencion .txt y agregar datos a un archivo
     de texto plano con extencion .txt
 * Autor: Jose Eduardo Hernandez
*/
import java.io.*;
import java.util.*;

public class Archivo {
    // Constructor de la clase Archivo
    public Archivo(){
    }

    // Metodo que permite agregar los datos (monedas) generadas en el programa en un archivo de texto
    public void agregarMonedasBolsa( List<Moneda> bolsa , String nombreArchivo ){  
        BufferedWriter bw = null;
        FileWriter fw = null;  
        try {
            File archivo = new File( "Bolsas/" + nombreArchivo);
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for( int i = 0 ; i < bolsa.size() ; i++ ){
                bw.write( bolsa.get(i).getValor() + " " + bolsa.get(i).getPeso() + "\n" );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } 
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
