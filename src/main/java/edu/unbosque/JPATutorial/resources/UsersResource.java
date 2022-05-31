package edu.unbosque.JPATutorial.resources;

import edu.unbosque.JPATutorial.jpa.entities.UserApp;
import edu.unbosque.JPATutorial.resources.pojos.UserPOJO;

import edu.unbosque.JPATutorial.services.UserAppService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/users")
public class UsersResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(UserPOJO userPOJO) {

        UserAppService userAppService = new UserAppService();
        Optional<UserApp> userApp = userAppService.save(userPOJO.getEmail(), userPOJO.getPassword(), userPOJO.getName(), userPOJO.getRole());

        if (userApp.isPresent()) {
            return Response
                    .status(201)
                    .entity(userApp.get())
                    .build();
        } else {
            return Response
                    .serverError()
                    .build();
        }
    }

}