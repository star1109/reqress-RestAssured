package in.reqres.userinfo;

import in.reqres.model.LoginPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostLoginTest extends TestBase {


    @Test
    public void postLoginTest()
    {
        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setEmail("eve.holt@reqres.in");
        loginPojo.setPassword("cityslicka");

      Response response =  given()
                .header("Authorization","Bearer ba41816a2250d319d94b675bc82065a88bf3a7bdf4783dce41165818018dd9b3")
                .header("Content-Type","application/json")
                .body(loginPojo)
                .when()
                .post("/login")
                .then()
                .extract().response();
                response.then().statusCode(200);
                response.prettyPrint();


    }

}
