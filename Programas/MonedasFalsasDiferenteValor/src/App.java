/**
 * Clase App
 * Descripcion:
     Clase que permite indicar el punto de arranque del programa, permite crear una instancia de la clase Gestor, permite
     crear una instancia de la clase archivo y permite mostrar un menu para el usuario
 * Autor: Jose Eduardo Hernandez
*/
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        System.out.println("#################### Bienvenido al Detector de Monedas Falsas ####################");
        Scanner entrada = new Scanner(System.in);
        Gestor gestor = new Gestor();
        Archivo archivo = new Archivo();
        String opc;
        do{
            System.out.println("¿Que deceas realiza?");
            System.out.println("1. Detectar Monedas Falsas");
            System.out.println("2. Salir");
            opc = entrada.nextLine();
            if( opc.equals("1") ){
                System.out.println("Teclea el nombre del archivo");
                String nombreArchivo = entrada.nextLine();
                List<Moneda> bolsa = archivo.obtenerDatos("BolsaMonedas", nombreArchivo);
                gestor.obtenerResultado(bolsa);
            }else if( opc.equals("2") ){
                System.out.println("Adios");
            }else{
                System.out.println( opc + " no es una opcion valida, vuelva a intentar" );
            }
        }while( !opc.equals("2"));
        entrada.close();
    }
}
