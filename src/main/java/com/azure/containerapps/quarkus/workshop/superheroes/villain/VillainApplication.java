package com.azure.containerapps.quarkus.workshop.superheroes.villain;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
    info = @Info(title = "Villain API", description = "This API returns a random villain.", version = "1.0"),
    servers = {
        @Server(url = "http://localhost:8701", description = "Local server")
    }
)
public class VillainApplication extends Application {
}
