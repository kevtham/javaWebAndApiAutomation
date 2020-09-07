package com.test.heroku;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;


public class AbstractApi {
    
    protected RequestSpecification requestSpec;
    static final String serverUrl="http://bpdts-test-app-v2.herokuapp.com";

    public void setupPort() {
      RestAssured.baseURI = serverUrl;
      RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
      this.requestSpec = given();
    }

    protected Response getResponseUsingQueryParam(final String uri, final String pathparam) {
        return this.requestSpec.accept(ContentType.JSON).when().get(uri, pathparam).then().contentType(ContentType.JSON)
            .extract().response();
      }

    protected Response getResponse(final String uri, final int expectedStatus) {
        return this.requestSpec.accept(ContentType.JSON).when().get(uri).then().contentType(ContentType.JSON)
            .statusCode(expectedStatus).extract().response();
      }
}
