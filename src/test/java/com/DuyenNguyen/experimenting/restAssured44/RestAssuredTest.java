package com.DuyenNguyen.experimenting.restAssured44;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class RestAssuredTest extends RestAssuredBaseTest {
    String baseUrl = "http://api.weatherapi.com/v1";
    RequestSpecBuilder spec = new RequestSpecBuilder();

    @Test
    public void testingRestAssuredSimpleEndPointVerification() throws InterruptedException {
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("q", "Tokyo");
        Response rp = RestAssured.given(spec.build()).get("/forecast.json");
        rp.then().log().body();

        rp.then().body("location.name", Matchers.is("Tokyo"));
    }

    // Content-type
    @Test
    public void testContentType() throws InterruptedException {
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("q", "Tokyo");
        Response rp = RestAssured.given(spec.build()).get("/forecast.json");
        System.out.println("The content-type is "+ rp.getContentType());
        rp.then().assertThat().contentType("application/json");
    }

    // Response time
    @Test
    public void testResponseTime() throws InterruptedException {
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("q", "Tokyo");
        Response rp = RestAssured.given(spec.build()).get("/forecast.json");
        System.out.println("The response time is "+ rp.getTime() + " ms");
        System.out.println("The response time is "+ rp.timeIn(TimeUnit.MILLISECONDS) + " ms");
    }

    // Status code
    @Test
    public void testStatusCode() throws InterruptedException {
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("q", "Tokyo");
        Response rp = RestAssured.given(spec.build()).get("/forecast.json");
        System.out.println("The status code is "+ rp.getStatusCode());
        rp
                .then()
                .assertThat()
                .statusCode(200);
    }

    // Current country
    @Test
    public void testCountry() {
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("q", "Ho Chi Minh");
        Response rp = RestAssured.given(spec.build()).get("/current.json");
        rp.then().log().all();
        rp.then().assertThat().log().all().body("location.country", equalTo("Vietnam"));
    }

    // Location name
    @Test
    public void testLocationName() {
        spec
                .setBaseUri(baseUrl)
                //.addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "auto:ip")
                .addParam("days", "10")
                .addParam("dt", "2021-10-26");
        Response rp = RestAssured.given(spec.build()).get("/current.json");
        //log.info("gaugau");
        rp.then().assertThat().log().all().body("location.name", equalTo("Hanh Thong Tay"));
    }

    @Test
    public void sampleTest() {
//        String baseUrl = "http://api.weatherapi.com/v1";
//        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                //.addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "auto:ip")
                .addParam("days", "10")
                .addParam("dt", "2021-10-26");
        Response rp = RestAssured.given(spec.build()).get("/current.json");
        //log.info("gaugau");
        rp.then().assertThat().log().all().body("location.name", equalTo("Hanh Thong Tay"));
    }

}
