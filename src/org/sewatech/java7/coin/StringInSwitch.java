package org.sewatech.java7.coin;

import java.util.Calendar;

/**
 *
 * @author alexis
 */
public class StringInSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int month = 0;
        Season season;
        switch (month) {
            case Calendar.DECEMBER:
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
                season = Season.WINTER;
                break;
            case Calendar.MARCH:
            case Calendar.APRIL:
            case Calendar.MAY:
                season = Season.SPRING;
                break;
            case Calendar.JUNE:
            case Calendar.JULY:
            case Calendar.AUGUST:
                season = Season.SUMMER;
                break;
            case Calendar.SEPTEMBER:
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
                season = Season.FALL;
                break;
            default:
                season = null;
        }

        String headgear;
        switch (season) {
            case SPRING:
                headgear = "none";
                break;
            case SUMMER:
                headgear = "cap";
                break;
            case FALL:
                headgear = "hood";
                break;
            case WINTER:
                headgear = "woolly hat";
                break;
            default:
                headgear = "";
        }

        switch (headgear) {
            case "none" :
                //...
                break;
        }
    }

    private static enum Season {
        SPRING, SUMMER, FALL, WINTER;
    }
}
