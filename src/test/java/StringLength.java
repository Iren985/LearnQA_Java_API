import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringLength {
    @Test
    public void lengthTest(){
        String stringForTest = "Variable 'string' for test was never used";
        assertTrue(stringForTest.length()>15,"String length is less than 15 symbols or equal");
    }
}
