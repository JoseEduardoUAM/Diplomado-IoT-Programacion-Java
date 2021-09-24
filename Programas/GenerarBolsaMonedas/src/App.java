/**
 * Clase App
 * Descripcion:
     Clase que permite indicar el punto de arranque del programa
 * Autor: Jose Eduardo Hernandez
*/
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        // Instancia de la clase Archivo
        Archivo archivo = new Archivo();
        // Lista que almacena las monedas validas verificadas y seran utilizadas como comparadoras
        List<Moneda> monedasVerificadas = archivo.obtenerDatos("MonedasAutenticas", "monedasAutenticas.txt");
        // Instancia de la clase gestor
        Gestor gestor = new Gestor( monedasVerificadas );
        // Variable que almacena las opcines del usuario para el menu
        String opc;

        do{
            System.out.println("######################## Bienvenido al generador de bolsas con monedas ########################");
            System.out.println("¿Que decea realiza?");
            System.out.println("1. Crear Nueva Bolsa Con Monedas");
            System.out.println("2. Salir");
            opc = entrada.nextLine();
            // Opcion para iniciar el proceso que agrega monedas validas e invalidas
            if( opc.equals("1") ){
                System.out.println("\u001B[32m***********************************************************");
                int [] monedasValidas = new int[monedasVerificadas.size()];
                int [] monedasFalsas = new int[monedasVerificadas.size()];
                for( int i = 0 ; i < monedasVerificadas.size() ; i++ ){
                    int valorMoneda = monedasVerificadas.get(i).getValor();
                    System.out.print("Ingrese el número de monedas validas con valor de " + valorMoneda+ " : ");
                    monedasValidas[i] = Integer.parseInt(entrada.nextLine());
                    System.out.print("Ingrese el número de monedas falsas con valor de " + valorMoneda + " : ");
                    monedasFalsas[i] = Integer.parseInt(entrada.nextLine());
                }
                List<Moneda> bolsa = gestor.agregarMonedas(monedasValidas, monedasFalsas);
                System.out.print("Ingrese el nombre del archivo ");
                String nombreArchivo = entrada.nextLine();
                archivo.agregarMonedasBolsa(bolsa, nombreArchivo);
                System.out.println("***********************************************************\u001B[37m");
            // Opcion para salir del programa
            }else if( opc.equals("2") ){
                System.out.println("¡Adios!");
            // Opcion para indicar que la entrada no es valida
            }else{
                System.out.println( opc + " No es una opcion valida");
            }
        }while( !opc.equals("2") );

        entrada.close();
    }
}
