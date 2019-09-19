package com.stackroute.onlinefashionretail.workflow;

public class RandomIdGenerator {
    public static String getRandomId(){
        return Double.toString(Math.floor(Math.random() * (999999 - 100000)) + 100000);
    }
}
