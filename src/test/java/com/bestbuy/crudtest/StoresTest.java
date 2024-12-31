package com.bestbuy.crudtest;

import com.bestbuy.model.StorePojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StoresTest extends TestBase {

    static String name = "Dunelm Store" + TestUtils.getRandomValue();
    static String type = "Furniture" + TestUtils.getRandomValue();
    static String address = "32, Studley villa" + TestUtils.getRandomValue();
    static String address2 = "";
    static String city = "Solihull";
    static String state = "West mid";
    static String zip = TestUtils.getRandomValue();
    static double lat = 44.898855;
    static double lng = -36.556651;
    static String hours = "Mon: 9-10; Tue: 9-10; Wed: 9-10; Thurs: 9-10; Fri: 9-10; Sat: 11-6; Sun: 12-5";

    @Test
    public void test001() {
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        Response response = given().log().ifValidationFails()
                .header("Content-Type", "application/json")
                .when()
                .body(storePojo)
                .post();
        response.prettyPrint();
        response.then().log().ifValidationFails().statusCode(201);
    }

    @Test
    public void test002() {
        Response response = given()
                .when()
                .get();

        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test003() {
        String name = StoresTest.name + "Updated";
        String type = StoresTest.type + "Updated";
        String address = StoresTest.address + "Updated";
        String address2 = StoresTest.address2;
        String city = StoresTest.city + "Updated";
        String state = StoresTest.state + "Updated";
        String zip = TestUtils.getRandomValue();
        double lat = 44.898855;
        double lng = -36.556651;
        String hours = "Mon: 9-10; Tue: 9-10; Wed: 9-10; Thurs: 9-10; Fri: 9-10; Sat: 11-6; Sun: 12-5";

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        Response response = given().log().ifValidationFails()
                .header("Content-Type", "application/json")
                .pathParam("id", 18)
                .when()
                .body(storePojo)
                .put("/{id}");
        response.prettyPrint();
        response.then().log().ifValidationFails().statusCode(200);

    }

    @Test
    public void test004(){
        given().log().ifValidationFails()
                .pathParam("id", 8922)
                .when()
                .delete("/{id}")
                .then().log().ifValidationFails().statusCode(201);
        given()
                .pathParam("id", 8922)
                .when()
                .get("/{id}")
                .then()
                .statusCode(404);
    }



}
