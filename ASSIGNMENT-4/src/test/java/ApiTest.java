
/*
 Plan to reduce tech-debt:
 1. Validate the response body.
 2. Handle different response scenarios (e.g., non-200 status codes).
 3. Implement data-driven testing for multiple endpoints.
*/



/*
 Technical Debt:
 - Enhance `testGetRequest` to validate specific fields in the JSON response (e.g., validate the value of "userId").
 - Improve `testAllPosts` to handle scenarios with non-200 responses or empty data.
 - Expand `testPostRequest` to include data-driven testing for various payloads.
 - Add validation for error responses, such as 400 or 500 status codes.
*/

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void testGetRequest() {
        /*
         Known Issue: This method does not validate individual JSON fields beyond "userId".
         Plan: Add field-level validation for "title", "body", and "userId".
        */
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got: " + response.getStatusCode());
        Assert.assertNotNull(response.getBody(), "Response body is null");
        Assert.assertTrue(response.getBody().asString().contains("userId"), "Response body does not contain 'userId'");
    }

    @Test
    public void testAllPosts() {
        /*
         Known Issue: Assumes response will always return a valid JSON list.
         Plan: Introduce error handling and response structure validation.
        */
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got: " + response.getStatusCode());
        Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0, "The list of posts is empty");
    }

    @Test
    public void testPostRequest() {
    	/*
    	 Technical Debt:
    	 - Enhance `testGetRequest` to validate specific fields in the JSON response (e.g., validate the value of "userId").
    	 - Improve `testAllPosts` to handle scenarios with non-200 responses or empty data.
    	 - Expand `testPostRequest` to include data-driven testing for various payloads.
    	 - Add validation for error responses, such as 400 or 500 status codes.
    	*/ 
        Response response = RestAssured.given()
            .contentType("application/json")
            .body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
            .post("https://jsonplaceholder.typicode.com/posts");

        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201 but got: " + response.getStatusCode());
        Assert.assertTrue(response.getBody().asString().contains("\"id\""), "Response does not contain 'id'");
    }
}


