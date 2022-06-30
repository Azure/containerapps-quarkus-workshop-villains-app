package com.azure.containerapps.quarkus.workshop.superheroes.villain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VillainResourceTest {

    @Test
    void shouldGetRandomVillain() {
        given()
            .when()
            .get("/api/villains/random")
            .then()
            .statusCode(OK.getStatusCode()).contentType(APPLICATION_JSON);
    }

    @Test
    public void testHelloEndpoint() {
        given()
            .when()
            .get("/api/villains/hello")
            .then()
            .statusCode(200)
            .body(is("Hello from Villain Resource"));
    }

}
