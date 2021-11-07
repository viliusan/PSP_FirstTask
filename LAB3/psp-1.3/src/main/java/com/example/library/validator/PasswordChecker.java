package com.example.library.validator;

public class PasswordChecker {
    private final static String passwordSpecialCharacterList = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~";

    public boolean validatePassword(String password) {
        if (!passwordLengthCheck(password, 8)) {
            return false;
        }
        if (!passwordUppercaseCheck(password)) {
            return false;
        }

        if (!passwordSpecialSymbol(password)) {
            return false;
        }
        return true;
    }

    private boolean passwordLengthCheck(String password, int minLenght) {
        if (password.length() < minLenght) {
            return false;
        } else {
            return true;
        }
    }

    private boolean passwordUppercaseCheck(String password) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;

        for (int i=0; i < password.length(); i++) {
            ch = password.charAt(i);
            if(Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }

    private boolean passwordSpecialSymbol(String password) {
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < passwordSpecialCharacterList.length(); j++) {
                char passwordChar = password.charAt(i);
                char specialChar = passwordSpecialCharacterList.charAt(j);
                if (passwordChar == specialChar) {
                    return true;
                }
            }
        }
        return false;
    }
}
