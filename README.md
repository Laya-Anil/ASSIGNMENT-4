ASSIGNMENT-4
This project is an API Testing Framework designed to automate the validation of RESTful APIs using RestAssured and TestNG. It focuses on ensuring API endpoints function as expected by validating responses, handling errors, and performing data-driven testing.
API Testing Framework

Purpose
This project is an API Testing Framework built with RestAssured and TestNG. The purpose of this framework is to automate the validation of RESTful APIs, ensuring they respond correctly to different requests and scenarios. It helps developers and testers ensure API reliability, identify bugs, and validate data consistency. The framework is lightweight, scalable, and easy to extend for more complex use cases.

Code Details
1. GET Request Validation**
- Method: `testGetRequest`
- Purpose: Validates a GET request to fetch a single resource.
- Functionality:
  - Verifies the response status code is `200`.
  - Ensures the JSON response contains fields like `userId`, `title`, and `body`.
  - Handles missing fields with appropriate assertions.

2. POST Request Validation
- Method: `testPostRequest`
- Purpose: Tests the creation of a new resource using POST requests.
- Functionality:
  - Sends a JSON payload with `title`, `body`, and `userId`.
  - Verifies the status code is `201`.
  - Ensures the response contains a newly generated `id`.

3. Validate All Posts
- Method: `testAllPosts`
- Purpose: Validates a GET request to fetch all posts.
- Functionality:
  - Verifies the response contains a non-empty list.
  - Checks for valid status codes.
  - Ensures each post has fields like `userId`, `title`, and `body`.

4. Error Handling
- The code includes basic error handling for non-200 status codes and plans to:
  - Add retry logic for transient failures.
  - Log detailed messages for unexpected errors.

Features
1. Validation of API Responses:
   - Checks status codes, response bodies, and specific fields.

2. Scalable Design:
   - Supports parameterized testing with TestNG for testing multiple scenarios.

3. Error Handling:
   - Handles basic API errors and logs issues.

4. Documentation:
   - Includes inline documentation and a clear changelog for tracking updates and issues.
