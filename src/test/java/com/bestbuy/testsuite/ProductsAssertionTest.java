package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsAssertionTest {

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
    public void test021() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
    }


    @Test
    public void test022() {
        int total = response.extract().path("total");
        System.out.println("The value of total is : " + total);
    }

    @Test
    public void test023() {
        String name = response.extract().path("data[4].name");
        System.out.println("The name of 5th product is : " + name);
    }

    @Test
    public void test024() {
        List<String> names = response.extract().path("data.name");
        System.out.println("The name of all product are : " + names);
    }

    @Test
    public void test025() {
        List<String> ids = response.extract().path("data.id");
        System.out.println("The id of all product are : " + ids);
    }

    @Test
    public void test026() {
        List<String> dataList = response.extract().path("data");
        System.out.println("The size of the data list is : " + dataList.size());
    }
    @Test
    public void test027() {
        List<String> dataList = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("All the value of the product where product name = Energizer - MAX Batteries AA (4-Pack) are : " + dataList);
    }

    @Test
    public void test028() {
        String model = response.extract().path("data.find{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("Model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack) : " + model);
    }

    @Test
    public void test029() {
        List<HashMap<String, ?>> categories = response.extract().path("data[7].categories");
        System.out.println("All the categories of 8th products  : " + categories);
    }

    @Test
    public void test030() {
        List<HashMap<String, ?>> categories = response.extract().path("data.findAll{it.id == 150115}.categories");
        System.out.println("All the categories of the store where product id = 150115  : " + categories);
    }

    @Test
    public void test031() {
        List<String> descriptions = response.extract().path("data.description");
        System.out.println("All the descriptions of all the products  : " + descriptions);
    }

    @Test
    public void test032() {
        List<String> ids = response.extract().path("data.categories.id");
        System.out.println("Id of all the all categories of all the products  : " + ids);
    }

    @Test
    public void test033() {
        List<String> productNames = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("product names Where type = HardGood  : " + productNames);
    }


    @Test
    public void test034() {
        List<String> categories = response.extract().path("data.find{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)  : " + categories.size());
    }


    @Test
    public void test035() {
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("createdAt for all products whose price < 5.49  : " + createdAt);
    }


    @Test
    public void test036() {
        List<String> categories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
        System.out.println("name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”  : " + categories);
    }


    @Test
    public void test037() {
        List<String> manufacturers = response.extract().path("data.manufacturer");
        System.out.println("manufacturer of all the products  : " + manufacturers);
    }


    @Test
    public void test038() {
        List<String> images = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
        System.out.println("the image of products whose manufacturer is = Energizer  : " + images);
    }

    @Test
    public void test039() {
        List<String> createdAt = response.extract().path("data.findAll{it.price > 5.99}.createdAt");
        System.out.println("the createdAt for all categories products whose price > 5.99  : " + createdAt);
    }

    @Test
    public void test040() {
        List<String> urls = response.extract().path("data.url");
        System.out.println("The url of all the products  : " + urls);
    }
}