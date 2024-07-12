import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LongtimeJob {

    @Test
    public void LongtimeJob() throws InterruptedException {
                Response response1 = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();


        String token = response1.jsonPath().getString("token");
        int seconds = response1.jsonPath().getInt("seconds");

        System.out.println(token);
        System.out.println(seconds);


              Response response2 = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();

         String status1 = response2.jsonPath().getString("status");

        System.out.println(status1);

        Thread.sleep(seconds * 1000);


        Response response3 = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();

        String status2 = response3.jsonPath().getString("status");

        String result = response3.jsonPath().getString("result");

        System.out.println(status2);
        System.out.println(result);
    }
}
