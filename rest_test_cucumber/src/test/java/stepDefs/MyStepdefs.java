package stepDefs;

import cucumber.api.java8.En;
//import io.cucumber.java8.En;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;


public class MyStepdefs implements En {

    private Response response;
    private ValidatableResponse json;
    private ResponseBody body;
    private RequestSpecification request;
    private String ENDPOINT_GET_CODE = "https://httpstat.us/";


    public MyStepdefs() {

        Given("^a rest endpoint is up$", () -> {
            request = RestAssured.given().param("");
        });

        When("^the get request is sent to the endpoint for code \"([^\"]*)\"$", (Integer code) -> {
            String codeAppend = code.toString();
            response = request.when().get(ENDPOINT_GET_CODE + codeAppend);
        });

        Then("^the http status return value is \"([^\"]*)\"$", (Integer returnCode) -> {
            json = response.then().statusCode(returnCode);
        });

        And("^the http return message is \"([^\"]*)\"$", (String message) -> {
            body = response.body();
            String bodyText = body.asString();
            Assert.assertTrue(bodyText.contains(message));
            //System.out.print(bodyText);
        });

    }
}
