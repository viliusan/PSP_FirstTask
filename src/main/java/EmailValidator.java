public class EmailValidator {
    public boolean containsAtSymbol(String password) {
        return true;
    }

    public boolean containsInadmissibleSymbol(String password) {
        return true;
    }

    public boolean hasBadDomain(String password) {
        return true;
    }

    public boolean hasBadTopLevelDomain(String password) {
        return true;
    }
}
