/**
 * Clase Moneda
 * Descripcion:
     Clase que permite describir un objeto moneda 
 * Autor: Jose Eduardo Hernandez
*/
package Clases;

public class Moneda {
    // Parametros de la clase Moneda
    private int valor;
    private double peso;
    // Constructor del Objeto Moneda (requiere atributos cuando se crea una instancia)
    public Moneda(int valor,double peso) {
        this.valor = valor;
        this.peso = peso;
    }
    // Método que permite obtener el valor de una moneda (valor entero)
    public int getValor() {
        return valor;
    }
    // Método que permite obtener el peso de una moneda (valor double)
    public double getPeso() {
        return peso;
    }

}
