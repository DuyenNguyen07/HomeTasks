package com.DuyenNguyen.experimenting.reqres;

import com.DuyenNguyen.experimenting.reqres.models.User;
import com.DuyenNguyen.experimenting.restAssured44.RestAssuredBaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ApiTests extends RestAssuredBaseTest {
    // Users
    private String endpointUser = "https://reqres.in/api/users";

    private String wholeListUsers = "?per_page=12";
    private String endpointWholeListUsers = endpointUser + wholeListUsers;

    private int listUserPageNumber = 2;
    private String listUsersPage = "?page=";
    private String endpointListUsersPage = endpointUser+ listUsersPage + listUserPageNumber;

    private int singleUserID = 2;
    private String endpointSingleUser = endpointUser + "/" + singleUserID;

    private int singleUserIDNotFound = 23;
    private String endpointSingleUserNotFound = endpointUser +  "/" + singleUserIDNotFound;

    private int updateUserID = 2;
    private String endpointUpdateUser = endpointUser +  "/" + updateUserID;

    private int patchUpdateUserID = 2;
    private String endpointPatchUpdateInfo = endpointUser +  "/" + patchUpdateUserID;

    private int deleteUserID = 2;
    private String endpointDeleteUser = endpointUser +  "/" + deleteUserID;

    private String endpointDelayedResponse = endpointUser + "?delay=3";

    // Resource
    private String endpointListResource = "https://reqres.in/api/unknown";

    private int singleResourceID = 2;
    private String endpointSingleResource = endpointListResource +  "/" + singleResourceID;

    private int singleResourceIDNotFound = 23;
    private String endpointSingleResourceNotFound = endpointListResource +  "/" + singleResourceIDNotFound;

    // Register
    private String endpointRegister = "https://reqres.in/api/register";

    // Log in
    private String endpointLogin = "https://reqres.in/api/login";

    @Test
    public void getListUsers() {
        log.info(" Get list users");
        var response =
                given().
                when().
                        get(endpointWholeListUsers).
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
        log.info("Finish getting list users");
    }

    @Test
        public void getSingleUser() {
        log.info("Get single user has ID: " + singleUserID);
        var response =
                given().
                when().
                        get(endpointSingleUser).
                then().
                        log().
                                body().
                                        assertThat().
                                                statusCode(200).
                                                header("Content-Type", "application/json; charset=utf-8").
                                                body("data.id", equalTo(singleUserID)).
                                                body("data.email", equalTo("janet.weaver@reqres.in")).
                                                body("data.first_name", equalTo("Janet")).
                                                body("data.last_name", equalTo("Weaver")).
                                                body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
        response.log().body();
        log.info("Finish get single user has ID: " + singleUserID);
    }

    @Test
    public void getSingleUserNotFound() {
        log.info("Get single user not found has ID: " + singleUserIDNotFound);
        var response =
                given().
                when().
                        get(endpointSingleUserNotFound).
            then().
                        assertThat().
                                statusCode(404);
        log.info("Finish getting single user not found has ID: " + singleUserIDNotFound);
    }

    @Test
    public void getListResource(){
        log.info("Get list resource");

        var response =
                given().
                when().
                        get(endpointListResource).
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
        log.info("Get single resource has ID: " + singleResourceID);
        var response =
                given().
                when().
                        get(endpointSingleResource).
                then().
                        assertThat().
                        statusCode(200).
                        body("data.id", notNullValue()).
                        body("data.name", notNullValue()).
                        body("data.year", notNullValue()).
                        body("data.color", notNullValue()).
                        body("data.pantone_value", notNullValue());
        log.info("Finish getting single resource has ID: " + singleResourceID);
    }

    @Test
    public void getSingleResourceNotFound() {
        log.info("Get single resource not found has ID: " + singleResourceIDNotFound);
        var response =
                given().
                when().
                        get(endpointSingleResourceNotFound).
                then().
                        assertThat().
                        statusCode(404);
        log.info("Finish getting single resource not found has ID: " + singleResourceIDNotFound);
    }

    @Test
    public void createUser() {
        log.info("Create an user with name and job");
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
                        post(endpointUser).

                then().
                        assertThat().
                                statusCode(201);
        response.log().body();
        log.info("Finish creating a user with name and job");
    }

    @Test
    public void updateUser(){
        log.info("Update user's information");
        User user = new User(2, "other_janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        var response =
                given().
                        body(user).
                when().
                        put(endpointUpdateUser).
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
                        patch(endpointPatchUpdateInfo).
                then().

                        log().body().
                        assertThat().
                                statusCode(200);
        log.info("Finish patching update information");
    }

    @Test
    public void removeUser() {
        log.info("Remove user has ID: " + deleteUserID);
        User user = new User(deleteUserID);
        var response =
                given().
                        header("Content-Type","application/json").
                        body(user).
                when().
                        delete(endpointDeleteUser).
                then().
                        assertThat().
                                statusCode(204);
        response.log().body();
        log.info("Finish removing user has ID: " + deleteUserID);
    }

    @Test
    public void createRegister() {
        log.info("Create register");
        User user = new User(
                "eve.holt@reqres.in",
                "pistol"
        );
        var response =
                given().
                        header("Content-Type","application/json").
                        body(user).
                when().
                        post(endpointRegister).
                then().
                        log().body().
                        assertThat().
                                statusCode(200);
        log.info("Finish creating register");

    }

    @Test
    public void createUnsuccessfulRegister() {
        log.info("Create unsuccessful register");
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
                        post(endpointRegister).
                then().
                        log().body().
                        assertThat().
                                statusCode(400);
        log.info("Finish creating unsuccessful register");
    }

    @Test
    public void createLogin() {
        log.info("Create login");
        User user = new User(
                "eve.holt@reqres.in",
                "cityslicka"
        );
        var response =
                given().
                        header("Content-Type","application/json").
                        body(user).
                when().
                        post(endpointLogin).
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
                        post(endpointLogin).
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

        given().
        when().
                get(endpointDelayedResponse).
        then().
                assertThat().
                statusCode(200);

        log.info("Finish getting delay response ");
    }

    @Test
    public void createSerializedUser() {
        log.info("Create serialized user");
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
                        post(endpointUser).
                then().
                        assertThat().
                                statusCode(201);
        response.log().body();
        log.info("Finish creating serialized user");
    }

//    @Test
//    public void createDeserializedUser() {
//        log.info("Create deserialized user");
//        String endpoint = "https://reqres.in/api/users/2";
////        User user = new User(
////                "Duyen_Nguyen@epam.com",
////                "Duyen",
////                "Nguyen",
////                "this is my avatar."
////        );
//        User actualUser =
//                given().
//                        //contentType("application/json").
//                        queryParam("id", "2").
//                when().
//                        get(endpoint).
//                                as(User.class);
//
//        log.info("Finish creating deserialized user");
//    }

}
