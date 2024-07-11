import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestLongRedirect {
    @Test

    public void TestLongRedirect(){
        String getRequest = "https://playground.learnqa.ru/api/long_redirect";
        String currentUrl = getRequest;
        int redirectCount = 0;

        while (true) {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(currentUrl)
                    .andReturn();
            String location = response.getHeader("Location");
            int statusCode = response.getStatusCode();
            if (statusCode == 200) {
                break;
            }

            currentUrl = location;
            redirectCount++;
        }

        System.out.println(redirectCount);
    }
}
