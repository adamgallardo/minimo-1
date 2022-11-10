package edu.upc.dsa.services;
import edu.upc.dsa.util.GameManager;
import edu.upc.dsa.util.GameManagerImpl;
import edu.upc.dsa.util.GameManagerImpl;
import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/games", description = "Endpoint to Game Service")
@Path("/games")
public class GamesService {
    private GameManager gm;

    public GamesService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.size()==0) {
            this.gm.newGame("Juego de rol", 5);
            this.gm.newGame("Shooter", 10);
        }
    }
    @POST
    @ApiOperation(value = "create a new Game", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Juego.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Juego j) {

        if (j.getDescripcion()==null || j.getNiveles()==0)  return Response.status(500).entity(j).build();
        this.gm.newGame(j);
        return Response.status(201).entity(j).build();
    }

    @GET
    @ApiOperation(value = "get the level", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("userId") String userId) {
        User nivel = this.gm.getNivel(userId);
        if (nivel == null) return Response.status(404).build();
        else  return Response.status(201).entity(nivel).build();
    }


}
