import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


class RestAssuredWithWiremockTest {

    @Test
    void unauthorizedRequestShouldGet403() {
        RestAssured.baseURI = "http://0.0.0.0:8080";
        RestAssured.get("/invoices").then().statusCode(403).assertThat()
                .statusLine("HTTP/1.1 403 Forbidden");
                //.header("Server", Matchers.equalTo("SimpleHTTP/0.6 Python/3.6.5"));
                //.body("data.leagueId", Matchers.equalTo(35));
    }

    @Test
    void authorizedRequestShouldGet200() {
        RestAssured.baseURI = "http://0.0.0.0:8080";
        RestAssured.get("/auth").then().statusCode(200).assertThat()
                .statusLine("HTTP/1.1 200 OK");
        //.header("Server", Matchers.equalTo("SimpleHTTP/0.6 Python/3.6.5"));
        //.body("data.leagueId", Matchers.equalTo(35));
    }

    @Test
    void authorizedInvoiceRequestShouldGet200() {
        RestAssured.baseURI = "http://0.0.0.0:8080";
        RestAssured.get("/invoices").then().statusCode(200).assertThat()
                .statusLine("HTTP/1.1 200 OK");
        //.header("Server", Matchers.equalTo("SimpleHTTP/0.6 Python/3.6.5"));
        //.body("data.leagueId", Matchers.equalTo(35));
    }
}
