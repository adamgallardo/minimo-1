package edu.upc.dsa.util;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.User;

import java.util.List;

public interface GameManager {

    public Juego newGame(String descripcion, int niveles);
    public Juego newGame(Juego j);
    public Juego startGame(String id, String userId);
    public User getNivel(String userId);
    public int getPuntos(String userId);
    public Juego nextNivel(String userId, int Puntos,String fecha);
    public Juego endJuego(String userId);
    public List<String> players(String id);
    public Juego historial(String userId);
    public Juego actividad(String userId, String id);


}
