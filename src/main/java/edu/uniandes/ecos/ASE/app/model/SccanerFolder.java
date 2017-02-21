package edu.uniandes.ecos.ASE.app.model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author fbenavides
 */
public class SccanerFolder {
    private ArrayList<String> listFiles = new ArrayList<String>();
    
    /**
     * metodo recursivo que recorre todo el directorio y extrae los archivos .java
     * @param path String ruta del folder
     * @return ArrayList de String con los dat 
     */
    public ArrayList<String> searchFiles( String path){
        File f = new File(path);
        if (f.exists()){ 
            File[] files = f.listFiles();
            for (int x=0;x<files.length;x++){
                if( files[x].isDirectory() ){
                    searchFiles( files[x].getPath() );
                }
                if( getFileExtension(files[x]).equals("java") ){
                    listFiles.add( files[x].getPath() );
                }
            }
        }
        return listFiles;
    }
    
    /**
     * metodo de apoyo para obtener la extensión de los archivos
     * @param file File
     * @return String con la extensión
     */
    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }else{
            return "";
        }
    }
}
