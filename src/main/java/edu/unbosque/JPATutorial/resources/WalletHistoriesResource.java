package edu.unbosque.JPATutorial.resources;

import edu.unbosque.JPATutorial.jpa.entities.UserApp;
import edu.unbosque.JPATutorial.jpa.entities.WalletHistory;
import edu.unbosque.JPATutorial.resources.pojos.WalletHistoryPOJO;

import edu.unbosque.JPATutorial.services.WalletHistoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/users/{email}/wallet-histories")
public class WalletHistoriesResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@PathParam("email") String email, WalletHistoryPOJO walletHistoryPOJO) {

        WalletHistoryService walletHistoryService = new WalletHistoryService();

        try {
            Optional<WalletHistory> walletHistory = walletHistoryService
                    .save(email, walletHistoryPOJO.getType(), walletHistoryPOJO.getFcoins());

            if (walletHistory.isPresent()) {
                return Response
                        .status(201)
                        .entity(walletHistory.get())
                        .build();
            } else {
                return Response
                        .serverError()
                        .build();
            }
        } catch (Exception e) {
            return Response
                    .status(404)
                    .build();
        }

    }

}
