package gitHubTest;

import apiTests.BaseAPITest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIFirstTest extends BaseAPITest {

    String API_key = "ac3ae531e9fea0c8f439cd51bc5b015e";
    Map<String, Object> requestBody = new HashMap<>();

    @BeforeEach
    public void setRequestBody() {

        HashMap<String, String> methodProperties = new HashMap<>();
        methodProperties.put("Page", "1");
        methodProperties.put("Warehouse", "1");
        methodProperties.put("FindByString", "Тернопіль");
        methodProperties.put("Limit", "9");

        requestBody.put("apiKey", "ac3ae531e9fea0c8f439cd51bc5b015e");
        requestBody.put("modelName", "Address");
        requestBody.put("calledMethod", "getSettlements");
        requestBody.put("methodProperties", methodProperties);
    }

    @Test
    public void checkCityDocumentation() {

        given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .body("success", equalTo(true));

    }
}
