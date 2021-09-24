import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gestor {
    
    // Atributo que almacena una lista de monedas validas 
    private List<Moneda> monedasVerificadas;

    // Constructor de la Clase Gestor que permite almacenar una lista con monedas cuando se instancia
    public Gestor( List<Moneda> monedasVerificadas ) {
        this.monedasVerificadas = monedasVerificadas;
    }

    // Metodo que pemite agregar monedas a una bolsa y retornar la bolsa con monedas desordenadas
    public List<Moneda> agregarMonedas( int [] monedasValidas , int [] monedasFalsas ){
        // Lista que almacena las monedas 
        List<Moneda> bolsa = new ArrayList<Moneda>();
        // Seccion que permite generar un determinado numero de monedas falsas
        for( int i = 0 ; i < monedasFalsas.length ; i++ ){
            // Variable que almacena el valor de la moneda i
            int v = monedasVerificadas.get(i).getValor();
            for( int j = 0 ; j < monedasFalsas[i] ; j++ ){
                // Se agrega una moneda i con valor v con un peso incorrecto
                bolsa.add( new Moneda( v , (double)Math.random()*(-3)+(v+2) ) );
            }
        }
        // Seccion que permite generar un determinado numero de monedas validas
        for( int i = 0 ; i < monedasValidas.length ; i++ ){
            // Variable que almacena el valor de la moneda i
            int v = monedasVerificadas.get(i).getValor();
            // Variable que almacena el peso de la moneda i
            double p = monedasVerificadas.get(i).getPeso();
            for( int j = 0 ; j < monedasValidas[i] ; j++ ){
                // Se agrega una moneda i con valor v con un peso p
                bolsa.add( new Moneda( v , p ) );
            }
        }
        desordenarMonedas(bolsa);
        return bolsa;
    }

    // Método desordenar monedas el cual permite revolver las monedas entre las defectuosas y las correctas 
    private void desordenarMonedas( List<Moneda> bolsa ){
        for( int i = 0 ; i < 3 ; i++ ){   Collections.shuffle(bolsa);   }
    }

}
