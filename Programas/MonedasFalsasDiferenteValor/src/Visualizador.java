/**
 * Clase Moneda
 * Descripcion:
     Clase que permite mostrar los datos obtenidos al analizar una bolsa con monedas
 * Autor: Jose Eduardo Hernandez
*/

import java.util.List;

public class Visualizador {

    // Atributo que permite almacenar la lista de monedas autenticas
    private List<Moneda> monedasAutenticas;

    // Constructor que permite agregar la lista en el momento de instanciar 
    public Visualizador(List<Moneda> monedasAutenticas) {
        this.monedasAutenticas = monedasAutenticas;
    }

    // Metodo que permite mostrar los datos obtenidos
    public void mostrarDatos( int [] monedasFalsas , int [] monedasVerificadas , int suma , int elementos ){
        System.out.println("\u001B[32m##############################################");
        System.out.println("Para esta bolsa con " + elementos + " elementos se obtuvo lo siguiente:");
        System.out.println("-----------------------------------------");
        for( int i = 0 ; i < monedasAutenticas.size() ; i++ ){
            System.out.println(monedasVerificadas[i] + " Monedas verificadas de " + monedasAutenticas.get(i).getValor() + " pesos" );
        }
        System.out.println("-----------------------------------------");
        for( int i = 0 ; i < monedasAutenticas.size() ; i++ ){
            System.out.println(monedasFalsas[i] + " Monedas falsas de " + monedasAutenticas.get(i).getValor() + " pesos" );
        }
        System.out.println("-----------------------------------------");
        int totalMonedas = 0;
        for( int i = 0 ; i < monedasFalsas.length ; i++ ){
            totalMonedas = totalMonedas + monedasFalsas[i];
        }
        System.out.println("En promedio se puede tener una moneda falsa cada " + ( suma / totalMonedas ) + " pasos");
        System.out.println("##############################################\u001B[37m");
    }

}
