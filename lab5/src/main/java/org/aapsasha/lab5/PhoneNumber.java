package org.aapsasha.lab5;

import java.util.regex.Pattern;

public class PhoneNumber {
    private static String phoneNumber = "\\+?(375|80)(29|44|33|25|17)(\\d){7}";
    public static boolean match(String line){
        return Pattern.matches(phoneNumber,line);
    }
}
