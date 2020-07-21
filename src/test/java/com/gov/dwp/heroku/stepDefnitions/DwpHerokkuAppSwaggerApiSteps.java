package com.gov.dwp.heroku.stepDefnitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.gov.dwp.heroku.AbstractApi;
import com.gov.dwp.heroku.model.Instruction;
import com.gov.dwp.heroku.model.UserId;
import com.jayway.restassured.response.Response;

import io.cucumber.java.en.Given;

public class DwpHerokkuAppSwaggerApiSteps extends AbstractApi {
    final static Logger log = Logger.getLogger(DwpHerokkuAppSwaggerApiSteps.class);

    static final String cityUsers = "/city/{city}/users";
    static final String instructions = "/instructions";
    static final String userID = "/user/{id}";
    static final String userIDValue = "5";
    static final String users = "/users";

    @Given("I need to set the base-uri for the endpoint")
    public void i_need_to_set_the_base_uri_for_the_endpoint() {
        log.info("Attempting to setup the baseURI for the swagger endpoints");
        setupPort();
    }

    @Given("I need to call the endpoint for city users and validate")
    public void i_need_to_call_the_endpoint_for_city_users_and_validate() {
        log.info("Attempting to call the swagger endpoints for city Users");
        Response response = getResponseUsingQueryParam(cityUsers, "sheffield");
        log.info("Repsonse message for city users -->" + response.getBody().prettyPrint());

        // assert
        assertEquals(response.getStatusCode(), 200);
    }

    @Given("I need to call the endpoint for instructions and validate")
    public void i_need_to_call_the_endpoint_for_instructions_and_validate() {
        log.info("Attempting to call the swagger endpoints for instructions");
        Response response = getResponse(instructions, 200);

        // assert
        assertEquals(response.getStatusCode(), 200);

        // parse
        Instruction instruction = new Gson().fromJson(response.getBody().prettyPrint(), Instruction.class);
        log.info("Repsonse message for instructions -->" + instruction.getTodo());

        // assert
        assertFalse(instruction.getTodo().isEmpty());
    }

    @Given("I need to call the endpoint for userId and validate")
    public void i_need_to_call_the_endpoint_for_userId_and_validate() {
        log.info("Attempting to call the swagger endpoints for userId");
        Response response = getResponseUsingQueryParam(userID, userIDValue);
        log.info("Repsonse message for userId -->" + response.getBody().prettyPrint());

        // assert
        assertEquals(response.getStatusCode(), 200);

        // parse
        UserId userResponseParsed = new Gson().fromJson(response.getBody().prettyPrint(), UserId.class);

        // assert
        assertFalse(userResponseParsed.getCity().isEmpty());
        assertFalse(userResponseParsed.getEmail().isEmpty());
        assertFalse(userResponseParsed.getFirst_name().isEmpty());
        assertFalse(userResponseParsed.getId().isEmpty());
        assertFalse(userResponseParsed.getIp_address().isEmpty());
        assertFalse(userResponseParsed.getLast_name().isEmpty());
        assertNotNull(userResponseParsed.getLatitude());
        assertNotNull(userResponseParsed.getLongitude());

    }

    @Given("I need to call the endpoint for users and validate")
    public void i_need_to_call_the_endpoint_for_users_and_validate() {
        log.info("Attempting to call the swagger endpoints for Users");
        Response response = getResponse(users, 200);

        // assert
        assertEquals(response.getStatusCode(), 200);

        // parse
        UserId[] founderArray = new Gson().fromJson(response.getBody().prettyPrint(), UserId[].class);

        // assert
        assertNotNull(founderArray);
    }
}
