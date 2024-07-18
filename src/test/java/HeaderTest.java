import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeaderTest {

    @Test
    public void headerTest(){

        Response response = RestAssured
                .given()
                .get(" https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        System.out.print(response.getHeaders());

        String expectedHeaderName = "x-secret-homework-header";

        assertEquals("Some secret value", response.getHeader(expectedHeaderName), "Unexpected value of the 'x-secret-header' header");
    }

}
