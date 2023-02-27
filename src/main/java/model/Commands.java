/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diogo
 */
public class Commands {
    private int id;
    private String name;
    private String description;
    private String funcion;
    //private static final Logger LOG = Logger.getLogger(Commands.class.getName());

    /*
    public Commands(int id, String name, String description, String funcion) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.funcion = funcion;
    }
    
    public Commands(){
        
    }
    */
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
  

   
   
    
    
}
 