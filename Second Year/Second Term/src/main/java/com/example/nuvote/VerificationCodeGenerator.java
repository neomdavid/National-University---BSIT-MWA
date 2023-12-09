package com.example.nuvote;

import java.util.Random;

public class VerificationCodeGenerator {
    public static String generateVerificationCode() {
        // Generate a random 6-digit code
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return Integer.toString(code);
    }
}
