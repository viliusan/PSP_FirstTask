import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordTest {

    PasswordChecker passwordChecker;
    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
    }

    @Test
    void TestPasswordLength() {
        assertTrue(passwordChecker.meetsLengthRequirement("asd12345", 8));
    }

    @Test
    void TestContainsUppercaseLetters() {
        assertTrue(passwordChecker.containsUppercaseLetter("Asd123"));
    }

    @Test
    void TestContainsSpecialCharacter() {
        assertTrue(passwordChecker.containsSpecialCharacter("asd123@"));
    }

}
