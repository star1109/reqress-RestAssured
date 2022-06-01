package in.reqres.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPath {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";

       response = given()
               .queryParams("page" , 2)
               .when()
               .get("/users")
               .then().statusCode(200);

    }
    // 1) page = 2
    @Test
    public void test001() {

        int page =response.extract().path("page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Page is : "  + page) ;
        System.out.println("------------------End of Test---------------------------");

    }

    // 2.per_page = 6
    @Test
    public void test002() {

        int per_page =response.extract().path("per_page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("per Page is : "  + per_page) ;
        System.out.println("------------------End of Test---------------------------");

    }
    //3.data[1].id = 8
 @Test
    public void test003() {

        int data1_id =response.extract().path("data[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("3.data[1].id = "  + data1_id) ;
        System.out.println("------------------End of Test---------------------------");

    }

    //4.data[3].first_name = Byron
    @Test
    public void test004() {

        String data3_firstName =response.extract().path("data[3].first_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("4.data[3].first_name = "  + data3_firstName) ;
        System.out.println("------------------End of Test---------------------------");

    }

    // 5.list of data = 6
    @Test
    public void test005() {

        List<Object> list = response.extract().path("data.length");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("5.list of data =  "  + list.size()) ;
        System.out.println("------------------End of Test---------------------------");

    }

    //6.data[5].avatar="https://reqres.in/img/faces/11-image.jpg"
    @Test
    public void test006() {

        String avatar = response.extract().path("data[4].avatar");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("6. avatar  =  "  + avatar) ;
        System.out.println("------------------End of Test---------------------------");

    }

    // 7.support.url = "https://reqres.in/#support-heading"
    @Test
    public void test007() {

        String url = response.extract().path("support.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("7. support url is = "  + url) ;
        System.out.println("------------------End of Test---------------------------");

    }

    // support.txt = "To keep ReqRes free, contributions towards server costs are appreciated!"
    @Test
    public void test008() {

        String text = response.extract().path("support.text");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("7. support text is = "  + text) ;
        System.out.println("------------------End of Test---------------------------");

    }



}
