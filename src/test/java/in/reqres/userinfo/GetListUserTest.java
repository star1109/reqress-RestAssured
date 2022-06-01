package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetListUserTest extends TestBase {


    @Test
        public void getListUser()
    {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("page", 2);


       Response response = given()
               .queryParams(qParams)
                .when()
                .get("/users");
       response.then().statusCode(200);
       response.prettyPrint();



    }
}
