package com.example.safetyone;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDateTime;
public class Category {
    private String name;
    private double allocated;
    private double used;

    public Category (String name, double allocated, double used){
        this.name = name;
        this.allocated = allocated;
        this.used = used;
    }   //used = amount spent

    public String getName() {
        return name;
    }

    public double getAllocated() {
        return allocated;
    }

    public double getAmountUsed() {
        return used;
    }

    public double getAmountLeft() {
        return allocated - used;
    }

    private double getMoneyRatio () {
        return used/allocated;
    }

    private int getDaysInMonth (int month, int year){
        int[] days31 = {1,3,5,8,10,12};
        int[] days30 = {4,6,9,11};
        for(int i = 0; i < days31.length; i++){
            if (month == days31[i])
                return 31;
        }
        for(int i = 0; i < days30.length; i++){
            if (month == days30[i])
                return 30;
        }
        if (year%4 == 0){
            return 29;
        }else{
            return 28;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private double getTimeRatio () {
        int day = (LocalDateTime.now()).getDayOfYear();
        int daysInMonth = getDaysInMonth((LocalDateTime.now()).getMonthValue(),
                                         (LocalDateTime.now()).getYear());
        return ((double)(day))/((double)(daysInMonth));
    }

    //recommended value = .1 for yellowTolerance
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getPerformance (double yellowTolerance) {
        if (Math.abs(getTimeRatio() - getMoneyRatio()) <= yellowTolerance){
            return "yellow";
        }else if (getTimeRatio() > getMoneyRatio()) {
            return "green";

        }else{
            return "red";
        }
    }
}
