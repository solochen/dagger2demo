package com.mydagger.demo.base;

/**
 * Created by chenshaolong on 2019/9/24.
 */

public class User {

    private static volatile User sUser;

    public static User getUser() {
        if (sUser == null) {
            synchronized (User.class) {
                if (sUser == null) {
                    sUser = new User();
                }
            }
        }
        return sUser;
    }

    public String getContent(){
        return "abcdefghijklmn";
    }

}


