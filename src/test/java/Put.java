import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Put extends PetstorePojo{
    /*
    Given
        https://petstore.swagger.io/v2/pet
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
      When
           status code is 200
      Then
          "server" is "Jetty(9.2.9.v20150224)"
     */

    @Test
    public void put(){

      String url = " https://petstore.swagger.io/v2/pet";

        TagPojo tagPojo= new TagPojo(3,"bidi");
        categorypojo categorypojo= new categorypojo(5,"updateName");
        List<String > photoUrls= new ArrayList<>();
        photoUrls.add("string");
        List<TagPojo> tagPojos= new ArrayList<>();

        PetstorePojo expectedData = new PetstorePojo(654654,categorypojo,"minnos", (ArrayList<String>) photoUrls, (ArrayList<TagPojo>) tagPojos,"available");




        Response response = given().contentType(ContentType.JSON).body(expectedData).put(url);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        PetstorePojo actualData= response.as(PetstorePojo.class);
         assertEquals(200,response.statusCode());
         assertEquals("Jetty(9.2.9.v20150224)",response.header("server"));
    }
}
