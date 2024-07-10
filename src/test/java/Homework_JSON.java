import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Homework_JSON {
    @Test

    public void ParseJSON(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .andReturn();
        String responseBody = response.asString();

        JsonPath jsonPath = new JsonPath(responseBody);
        String secondMessage = jsonPath.getString("messages[1].message");
        System.out.println(secondMessage);

    }
}
