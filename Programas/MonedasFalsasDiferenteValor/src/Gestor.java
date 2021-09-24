/**
 * Clase Gestor
 * Descripcion: Permite llamar al metodo de la clase Archivo para obtener los datos de las monedas autenticas, obtener 
 * el resultado cuando se tenga una bolsa de monedas e indicar mostrar el resultado mediente un metodo de la clase Visualizador
 * Autor: Jose Eduardo Hernandez
 */
import java.util.List;

public class Gestor {
    // Parametro que pemite almacenar las monedas autenticas, el valor de las monedas puede ser 1 , 2 , 5 , 10
    private List<Moneda> monedasAutenticas;
    // Parametro que permite almacenar una instancia de la clase Visualizador
    private Visualizador visualizador;

    // Constructor de la Clase Gestor que permite indicar la agregacion de monedas autenticas
    // cuando se crea una instancia de esta clase
    public Gestor() { 
        monedasAutenticas = obtenerMonedasAutenticas(); 
        visualizador = new Visualizador(monedasAutenticas);
    }

    // Metodo que permite obtener una lista de monedas autenticas
    private List<Moneda> obtenerMonedasAutenticas(){
        Archivo archivo = new Archivo();
        return archivo.obtenerDatos("MonedasAutenticas", "monedasAutenticas.txt");
    }

    // Metodo que permite obtener una moneda de una bolsa y compararla con las monedas autenticas
    public void obtenerResultado( List<Moneda> bolsa ){
        // Arreglo de enteros que permite almacenar el numero de monedas con un determinado valor
        // Monedas con valor de  1   2   5   10
        int [] monedasFalsas = new int[monedasAutenticas.size()];
        int [] monedasVerificadas = new int[monedasAutenticas.size()];
        // Variable que almacena el numero de monedas seleccionadas para obtener una falsa
        int pasos = 1;
        // Variable que almacena la suma de los pasos para obtener una moneda falsa
        int suma = 0;
        boolean monedaFalsa = false;
        for( int i = 0 ; i < bolsa.size() ; i++ ){
            // Moneda i tomada de la bolsa
            Moneda m = bolsa.get(i);
            // Seccion para comparar la moneda tomada de la bolsa con las monedas autenticas
            for( int j = 0 ; j < monedasFalsas.length ; j++ ){
                // Moneda j tomada del arreglo de las monedas autenticas
                Moneda a = monedasAutenticas.get(j);
                if( m.getValor() == a.getValor()){
                    if( m.getPeso() == a.getPeso() ){
                        monedasVerificadas[j]++;
                    }else{
                        monedasFalsas[j]++;
                        monedaFalsa = true;
                        break;
                    }
                }
            }
            if( monedaFalsa ){
                suma = suma + pasos;
                pasos = 1;
                monedaFalsa = false;
            }else{
                pasos++;
            }
        }
        visualizador.mostrarDatos(monedasFalsas, monedasVerificadas, suma, bolsa.size());
    }

}
