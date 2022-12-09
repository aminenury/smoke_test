package practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        user sends Get request
    Then
        status code is 200
     */
    @Test
    public void get01(){
        String url =" https://automationexercise.com/api/productsList";

        Response response = given().when().contentType(ContentType.JSON).get(url);
        response.jsonPath().prettyPrint();

        response.then().assertThat().statusCode(200);

    }
}
