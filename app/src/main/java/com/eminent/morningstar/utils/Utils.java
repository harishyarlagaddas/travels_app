package com.eminent.morningstar.utils;

import java.util.Calendar;

public class Utils {
    public static String getMonthString(int month){
        switch (month){
            case Calendar.JANUARY:
                return "January";
            case Calendar.FEBRUARY:
                return "February";
            case Calendar.MARCH:
                return "March";
            case Calendar.APRIL:
                return "April";
            case Calendar.MAY:
                return "May";
            case Calendar.JUNE:
                return "June";
            case Calendar.JULY:
                return "July";
            case Calendar.AUGUST:
                return "August";
            case Calendar.SEPTEMBER:
                return "September";
            case Calendar.OCTOBER:
                return "October";
            case Calendar.NOVEMBER:
                return "November";
            case Calendar.DECEMBER:
                return "December";
            default:
                return "UnKnown";
        }
    }

    public static String getDayString(int day){
        switch (day){
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            case Calendar.SUNDAY:
                return "Sunday";
            default:
                return "UnKnown";
        }
    }

    public static String getTimeString(double time){
        String timeStr = null;
        if(12 > time){
            if(time % 1 ==0){
                int time1 = (int)time;
                timeStr = String.valueOf(time1)+"AM";
            }else {
                timeStr = String.format("%.2f", time) + "AM";
            }
        }else if(12 < time){
            if(time % 1 == 0){
                int time1 = (int)time;
                timeStr = String.valueOf(time1-12)+"PM";
            }else {
                timeStr = String.format("%.2f", time - 12) + "PM";
            }
        }else if(12 == time){
            int time1 = (int)time;
            timeStr = String.valueOf(time1)+"PM";
        }
        return timeStr;
    }
}
