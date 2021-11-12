package com.DuyenNguyen.experimenting.reqres;

import com.DuyenNguyen.experimenting.reqres.models.User;
import com.DuyenNguyen.experimenting.restAssured44.RestAssuredBaseTest;
import com.sun.xml.bind.v2.TODO;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ApiTests extends RestAssuredBaseTest {

    @Test
    public void getListUsers() {
        log.info(" Get list users");
        String endpoint = "https://reqres.in/api/users?per_page=12"; // whole list
        var response =
                given().
                when().
                        get(endpoint).
                then().
                        log().
                                body().
                                        assertThat().
                                                statusCode(200).
                                                body("data.size()",greaterThan(0)).
                                                body("data.email", everyItem(notNullValue())).
                                                body("data.first_name", everyItem(notNullValue())).
                                                body("data.last_name", everyItem(notNullValue())).
                                                body("data.avatar", everyItem(notNullValue()));
        response.log().body();
        log.info("Finish getting list users");
    }

    @Test
        public void getSingleUser() {
        int id = 2;
        log.info("Get single user has ID: " + id);
        String endpoint = "https://reqres.in/api/users/" + id;
        var response =
                given().
                when().
                        get(endpoint).
                then().
                        log().
                                body().
                                        assertThat().
                                                statusCode(200).
                                                header("Content-Type", "application/json; charset=utf-8").
                                                body("data.id", equalTo(2)).
                                                body("data.email", equalTo("janet.weaver@reqres.in")).
                                                body("data.first_name", equalTo("Janet")).
                                                body("data.last_name", equalTo("Weaver")).
                                                body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
        response.log().body();
        log.info("Finish get single user has ID: " + id);
    }

    @Test
    public void getSingleUserNotFound() {
        log.info("Get single user not found");
        int id = 23;
        String endpoint = "https://reqres.in/api/users/" + id;
        var response =
                given().
                when().
                        get(endpoint).
            then().
                        assertThat().
                                statusCode(404);
        log.info("Finish getting single user not found");
    }

    @Test
    public void getListResource(){
        log.info("Get list resource");
        String endpoint = "https://reqres.in/api/unknown";
        var response =
                given().
                when().
                        get(endpoint).
                then().
                        assertThat().
                                statusCode(200).
                                body("data.size()", greaterThan(0)).
                                body("data.id", everyItem(notNullValue())).
                                body("data.name", everyItem(notNullValue())).
                                body("data.year", everyItem(notNullValue())).
                                body("data.color", everyItem(notNullValue())).
                                body("data.pantone_value", everyItem(notNullValue()));
        log.info("Finish getting list resource");
    }

    @Test
    public void getSingleResource() {
        int id = 2;
        log.info("Get single resource has ID: " + id);
        String endpoint = "https://reqres.in/api/unknown/" + id;
        var response =
                given().
                when().
                        get(endpoint).
                then().
                        assertThat().
                        statusCode(200).
                        body("data.id", notNullValue()).
                        body("data.name", notNullValue()).
                        body("data.year", notNullValue()).
                        body("data.color", notNullValue()).
                        body("data.pantone_value", notNullValue());
        log.info("Finish getting single resource has ID: " + id);
    }

    @Test
    public void getSingleResourceNotFound() {
        log.info("Get single resource not found");
        int id = 23;
        String endpoint = "https://reqres.in/api/unknown/" + id;
        var response =
                given().
                when().
                        get(endpoint).
                then().
                        assertThat().
                        statusCode(404);
        log.info("Finish getting single resource not found");
    }

    @Test
    public void createUser() {
        log.info("Create an user with name and job");
        String endpoint = "https://reqres.in/api/users";
        //User user = new User("Duyen", "student");
        String body = """
                {
               "name": "Duyen",
               "job": "student"
                }
                """;
        var response =
                given().
                        header("Content-Type", "application/json").
                        body(body).
                when().
                        post(endpoint).

                then().
                        assertThat().
                                statusCode(201);
        response.log().body();
        log.info("Finish creating a user with name and job");
    }

    @Test
    public void updateUser(){
        log.info("Update user's information");
        String endpoint = "https://reqres.in/api/users/";
        User user = new User(2, "other_janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        var response =
                given().
                        body(user).
                when().
                        put(endpoint).
                then().
                        log().body().
                                assertThat().
                                        statusCode(200);
        response.log().body();
        log.info("Finish updating user's information");
    }

    @Test
    public void patchUpdateInformation(){
        log.info("Patch update information");
        String endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
               "name": "Duyen",
               "job": "student"
                }
                """;
        var response =
                given().
                        contentType("application/json").
                        body(body).
                when().
                        patch(endpoint).
                then().

                        log().body().
                        assertThat().
                                statusCode(200);
        log.info("Finish patching update information");
    }

    @Test
    public void removeUser() {
        int id = 2;
        log.info("Remove user has ID: " + id);
        String endpoint = "https://reqres.in/api/users/" + id;
        User user = new User(id);
        var response =
                given().
                        header("Content-Type","application/json").
                        body(user).
                when().
                        delete(endpoint).
                then().
                        assertThat().
                                statusCode(204);
        response.log().body();
        log.info("Finish removing user has ID: " + id);
    }

    @Test
    public void createRegister() {
        log.info("Create register");
        String endpoint = "https://reqres.in/api/register";
        User user = new User(
                "eve.holt@reqres.in",
                "pistol"
        );
        var response =
                given().
                        header("Content-Type","application/json").
                        body(user).
                when().
                        post(endpoint).
                then().
                        log().body().
                        assertThat().
                                statusCode(200);
        log.info("Finish creating register");

    }

    @Test
    public void createUnsuccessfulRegister() {
        log.info("Create unsuccessful register");
        String endpoint = "https://reqres.in/api/register";
        String body = """
                {
                "email": "sydney@fife" 
                }
                """;
        var response =
                given().
                        header("Content-Type","application/json").
                        body(body).
                when().
                        post(endpoint).
                then().
                        log().body().
                        assertThat().
                                statusCode(400);
        log.info("Finish creating unsuccessful register");
    }

    @Test
    public void createLogin() {
        log.info("Create login");
        String endpoint = "https://reqres.in/api/login";
        User user = new User(
                "eve.holt@reqres.in",
                "cityslicka"
        );
        var response =
                given().
                        header("Content-Type","application/json").
                        body(user).
                when().
                        post(endpoint).
                then().
                        log().body().
                        assertThat().
                                statusCode(200).
                                body("token", equalTo("QpwL5tke4Pnpja7X4"));
        log.info("Finish creating login");
    }

    @Test
    public void createUnsuccessfulLogin() {
        log.info("Create unsuccessful login");
        String endpoint = "https://reqres.in/api/login";
        String body = """
                {
                "email": "peter@klaven" 
                }
                """;
        var response =
                given().
                        header("Content-Type","application/json").
                        body(body).
                when().
                        post(endpoint).
                then().
                        log().body().
                        assertThat().
                                statusCode(400).
                                body("error", equalTo("Missing password"));
        log.info("Finish creating unsuccessful login");
    }

    @Test
    public void getDelayResponse() {
        log.info("Get delay response");
        String endpoint = "https://reqres.in/api/users?delay=3";
        var response =
                given().
                when().
                        get(endpoint).
                then().
                        assertThat().
                        statusCode(200);
        log.info("Finish getting delay response ");
    }

    @Test
    public void createSerializedUser() {
        log.info("Create serialized user");
        String endpoint = "https://reqres.in/api/users";
        User user = new User(
                "Duyen_Nguyen@epam.com",
                "Duyen",
                "Nguyen",
                "this is my avatar."
        );
        var response =
                given().
                        contentType("application/json").
                        body(user).
                when().
                        post(endpoint).
                then().
                        assertThat().
                                statusCode(201);
        response.log().body();
        log.info("Finish creating serialized user");
    }


}
