package com.example.library.validator;

public class EmailValidator {
    public boolean validate(String email) {
        if (!hasEmailSymbol(email)) {
            return false;
        }
        if (hasBadSymbols(email)) {
            return false;
        }

        if (hasCorrectDomain(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasEmailSymbol(String email) {
        if (email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasBadSymbols(String email) {
        if (email.contains("┘")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasCorrectDomain(String email) {
        return validateName(email) && validateDomain(email);
    }

    private boolean validateName(String name) {
        int length = name.length();
        if(length > 64)
            return false;
        char[] nameLetters = name.toCharArray();
        for (char letter : nameLetters
        ) {
            if (letter < 33 || letter > 125)
                return false;
        }
        return true;
    }

    private boolean validateDomain(String domain) {
        if(!domain.contains("."))
            return false;
        boolean validateDomain = validateDomainName(domain.substring(0, domain.lastIndexOf('.')));
        boolean validateTLD = validateTLD(domain.substring(domain.lastIndexOf('.')+1, domain.length()));
        return validateDomain && validateTLD;

    }

    private boolean validateDomainName(String domainName) {
        int length = domainName.length();
        if(length > 253 || length < 1)
            return false;
        char[] domainLetters = domainName.toCharArray();
        for (char letter: domainLetters
        ) {
            if(letter != '-' && letter != '.')
                if(!Character.isLetterOrDigit(letter))
                    return false;
        }
        return true;
    }

    private boolean validateTLD(String tld) {
        int length = tld.length();
        if(length < 2 || length >= 7)
            return false;
        if(!Character.isLetter(tld.charAt(0)))
            return false;
        if(tld.charAt(0) == '-' || tld.charAt(length-1) == '-')
            return false;
        char[] tldLetters = tld.toCharArray();
        for (char letter: tldLetters
        ) {
            if(letter != '-')
                if(!Character.isLetterOrDigit(letter))
                    return false;
        }
        return true;
    }
}
