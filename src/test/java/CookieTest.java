import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CookieTest {
    @Test
    public void cookieTest() {

        Response responseGetCookie = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        System.out.print(responseGetCookie.getCookies());

        String expectedCookieName = "HomeWork";
        String expectedCookieValue = "hw_value";

        assertTrue(responseGetCookie.getCookies().containsKey(expectedCookieName), "Cookie 'HomeWork' is missing");

        String actualCookieName = responseGetCookie.getCookie(expectedCookieName);

        assertEquals(expectedCookieValue,actualCookieName,"There is no expected cookie value");

    }
}
