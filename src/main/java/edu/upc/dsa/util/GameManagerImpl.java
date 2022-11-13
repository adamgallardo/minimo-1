package edu.upc.dsa.util;

import java.util.LinkedList;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.User;
import java.util.List;
import org.apache.log4j.Logger;

public class GameManagerImpl implements GameManager{

    private static GameManager instance;
    protected List<Juego> juegos;
    protected List<User> usuarios;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);
    private GameManagerImpl() {
        this.juegos = new LinkedList<>();
    }
    public static GameManager getInstance() {
        if (instance==null) instance = new GameManagerImpl();
        return instance;
    }
    public int size() {
        int ret = this.juegos.size();
        logger.info("size " + ret);

        return ret;
    }
    @Override
    public Juego newGame(String descripcion, int niveles) {
        return this.newGame(new Juego(descripcion, niveles));
    }
    public Juego newGame(Juego j){
        logger.info("new game " + j);

        this.juegos.add (j);
        logger.info("new Juego added");
        return j;
    }
    @Override
    public Juego startGame(String id, String userId) {
        for (Juego j: this.juegos){
            if (j.getId().equals(id)){
                j.addUser(userId);
            }
        }
        return null;
    }
    @Override
    public int getNivel(String userId) {
        logger.info("getNivel("+userId+")");

        for (User u: this.usuarios) {
            if (u.getId().equals(userId)) {
                logger.info("getNivel("+userId+"): "+u);

                return u.getNivel();
            }
        }

        logger.warn("not found or already in a game" + userId);
        return 0;
    }
    @Override
    public int getPuntos(String userId) {
        logger.info("getPuntos("+userId+")");
        for (User u: this.usuarios) {
            if (u.getId().equals(userId)) {
                logger.info("getPuntos("+userId+"): "+u);
                return u.getPuntos();
            }
        }
        logger.warn("not found or already in a game" + userId);
        return 0;
    }
    @Override
    public Juego nextNivel(String userId, int puntos, String fecha) {
        logger.info("nextNivel("+userId+")");
        for (User u: this.usuarios) {
            if (u.getId().equals(userId)) {
                logger.info("nextNivel("+userId+"): "+ u + fecha);
                u.setPuntos(puntos);
                u.setNivel(u.getNivel() + 1);
                }
            }
        logger.warn("not found or already in a game" + userId);
        return null;
    }
    @Override
    public Juego endJuego(String userId) {
        return null;
    }
    @Override
    public List<String> players(String id) {
        logger.info("Lista Jugadores("+id+")");
        for (Juego j: this.juegos) {
            if (j.getId().equals(id)) {
                logger.info("Lista Jugadores("+id+"): "+ j);
                return j.getPlayers();
            }
        }
        return null;
    }
    @Override
    public Juego historial(String userId) {
        return null;
    }
    @Override
    public Juego actividad(String userId, String id) {
        return null;
    }
}
