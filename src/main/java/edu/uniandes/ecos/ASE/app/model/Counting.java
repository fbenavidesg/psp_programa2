package edu.uniandes.ecos.ASE.app.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para realizar el conteo de lineas
 * @author fbenavides
 */
public class Counting {
    private String pathRequire;
    private List<ResultCounting> listResultCouting = new ArrayList<ResultCounting>(); 
    
    /**
     * Constructor recibe la dirección del folder
     * @param pathRequire String ruta del folder
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Counting( String pathRequire ) throws FileNotFoundException, IOException {
        this.pathRequire = pathRequire;
        countingRun();
    }
    
    /**
     * Inicia el proceso de conteno obtiene los archivos .java y los recorre para realizar el conteo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void countingRun() throws FileNotFoundException, IOException{
        ArrayList<String> listFiles = new ArrayList<String>();
        SccanerFolder scannerFolder = new SccanerFolder();
        listFiles = scannerFolder.searchFiles(this.pathRequire);
        for (int i = 0; i < listFiles.size(); i++) {
            countingFile( listFiles.get(i) );
        }
    }
    
    /**
     * Metodo get del resultado del conteo
     * @return List de ResultCounting
     */
    public List<ResultCounting> getResultCounting(){
        return listResultCouting;
    } 
    
    /**
     * Realiza el conteo para un archivo, guardando los contadores de loc validas
     * @param filePath ruta de un archivo .java
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void countingFile( String filePath ) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int countLines = 0;
        int countPhysicalLines = 1;
        int countMethods = 0;
        while ((line = br.readLine()) != null) {
            if( isMethod(line, countPhysicalLines) ){
               countMethods++; 
            }
            if( isValide(line) ){
                countLines++;
            }
            countPhysicalLines++;
        }
        File file = new File(filePath);
        listResultCouting.add(new ResultCounting(file.getName(), filePath, countLines, countMethods));
    }
    
    /**
     * Verifica si una linea es valida para el conteo
     * @param line String texto de cada linea de código
     * @return boolean true si es valido
     */
    private boolean isValide( String line ){
        line = line.trim();
        boolean result = true;
        if( line.equals("") ){
            result = false;
        }
        if( line.length() > 1 && ( line.substring(0,2).equals("/*") || line.substring(0,2).equals("*/") || line.substring(0,2).equals("//"))){
            result = false;
        }
        if( line.length() > 0 && line.substring(0,1).equals("*")){
            result = false;
        }
        return result;
    }
    
    /**
     * busca si en la linea esta la declaración de un metodo de clase
     * @param line String cada linea de código
     * @param countPhysicalLines
     * @return boolean true si es valida
     */
    private boolean isMethod( String line, int countPhysicalLines ){
        if( line.length() > 13 && line.charAt(line.length()-1) == '{' &&
            (
                line.substring(0,11).equals("    public ")||
                line.substring(0,11).equals("    private")
            )
        ){
           return true;
        }
        return false;
    }
}
