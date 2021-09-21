/**
 * Clase Gestor
 * Descripcion:
     Clase que permite facilitar el trabajo de agregar monedas, desordenarlas y obtener el resultado del problema
 * Autor: Jose Eduardo Hernandez
*/
package Clases;

import java.util.*;

public class Gestor {
    // Parametro de la clase Gestor
    private List<Moneda> banco;
    // Constructor de la clase Gestor (NO requiere atributos cuando se crea una instancia)
    public Gestor() {   banco = new ArrayList<Moneda>();   }
    // Método agregarMonedas el cual permite crear 20 monedas defectuosas y 180 correctas
    public void agregarMonedas() {
        int defectuosas = 20;
        for (int i = 0; i < 200; i++) {
            banco.add(  defectuosas > 0 ? new Moneda( 10 , (double)Math.random()*(8-12+1)+12 ) : new Moneda( 10 , 10.329) );
            defectuosas = defectuosas > 0 ? defectuosas - 1 : defectuosas;
        }
    }
    // Método desordenar monedas el cual permite revolver las monedas entre las defectuosas y las correctas 
    public void desordenarMonedas(){
        for( int i = 0 ; i < 3 ; i++ ){   Collections.shuffle(banco);   }
    }
    // Método obtenerResultado el cual permite seleccionar monedas e indicar el numero maximo, minimo y promedio para obtener una 
    // moneda defectuosa
    public double obtenerResultado(){
        int suma = 0, pasos = 1, pasoMinimo = 200, pasoMaximo = 1;
        for( int i = 0 ; i < banco.size() ; i++ ){
            if( banco.get(i).getPeso() != 10.329 ){
                pasoMinimo = ( pasos < pasoMinimo ? pasos : pasoMinimo); 
                pasoMaximo = ( pasos > pasoMaximo ? pasos : pasoMaximo); 
                suma = suma + pasos;
                pasos = 1;
            }else{
                pasos++;
            }
        }
        System.out.println( "Numero de pasos Minimos " + pasoMinimo + "\nNumero de pasos Maximos " + pasoMaximo );
        return (double)( suma / 20 );
    }

}
