package com.example.library.validator;

public class NumberValidator {
    public boolean validateNumber(String number) {
        if (!checkForSymbols(number)) {
            return false;
        }

        if (!startsWith(number)) {
            return false;
        }

        return true;
    }

    private boolean checkForSymbols(String phoneNumber) {
        char[] numbers = phoneNumber.toCharArray();

        for (char number: numbers) {
            if (!Character.isDigit(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean startsWith(String phoneNumber) {
        if (phoneNumber.charAt(0) == 8) {
            return true;
        } else {
            return false;
        }
    }
}
