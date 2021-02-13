package com.refactorizando.example.openapi.swaggerui.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class CarResourceTest {

    @Test
    public void testList() {
        given()
            .when().get("/cars")
            .then()
            .statusCode(200)
            .body("$.size()", is(2),
                "brand", containsInAnyOrder("Ford", "Renault"));
    }

    @Test
    public void testAdd() {
    given()
        .body(
            "{\n"
                + "  \"brand\": \"Ford\",\n"
                + "  \"color\": \"Black\",\n"
                + "  \"id\": 0,\n"
                + "  \"model\": \"Mustang\"\n"
                + "}")
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .post("/cars")
        .then()
        .statusCode(200)
        .body(
            "$.size()",
            is(3),
            "brand",
            containsInAnyOrder("Ford", "Renault", "Ford"),
            "model",
            containsInAnyOrder("Mustang", "Megane", "Mustang"));

        given()
            .body(
                "{\n"
                    + "  \"brand\": \"Ford\",\n"
                    + "  \"color\": \"Black\",\n"
                    + "  \"id\": 0,\n"
                    + "  \"model\": \"Mustang\"\n"
                    + "}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when()
            .delete("/cars")
            .then()
            .statusCode(200)
            .body(
                "$.size()",
                is(2),
                "brand",
                containsInAnyOrder("Ford", "Renault"),
                "model",
                containsInAnyOrder("Mustang", "Megane"));
    }
}