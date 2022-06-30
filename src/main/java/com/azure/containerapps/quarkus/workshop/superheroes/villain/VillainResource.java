package com.azure.containerapps.quarkus.workshop.superheroes.villain;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/villains")
@Tag(name = "villains")
@ApplicationScoped
public class VillainResource {

    Logger logger;

    @Inject
    public VillainResource(Logger logger) {
        this.logger = logger;
    }

    @Operation(summary = "Returns a random villain")
    @GET
    @Path("/random")
    @APIResponse(
        responseCode = "200",
        content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class, required = true))
    )
    public Response getRandomVillain() {
        logger.info("Getting a Random Villain");
        Villain villain = Villain.findRandom();
        logger.debug("Found random villain " + villain);
        return Response.ok(villain).build();
    }

    @Operation(summary = "Returns hello from the Villain Resource")
    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        logger.info("Hello from Villain Resource");
        return "Hello from Villain Resource";
    }
}
