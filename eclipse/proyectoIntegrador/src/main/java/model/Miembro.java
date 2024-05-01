package model;

import java.util.*;


public class Miembro {
    
    private int id;
    private String nombre;
    private String apellidos;
    private int numExpediente;
    private String estudios;
    private ArrayList<Personaje> listaPersonajes;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public int getNumExpediente() {
        return numExpediente;
    }
    
    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }
    
    public String getEstudios() {
        return estudios;
    }
    
    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }
    
    public ArrayList<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }
    
    public void setListaPersonajes(ArrayList<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    } 

    public Miembro(int id, String nombre, String apellidos, int numExpediente, String estudios) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numExpediente = numExpediente;
        this.estudios = estudios;
        listaPersonajes = new ArrayList<Personaje>();
    }

    public void añadirPersonaje(Personaje personaje){
        listaPersonajes.add(personaje);
    }

    public void eliminarPersonaje(int id){
        // TODO: En caso de borrar el id, se añadiría Personaje
        listaPersonajes.remove(id);
    }
}

