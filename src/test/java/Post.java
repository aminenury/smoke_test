import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Post extends  PetstoreBaseUrl{
    /*
    Given
       https://petstore.swagger.io/v2/pet
     And

                                 {
                                  "id": 0,
                                 "category": {
                                     "id": 0,
                            "name": "string"
                          },
                          "name": "duman",
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
      user sends post request
    Then
      status code is     200
    And
                                   {
                                "id": 9223372016900011621,
                                "category": {
                                    "id": 0,
                                    "name": "string"
                                },
                                "name": "duman",
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
    public void post(){
        spec.pathParam("first","pet");

        TagPojo tagPojo= new TagPojo(3,"bidi");
        categorypojo categorypojo= new categorypojo(5,"didi");
        List<String > photoUrls= new ArrayList<>();
        photoUrls.add("string");
        List<TagPojo> tagPojos= new ArrayList<>();

        PetstorePojo expectedData = new PetstorePojo(654654,categorypojo,"duman", (ArrayList<String>) photoUrls, (ArrayList<TagPojo>) tagPojos,"available");




        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        response.prettyPrint();

        PetstorePojo actualData = response.as(PetstorePojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(categorypojo.getName(),actualData.category.getName());
        assertEquals(categorypojo.getId(),actualData.category.getId());
        assertEquals(expectedData.getPhotoUrls(),actualData.getPhotoUrls());
        assertEquals(tagPojos,actualData.getTags());
        assertEquals(expectedData.getStatus(),actualData.getStatus());










    }
}
