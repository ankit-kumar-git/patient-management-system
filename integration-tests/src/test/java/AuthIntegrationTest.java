import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {
    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:4004";  //4004 is where api-gateway runs
    }

    @Test
    public void shouldReturnOKWithValidToken(){
        //1. Arrange
        //2. act
        //3. assert

        String loginPayload = """
                    {
                        "email": "testuser@test.com",
                        "password": "password123"
                    }
                """;

        Response response = given()   //arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login") //act
                .then()  //asserting
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token: " + response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedOnInValidToken(){
        //1. Arrange
        //2. act
        //3. assert

        //intentionally putting incorrect payload to check response in case of failure/unauthorized access case
        String loginPayload = """     
                    {
                        "email": "invalid_user@test.com",
                        "password": "wrongpassword"
                    }
                """;

           given()   //arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login") //act
                .then()  //asserting
                .statusCode(401);


    }
}
