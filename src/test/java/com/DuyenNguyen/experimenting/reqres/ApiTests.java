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
                                                // JSON path id doesn't match. Expected: 2 Actual: null
                                                body("id", equalTo("2")).
                                                body("email", equalTo("janet.weaver@reqres.in")).
                                                body("first_name", equalTo("Janet")).
                                                body("last_name", equalTo("Weaver")).
                                                body("avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
        response.log().body();
        log.info("Finish get single user has ID: " + id);
    }

    @Test
    public void getSingleUserNotFound() {
        log.info("Get single user not found");
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
