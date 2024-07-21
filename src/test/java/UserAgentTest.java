import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

import static groovy.json.JsonOutput.prettyPrint;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAgentTest {


    @ParameterizedTest
    @ValueSource(strings = {"Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30@ Mobile@ No@ Android@",
            "Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1@Mobile@Chrome@iOS@",
            "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)@Googlebot@Unknown@Unknown@",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0@Web@Chrome@No@;",
            "Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1@Mobile@No@iPhone@"
    })
    public void UserAgentTest(String user_agent){

        String[] parts = user_agent.split("@");

        String userAgent = parts[0].trim();
        String expectedPlatform = parts[1].trim();
        String expectedBrowser = parts[2].trim();
        String expectedDevice = parts[3].trim();

                Response response = RestAssured
                .given()
                .header("User-Agent",userAgent)
                .get(" https://playground.learnqa.ru/ajax/api/user_agent_check")
                .andReturn();
        response.print();
        String platform = response.jsonPath().getString("platform");
        String browser = response.jsonPath().getString("browser");
        String device = response.jsonPath().getString("device");

        assertEquals(expectedPlatform,platform,"Platform is uncorrected for userAgent:"+userAgent);
        assertEquals(expectedBrowser,browser,"Browser is uncorrected for userAgent:"+userAgent);
        assertEquals(expectedDevice,device,"Device is uncorrected for userAgent:"+userAgent);

            }
}
