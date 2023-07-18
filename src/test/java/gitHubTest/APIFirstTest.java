package gitHubTest;

import apiTests.BaseAPITest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class APIFirstTest extends BaseAPITest {

    private String API_KEY = "ac3ae531e9fea0c8f439cd51bc5b015e";
    Map<String, Object> requestBody = new HashMap<>();

    @BeforeEach
    public void setRequestBody() {

        HashMap<String, String> methodProperties = new HashMap<>();
        methodProperties.put("Page", "1");
        methodProperties.put("Warehouse", "1");
        methodProperties.put("FindByString", "Тернопіль");
        methodProperties.put("Limit", "9");

        requestBody.put("apiKey", API_KEY);
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

    @Test
    public void checkJsonSchema2() {
        given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body(matchesJsonSchema(new File(System.getProperty("user.dir") +
                        "\\src\\main\\resources\\validators\\np_city_of_ukraine_directory_sсhema.json")));
    }

    @Test
    public void checkDescriptionTranslit() {

        given()
                .spec(requestSpecification)
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body("success", equalTo(true))
                .body("data[0].DescriptionTranslit", equalTo("Ternopil"));
    }
}
