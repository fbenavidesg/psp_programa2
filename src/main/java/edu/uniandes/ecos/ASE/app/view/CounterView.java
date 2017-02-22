package edu.uniandes.ecos.ASE.app.view;

import edu.uniandes.ecos.ASE.app.model.ResultCounting;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que maneja la vista
 * @author fbenavides
 */
public class CounterView {
    
    /**
     * Captura la ruta del folder
     * @return String con la ruta capturada
     */
    public String requirePath(){
        System.out.println ("Por favor introduzca la ruta del folder, Si es vacio usara ruta por defecto src:");
        String pathScanner = "";
        Scanner scannerIn = new Scanner (System.in);
        pathScanner = scannerIn.nextLine ();
        if( pathScanner.equals("") ){
            pathScanner = "src";
        }
        return pathScanner;
    }
    
    /**
     * Muestra los reultados del conteo
     * @param listResultCounting 
     */
    public void showResult( List<ResultCounting> listResultCounting ){
        int total_loc = 0;
        for (int i = 0; i < listResultCounting.size(); i++) {
            ResultCounting resultCounting = listResultCounting.get(i);
            System.out.println( "Clase: " + resultCounting.getNameClass() );
            System.out.println( "      Loc: " + resultCounting.getLocClase());
            System.out.println( "      Metodos: " + resultCounting.getMethodsClass());
            total_loc += resultCounting.getLocClase();
        }
        System.out.println( "\n\nTOTAL LOC: " + total_loc );
    }

    
}
