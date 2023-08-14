package com.jsonPlaceHolder.utils;

public class util {
    public static String removeCommas(String rawString) {
        if (rawString != null) {
            return rawString.replaceAll("\"", "");
        }
        return rawString;
    }
}
