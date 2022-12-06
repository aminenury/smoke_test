import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get extends PetstorePojo{
    /*
    Given
       https://petstore.swagger.io/v2/pet/5
    When
       user sends get request
    Then
       status code is 200
    And
       content type is json
    And
       "server" is " Jetty(9.2.9.v20150224)"
    And
       {
    "id": 5,
    "category": {
        "id": 0,
        "name": "string"
    },
    "name": "mico",
    "photoUrls": [
        "string"
    ],
    "tags": [
        {
            "id": 0,
            "name": "string"
        }
    ],
    "status": "available"
}
     */
    @Test
    public void get(){
        String url = "https://petstore.swagger.io/v2/pet/5";

        Response response = given().when().get(url);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).headers("server","Jetty(9.2.9.v20150224)" );
        JsonPath jsonPath= response.jsonPath();
        assertEquals(5,jsonPath.getInt("id"));
        assertEquals(0,jsonPath.getInt("category.id"));
        assertEquals("doggie",jsonPath.getString("name"));

    }
}
