package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }


    @Test
    public void test011() {
        response.body("total", equalTo(51957));
    }


    @Test
    public void test012() {
        response.body("limit", equalTo(10));
    }

    @Test
    public void test013() {
        response.body("data.name", hasItem("Duracell - AAA Batteries (4-Pack)"));
    }


    @Test
    public void test014() {
        response.body("data.name", hasItems("Duracell - AA 1.5V CopperTop Batteries (4-Pack)",
                "Duracell - AA Batteries (8-Pack)",
                "Energizer - MAX Batteries AA (4-Pack)"
        ));
    }


    @Test
    public void test015() {
        response.body("data.find{it.id == 150115}.categories[2].name", equalTo("Household Batteries"));
    }


    @Test
    public void test016() {
        response.body("data.find{it.id == 333179}.categories[1].name", equalTo("Housewares"));
    }


    @Test
    public void test017() {
        response.body("data[3].price", equalTo(4.99F));
    }


    @Test
    public void test018() {
        response.body("data[5].name", equalTo("Duracell - D Batteries (4-Pack)"));
    }


    @Test
    public void test019() {
        response.body("data[8].id", equalTo(333179));
    }


    @Test
    public void test020() {
        response.body("data.find{it.id == 346575}.categories", hasSize(5));
    }

}
