package org.aquam;

// 6/16/2023
// 1154. Day of the Year
public class E1154 {

    public static void main(String[] args) {
        System.out.println(dayOfYear("2004-01-09"));
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("1700-03-10"));
        System.out.println(dayOfYear("1800-04-10"));
        System.out.println(dayOfYear("1900-05-10"));
        System.out.println(dayOfYear("2000-06-10"));
    }

    public static int dayOfYear(String date) {

        int month = 10 * date.charAt(5) + date.charAt(6) - 528, day = 10 * date.charAt(8) + date.charAt(9) - 528;

        // fast return if we don't need leap years
        if (month <= 2) {
            int i1 = 1 - month >>> 27;
            return day + (1 - month >>> 27);
        }

        // months between
        day += 30 * month + month / 2 - 32 + ((month - 1 >> 3) & month);

        // leap year
        int yearPart = 10 * date.charAt(2) + date.charAt(3) - 528;
        if (yearPart == 0) yearPart = 10 * date.charAt(0) + date.charAt(1) - 528;

        return day + (((yearPart & 3) - 1) >>> 31);
    }

    public static int dayOfYear2(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        boolean isLeap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        int numberOfDays = 0;
        int[] numberOfDaysArr = new int[]{31, isLeap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++)
            numberOfDays += numberOfDaysArr[i];
        return numberOfDays + day;
    }

    public static int dayOfYear1(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        boolean isLeap = year % 4 == 0;
        if (isLeap && year % 100 == 0)
            isLeap = year % 400 == 0;
        int numberOfDays = 0;
        for (int i = 1; i < month; i++) {
            if (i % 2 == 1 && i < 8 || i % 2 == 0 && i >= 8)
                numberOfDays += 31;
            else if (i == 2)
                numberOfDays += isLeap ? 29 : 28;
            else
                numberOfDays += 30;
        }
        return numberOfDays + day;
    }
}
/*
31: 01, 03, 05, 07,      08, 10, 12
30: 04, 06, 09, 11
28/29 : 02
 */
/*
% 4 == 0 - високосный
если % 4 == 0 и % 100 == 0 - невисокосный
если % 4 == 0 и % 100 == 0 и % 400 == 0 - високосный
Every year that is exactly divisible by four is a leap year,
except for years that are exactly divisible by 100,
but these centurial years are leap years if they are exactly divisible by 400.
For example, the years 1700, 1800, and 1900 are not leap years, but the year 2000 is.
 */
/*
if (year % 4 == 0) {
            if (year % 100 == 0) {
                isLeap = year % 400 == 0;
            } else {
                isLeap = true;
            }
            isLeap = true;
        }
 */
/**
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD,
 * return the day number of the year.
 *
 * Example 1:
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 *
 * Example 2:
 * Input: date = "2019-02-10"
 * Output: 41
 *
 * Constraints:
 * date.length == 10
 * date[4] == date[7] == '-', and all other date[i]'s are digits
 * date represents a calendar date between Jan 1st, 1900 and Dec 31th, 2019.
 */
