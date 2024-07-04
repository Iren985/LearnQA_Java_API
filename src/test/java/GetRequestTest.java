import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetRequestTest {
    @Test
    public void GetTest(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn();
       String responseBody = response.asString();
       System.out.println(responseBody);
    }

}
