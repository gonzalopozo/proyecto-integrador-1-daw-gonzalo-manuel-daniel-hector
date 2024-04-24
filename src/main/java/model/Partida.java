package model;

import java.util.*;

public class Partida {

    private int id;
    private String nombre;
    private int gameMasterId;
    private String ambientacion;
    private boolean estaEnCurso;
    private int numSesion;
    private int duracion;
    private Date fecha;
    private ArrayList<Personaje> listaPersonajesPartida;
    
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
    
    public int getGameMasterId() {
        return gameMasterId;
    }
    
    public void setGameMasterId(int gameMasterId) {
        this.gameMasterId = gameMasterId;
    }
    
    public String getAmbientacion() {
        return ambientacion;
    }
    
    public void setAmbientacion(String ambientacion) {
        this.ambientacion = ambientacion;
    }
    
    public boolean isEstaEnCurso() {
        return estaEnCurso;
    }
    
    public void setEstaEnCurso(boolean estaEnCurso) {
        this.estaEnCurso = estaEnCurso;
    }
    
    public int getNumSesion() {
        return numSesion;
    }
    
    public void setNumSesion(int numSesion) {
        this.numSesion = numSesion;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public ArrayList<Personaje> getListaPersonajesPartida() {
        return listaPersonajesPartida;
    }
    
    public void setListaPersonajesPartida(ArrayList<Personaje> listaPersonajesPartida) {
        this.listaPersonajesPartida = listaPersonajesPartida;
    }
    

    public Partida(int id, String nombre, int gameMasterId, String ambientacion, boolean estaEnCurso, int numSesion, int duracion, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.gameMasterId = gameMasterId;
        this.ambientacion = ambientacion;
        this.estaEnCurso = estaEnCurso;
        this.numSesion = numSesion;
        this.duracion = duracion;
        this.fecha = fecha;
        listaPersonajesPartida = new ArrayList<Personaje>();
    }

    public void añadirPersonaje(Personaje personaje){
        listaPersonajesPartida.add(personaje);
    }

    public void eliminarPersonaje(int id){
        // TODO: En caso de borrar el id, se añadiría Personaje
        listaPersonajesPartida.remove(id);
    }
}     
