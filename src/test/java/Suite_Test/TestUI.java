package Suite_Test;

import Page_Test.Page_TestUI;
import common.BaseTest;
import io.restassured.http.ContentType;
import org.junit.After;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestUI extends BaseTest {
    Page_TestUI page = new Page_TestUI();
    @BeforeMethod
    public void configureTests() {
        setUp();
    }
    @Test(description = "Test-1 Entrance to mailbox yandex.ru")
    public void testYandex() throws InterruptedException {
        page.testYandex();
    }
    @Test(description = "Test-2 Entering a word in the search bar")
    public void testGoogle()  {
        page.testGoogle();
    }

    @Test
    public void CheckAvatarIdTest(){

         given()
                .baseUri("https://reqres.in/api/users/")
                .basePath("/2")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                 .body("data.last_name", equalTo("Weaver"))
                  .body("data.email", equalTo("janet.weaver@reqres.in"));
    }
    @After
    public void aftertest() {
        tearDown();
    }
}
