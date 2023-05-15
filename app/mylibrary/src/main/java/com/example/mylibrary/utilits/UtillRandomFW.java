package com.example.mylibrary.utilits;

import java.util.Random;

public class UtillRandomFW {
    public static int getCasualNumber(int number){
        Random random = new Random();
        int casualNumber ;
        casualNumber = random.nextInt(number);
        return casualNumber;

    }
}
