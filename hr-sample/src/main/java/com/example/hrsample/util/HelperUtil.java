package com.example.hrsample.util;

public class HelperUtil {
    public static String getContainsLikePattern(String searchTerm) {
        if(searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        } else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }
}
