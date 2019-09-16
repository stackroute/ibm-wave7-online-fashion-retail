package com.stackroute.onlinefashionretail.workflow;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomIdGenerator {
    public static String getRandomId(){
        return new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
    }
}
