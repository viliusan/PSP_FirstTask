//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class PhoneNumberTest {
//    PhoneValidator phoneValidator;
//
//    @BeforeEach
//    void setUp() {
//        phoneValidator = new PhoneValidator();
//    }
//
//    @Test
//    void TestContainsOnlyNumbers() {
//        assertTrue(phoneValidator.containsOnlyNumbers("865942132"));
//    }
//
//    @Test
//    void TestSwitchesNumberPrefix() {
//        assertEquals("+37064396044", phoneValidator.switchesNumberPrefix("864396044"));
//    }
//
//    @Test
//    void TestCorrectNumberLength() {
//        assertTrue(phoneValidator.correctNumberLength("LT", 12));
//    }
//
//    @Test
//    void TestCorrectNumberPrefix() {
//        assertTrue(phoneValidator.correctNumberPrefix("LT", "+3706"));
//    }
//
//    @Test
//    void TestCorrectForeignNumberLength() {
//        assertTrue(phoneValidator.correctForeignNumberLength("UK", 13));
//    }
//
//    @Test
//    void TestCorrectForeignNumberPrefix() {
//        assertTrue(phoneValidator.correctForeignNumberPrefix("UK", "+44"));
//    }
//
//}
