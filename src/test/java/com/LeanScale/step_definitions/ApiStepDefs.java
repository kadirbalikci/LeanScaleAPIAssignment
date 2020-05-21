package com.LeanScale.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class ApiStepDefs {

    Response response;
    ArrayList <String> categoryNameList = null;

    @Given("User makes get request to see the Categories")
    public void user_makes_get_request_to_see_the_Categories() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories");
    }

    @When("User gets the relevant data")
    public void user_gets_the_relevant_data() {
        System.out.println(" = " + response.body().prettyPrint());
        categoryNameList = response.path("children_data.name");
        System.out.println("categoryNameList = " + categoryNameList);

        ArrayList <String> expectedCatList = new ArrayList<>();
        expectedCatList.addAll(Arrays.asList("What's New", "Women", "Men", "Gear", "Training", "Collections", "Promotions", "Sale"));

        for (int i = 0; i <categoryNameList.size() ; i++) {
            assertEquals(expectedCatList.get(i), categoryNameList.get(i));
        }

        System.out.println(response.path("children_data.id").toString());

    }

    @Then("Verify status code {int} and content type")
    public void verify_status_code_and_content_type(Integer int1) {
        assertEquals(int1.intValue(), response.statusCode());
        assertEquals("application/json; charset=utf-8", response.contentType());

    }

    @Given("User makes get request with the {int} to see specific category")
    public void user_makes_get_request_with_the_to_see_specific_category(Integer categoryID) {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/"+categoryID);

    }

    @When("User gets the data with the {int} successfully")
    public void user_gets_the_data_with_the_successfully(Integer categoryID) {
        assertEquals(categoryID, response.path("id"));
    }

    @Given("User makes get request with wrong ID value")
    public void user_makes_get_request_with_wrong_ID_value() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/"+500);

    }

    @When("User doesn't get any response data")
    public void user_doesn_t_get_any_response_data() {
        System.out.println(" = " + response.prettyPrint());
        String expectedMessage = "No such entity with %fieldName = %fieldValue";
        String actualMessage = response.path("message").toString();

        assertEquals(expectedMessage, actualMessage);
    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer int1) {

        assertEquals(int1.intValue(), response.statusCode());
        assertEquals("application/json; charset=utf-8", response.contentType());
    }
    @Given("User makes get request to see What's New category details")
    public void user_makes_get_request_to_see_What_s_New_category_details() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/38");

    }

    @When("Correct data should ve displayed about the What's New category")
    public void correct_data_should_ve_displayed_about_the_What_s_New_category() {
        response.prettyPrint();

    Integer expectedID =  38;
    Integer expectedParentID = 2;
    String expectedName = "What's New";
    String expectedNumOfChildren = "0";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(expectedName, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[3].value"));

    }

    @Given("User makes get request to see Women category details")
    public void user_makes_get_request_to_see_Women_category_details() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/20");
    }

    @When("Correct data should ve displayed about the Women category")
    public void correct_data_should_ve_displayed_about_the_Women_category() {
        response.prettyPrint();

        Integer expectedID =  20;
        Integer expectedParentID = 2;
        String expectedName = "Women";
        String expectedNumOfChildren = "8";
        String expectedChildrenIDs = "21,22";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(expectedName, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[4].value"));
        assertEquals(expectedChildrenIDs, response.path("children"));

    }

    @Given("User makes get request to see {string} category details")
    public void user_makes_get_request_to_see_category_details(String category) {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/11");
    }

    @When("Correct data should ve displayed about the {string} category")
    public void correct_data_should_ve_displayed_about_the_category(String category) {
        response.prettyPrint();

        Integer expectedID =  11;
        Integer expectedParentID = 2;
        String expectedNumOfChildren = "8";
        String expectedChildrenIDs = "12,13";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(category, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[4].value"));
        assertEquals(expectedChildrenIDs, response.path("children"));
    }

    @Given("User makes get request to see Gear category details")
    public void user_makes_get_request_to_see_Gear_category_details() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/3");
    }

    @When("Correct data should ve displayed about the Gear category")
    public void correct_data_should_ve_displayed_about_the_Gear_category() {
        response.prettyPrint();

        Integer expectedID =  3;
        Integer expectedParentID = 2;
        String expectedName = "Gear";
        String expectedNumOfChildren = "3";
        String expectedChildrenIDs = "4,5,6";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(expectedName, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[4].value"));
        assertEquals(expectedChildrenIDs, response.path("children"));
    }

    @Given("User makes get request to see Training category details")
    public void user_makes_get_request_to_see_Training_category_details() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/9");
    }

    @When("Correct data should ve displayed about the Training category")
    public void correct_data_should_ve_displayed_about_the_Training_category() {
        response.prettyPrint();

        Integer expectedID =  9;
        Integer expectedParentID = 2;
        String expectedName = "Training";
        String expectedNumOfChildren = "1";
        String expectedChildrenIDs = "10";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(expectedName, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[4].value"));
        assertEquals(expectedChildrenIDs, response.path("children"));
    }

    @Given("User makes get request to see Collections category details")
    public void user_makes_get_request_to_see_Collections_category_details() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/7");

    }

    @When("Correct data should ve displayed about the Collections category")
    public void correct_data_should_ve_displayed_about_the_Collections_category() {
        response.prettyPrint();

        Integer expectedID =  7;
        Integer expectedParentID = 2;
        String expectedName = "Collections";
        String expectedNumOfChildren = "6";
        String expectedChildrenIDs = "34,35,36,39,40,8";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(expectedName, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[3].value"));
        assertEquals(expectedChildrenIDs, response.path("children"));
    }

    @Given("User makes get request to see Promotions category details")
    public void user_makes_get_request_to_see_Promotions_category_details() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/29");

    }

    @When("Correct data should ve displayed about the Promotions category")
    public void correct_data_should_ve_displayed_about_the_Promotions_category() {
        response.prettyPrint();

        Integer expectedID = 29;
        Integer expectedParentID = 2;
        String expectedName = "Promotions";
        String expectedNumOfChildren = "4";
        String expectedChildrenIDs = "30,31,32,33";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(expectedName, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[3].value"));
        assertEquals(expectedChildrenIDs, response.path("children"));

    }

    @Given("User makes get request to see Sale category details")
    public void user_makes_get_request_to_see_Sale_category_details() {
        String accessToken = "Bearer uulbfv3bozwp0wbvyax39o0348elq21f";
        response =  given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("V1/categories/37");
    }

    @When("Correct data should ve displayed about the Sale category")
    public void correct_data_should_ve_displayed_about_the_Sale_category() {
        response.prettyPrint();

        Integer expectedID = 37;
        Integer expectedParentID = 2;
        String expectedName = "Sale";
        String expectedNumOfChildren = "0";

        assertEquals(expectedID, response.path("id"));
        assertEquals(expectedParentID, response.path("parent_id"));
        assertEquals(expectedName, response.path("name"));
        assertEquals(expectedNumOfChildren, response.path("custom_attributes[3].value"));
    }

}







