package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class User {
    String userId;
    int puntos;
    int nivel;
    String gameId;

    public User(String id) {
        this.userId = RandomUtils.getId();
        this.puntos= 50;
    }

    public String getId() {
        return this.userId;
    }

    public void setId(String id) {
        this.userId = id;
    }
    public int getPuntos() {
        return this.puntos;
    }
    public void setPuntos(int puntos){
        this.puntos =puntos;
    }
    public int getNivel() {
        return this.nivel;
    }
    public void setNivel(int nivel) {
        this.nivel=nivel;
    }
    public String getGameId() {
        return this.gameId;
    }

    public void setGameId(String id) {
        this.gameId = id;
    }
}
