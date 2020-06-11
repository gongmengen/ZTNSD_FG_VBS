package com.spider.elemente;

import java.util.Map;

public class ErrorPram {
    public static Map<Integer,String> errorPram;

    public static Map<Integer, String> getErrorPram() {
        return errorPram;
    }

    public static void setErrorPram(Map<Integer, String> errorPram) {
        ErrorPram.errorPram = errorPram;
    }
}
