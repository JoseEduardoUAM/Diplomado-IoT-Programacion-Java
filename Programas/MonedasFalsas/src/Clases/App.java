package Clases;
/**
 * Clase App
 * Descripcion:
     Clase que permite indicar el punto de arranque del programa, permite crear una instancia de la clase Gestor
     y utilizar sus metodos
 * Autor: Jose Eduardo Hernandez
*/
public class App {
    public static void main(String[] args){
        Gestor gestor = new Gestor();
        gestor.agregarMonedas();
        gestor.desordenarMonedas();
        System.out.println( "En promedio se deben tener " + gestor.obtenerResultado() );
    }
}
