package com.petStore.step_definitions;

import com.petStore.pages.SelfPage;
import com.petStore.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class ApiStepDefs {

    Response response;
    @Given("User makes request to read the pets By Status")
    public void user_makes_request_to_read_the_pets_By_Status() {
       response = given().accept(ContentType.JSON)
                .param("status", "sold")
                .when().get("pet/findByStatus");
    }

    @When("User gets the relevant data")
    public void user_gets_the_relevant_data() {

        ArrayList <String> statusList = response.path("status");

        System.out.println("status List = " + statusList);
        for (int i = 0; i <statusList.size(); i++) {
            assertEquals("sold", statusList.get(i));
        }
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int int1) {

        assertEquals(int1, response.statusCode());
    }

    @Given("User makes get request with wrong ID value")
    public void user_makes_get_request_with_wrong_ID_value() {
        response = given().accept(ContentType.JSON)
                .when().get("pet/kkk");
    }

    @When("User doesnt get any response data")
    public void user_doesnt_get_any_response_data() {
        System.out.println(" = " + response.prettyPrint());
        String errorMessage = response.path("message").toString();
        String expectedMessage = "java.lang.NumberFormatException: For input string: \"kkk\"";

        assertEquals(expectedMessage, errorMessage);
    }

    @Given("User makes Post request to create a new order with valid values")
    public void user_makes_Post_request_to_create_a_new_order_with_valid_values() {
       Map<String,Object> requestMap = new HashMap<>();
        //adding the values that we want to post
        requestMap.put("id", 3);
        requestMap.put("petID",0);
        requestMap.put("quantity", 1);
        requestMap.put("shipDate","2020-04-30T12:59:31.682Z");
        requestMap.put("status", "placed");
        requestMap.put("complete",true);

        response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON)
                .and().body(requestMap).when().post("store/order");
    }

    @When("User gets relevant message")
    public void user_gets_relevant_message() {
        //verify response body
        System.out.println(" = " + response.prettyPrint());

        int id = response.path("id");
        int quantity = response.path("quantity");
       // int petID = response.path("petID");

        assertEquals(3, id);
        assertEquals(1, quantity);
      //  assertEquals(0, petID);
    }

    @Given("User makes Post request with invalid values")
    public void user_makes_Post_request_with_invalid_values() {

        Map<String,Object> requestMap = new HashMap<>();
        //adding the values that we want to post
        requestMap.put("id", 3);
        requestMap.put("petID",0);
        requestMap.put("quantity", 1);
        requestMap.put("shipDate","2020-04-30T12:59:31.682Z");
        requestMap.put("status", "placed");
        requestMap.put("complete","ok");

        response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON)
                .and().body(requestMap).when().post("store/order");
    }

    @When("User gets error message")
    public void user_gets_error_message() {

        String errorMessage = response.path("message").toString();
        String expectedMessage = "something bad happened";
        assertEquals(expectedMessage, errorMessage);
    }

    @Given("User makes Delete request to remove an existing order with valid data")
    public void user_makes_Delete_request_to_remove_an_existing_order_with_valid_data() {
        response = given().contentType(ContentType.JSON)
                  .when().delete("store/order/4");
    }

    @When("User gets delete message")
    public void user_gets_delete_message() {
        String actualMessage = response.path("message").toString();
        String expectedMessage = "4";
        assertEquals(expectedMessage, actualMessage);
    }

    @Given("User makes Delete request with invalid order id")
    public void user_makes_Delete_request_with_invalid_order_id() {
        response = given().contentType(ContentType.JSON)
                .when().delete("store/order/5");
    }
    @When("User gets not found error message")
    public void user_gets_not_found_error_message() {
        String actualMessage = response.path("message").toString();
        String expectedMessage = "Order Not Found";
        assertEquals(expectedMessage, actualMessage);
    }

    @Given("User makes Put request to update an order")
    public void user_makes_Put_request_to_update_an_order() {
        //user information before update
//        {
//            "id": 555,
//                "username": "kadirbalikci1",
//                "firstName": "Kadir",
//                "lastName": "Balikcii",
//                "email": "example@email.com",
//                "password": "123abc",
//                "phone": "123456789",
//                "userStatus": 0
//        }
        Map<String,Object> putMap = new HashMap<>();
        putMap.put("id",555);
        putMap.put("username","kadirbalikci1");
        putMap.put("firstName","nusret");
        putMap.put("lastName","harputlu");
        putMap.put("email","example@email.com");
        putMap.put("phone",6986436734L);
        putMap.put("userStatus",0);

        response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON)
                .and().body(putMap).when().put("user/kadirbalikci1");
    }

    @When("User gets id in the message")
    public void user_gets_id_in_the_message() {

        String actualMessage = response.path("message");

        assertEquals("555", actualMessage);
        assertEquals("application/json", response.contentType());
    }

    @Given("User makes Put request with invalid data")
    public void user_makes_Put_request_with_invalid_data() {
        Map<String,Object> putMap = new HashMap<>();
        putMap.put("id",555);
        putMap.put("username","kadirbalikci1");
        putMap.put("firstName","nusret");
        putMap.put("lastName","harputlu");
        putMap.put("email","example@email.com");
        putMap.put("phone",6986436734L);
        //userStatus must be a boolean, but I put a string to see the failure
        putMap.put("userStatus","ok");

        response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON)
                .and().body(putMap).when().put("user/kadirbalikci1");
    }

}







