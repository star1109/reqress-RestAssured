package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {



    @Test
    public void deleteUser() {
        Response response = given()
                .pathParam("id", 3)
                .when()
                .delete("/{id}")
                .then()
                .extract().response();

        response.then().statusCode(204);
        response.prettyPrint();
    }

}
