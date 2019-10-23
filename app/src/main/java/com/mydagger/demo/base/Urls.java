package com.mydagger.demo.base;

/**
 * Created by chenshaolong on 2019/10/17.
 */

public class Urls {

    public static final boolean isRelease = true;

    private static final String MAIN_RELEASE = "https://mimapi.xuanyiai.com";
    private static final String MAIN_TEST = "http://192.168.2.203:8003";

    public static String MAIN_HOST = isRelease ? MAIN_RELEASE : MAIN_TEST;
    public static String WY163_HOST = "http://c.m.163.com";

}
