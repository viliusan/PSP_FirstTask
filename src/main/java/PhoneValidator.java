public class PhoneValidator {

    public boolean containsOnlyNumbers(String password) {
        return true;
    }

    public String switchesNumberPrefix(String password) {
        return "+37064396044";
    }

    public boolean correctNumberLength(String countryCode, int minLength) {
        return true;
    }

    public boolean correctNumberPrefix(String countryCode, String prefix) {
        return true;
    }

    public boolean correctForeignNumberLength(String countryCode, int minLength) {
        return true;
    }

    public boolean correctForeignNumberPrefix(String countryCode, String prefix) {
        return true;
    }
}
