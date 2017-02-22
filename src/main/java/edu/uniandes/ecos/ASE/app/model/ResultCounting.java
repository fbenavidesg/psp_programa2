package edu.uniandes.ecos.ASE.app.model;

/**
 * Clase que maneja el resultado del conteo
 * @author fbenavides
 */
public class ResultCounting {
    private String nameClass;
    private String pathClass;
    private int locClase;
    private int methodsClass;
    
    /**
     * Contructor de la clase, inicializa los valores
     * @param nameClass String nombre del archivo con ext
     * @param pathClass String ruta del archivo
     * @param locClase int numero de lineas de la clase
     * @param methodsClass int numero de metodos que tiene la clase
     */
    public ResultCounting(String nameClass, String pathClass, int locClase, int methodsClass) {
        this.nameClass = nameClass;
        this.pathClass = pathClass;
        this.locClase = locClase;
        this.methodsClass = methodsClass;
    }
    
    /**
     * metodo get 
     * @return nameClass String
     */
    public String getNameClass() {
        return nameClass;
    }
    
    /**
     * metodo set
     * @param nameClass String 
     */
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    
    /**
     * metodo get 
     * @return pathClass String
     */
    public String getPathClass() {
        return pathClass;
    }
    
    /**
     * metodo set
     * @param pathClass String
     */
    public void setPathClass(String pathClass) {
        this.pathClass = pathClass;
    }

    /**
     * metodo get 
     * @return locClase int
     */    
    public int getLocClase() {
        return locClase;
    }
    
    /**
     * metodo set
     * @param locClase int 
     */
    public void setLocClase(int locClase) {
        this.locClase = locClase;
    }
    
    /**
     * metodo get 
     * @return methodsClass int
     */
    public int getMethodsClass() {
        return methodsClass;
    }
    
    /**
     * metodo set
     * @param methodsClass int 
     */
    public void setMethodsClass(int methodsClass) {
        this.methodsClass = methodsClass;
    }
    
}
