package org.example.string;

public class ValidateStringToken {
    static boolean validateToken(String token) {
        boolean isValidToken = false;
        if (token == null && token.length() <= 2) {
            return isValidToken;
        }
        char[] chars = token.toCharArray();
        int start = 0;
        while (true) {
            char ch = chars[start];
            if (start == chars.length-1) {
                return isValidToken;
            }
            if (Character.isDigit(ch)) {
                if (chars[start - 1] != chars[start + 1]) {
                    return false;
                } else {
                    isValidToken = true;
                }
            }
            start++;
        }

    }

    public static void main(String[] args) {
        System.out.println(validateToken("abcDef2fegth2def"));
    }
}
