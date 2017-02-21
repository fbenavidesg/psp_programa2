/******************************************************************************/
/* Programa ID: PSP_TAREA2                                                    */
/* Autor: Fredy Benavides                                                     */
/* Fecha: 19/02/2017                                                          */
/* Descripción: Programa realiza conteo logico de loc para una ruta de folder */
/*    determinada.                                                            */
/******************************************************************************/
package edu.uniandes.ecos.ASE.app;
import edu.uniandes.ecos.ASE.app.view.CounterView;
import edu.uniandes.ecos.ASE.app.model.Counting;
import java.io.IOException;

public class App {
    
    /**
     * Metodo de entrada, funciona como el controlador de la aplicación.
     * @param args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException{
        CounterView counterView = new CounterView();
        String pathRequire = counterView.requirePath();
        Counting couting = new Counting( pathRequire );
        counterView.showResult( couting.getResultCounting() );
    }
    
}