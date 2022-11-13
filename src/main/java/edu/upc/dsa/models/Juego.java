package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;
import java.util.LinkedList;
import java.util.List;

public class Juego {
    String id;
    String descripcion;
    int niveles;
    protected List<User> jugadores;
    public Juego() {
        this.id = RandomUtils.getId();
    }
    public Juego(String descripcion, int niveles) {
        this();
        this.setDescripcion(descripcion);
        this.setNiveles(niveles);
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id=id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setNiveles(int niveles) {
        this.niveles=niveles;
    }
    public int getNiveles() {
        return this.niveles;
    }
    public void addUser(String userId){
        this.jugadores.add(new User());
    }
    public List getPlayers(){
        return this.jugadores;
    }
}
