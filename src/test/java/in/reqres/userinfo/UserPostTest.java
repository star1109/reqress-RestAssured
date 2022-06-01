package in.reqres.userinfo;

import in.reqres.model.StudentPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUserTest() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setName("mercury");
        studentPojo.setJob("rotation");

   Response response =      given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post("/users");
   response.then().statusCode(201);
    response.prettyPrint();


    }
}
