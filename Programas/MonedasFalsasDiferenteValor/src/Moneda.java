/**
 * Clase Moneda
 * Descripcion: Permite describir una moneda mediante sus atributos
 * Autor: Jose Eduardo Hernandez
 */
public class Moneda {

    // Atributo valor que permite almacenar el valor de la moneda
    private int valor;
    // Atributo peso que pemrite almacenar el peso de la moneda
    private double peso;
    
    // Constructor que permite agregar valores a sus atributos en el momento de instanciar 
    public Moneda(int valor,double peso) {
        this.valor = valor;
        this.peso = peso;
    }

    // Metodo que permite retornar el valor de una moneda
    public int getValor(){
        return valor;
    }
 
    // Metodo que permite retornar el peso de una moneda
    public double getPeso(){
     return peso;
    }
 
 }
