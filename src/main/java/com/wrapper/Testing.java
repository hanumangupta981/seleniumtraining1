package com.wrapper;

import java.time.LocalTime;

public class Testing {


    public static void main(String[] args) {
        String localTime = LocalTime.now().toString();
        System.out.println(localTime);

        long snapshot = (long) (Math.random()*10000000+10000001);
        System.out.println(snapshot);

    }
}
