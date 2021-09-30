import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailTest {
    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    void TestContainsAtSymbol() {
        assertTrue(emailValidator.containsAtSymbol("asd123@test"));
    }

    @Test
    void TestContainsInadmissibleSymbol() {
        assertTrue(emailValidator.containsInadmissibleSymbol("asd123©"));
    }

    @Test
    void TestHasBadDomain() {
        assertTrue(emailValidator.hasBadDomain("asd123@com"));
    }

    @Test
    void TestHasBadTopLevelDomain() {
        assertTrue(emailValidator.hasBadTopLevelDomain("asd123@test.asdasd"));
    }

}
