package org.aquam;

import java.util.HashMap;
import java.util.Map;

// 6/12/2023
// 13. Roman to Integer
public class E13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));  // 3
        System.out.println(romanToInt("LVIII"));    // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994
    }

    public static int romanToInt(String s) {
        Map<String, Integer> dictionary = new HashMap<>();
        dictionary.put("I", 1);
        dictionary.put("V", 5);
        dictionary.put("X", 10);
        dictionary.put("L", 50);
        dictionary.put("C", 100);
        dictionary.put("D", 500);
        dictionary.put("M", 1000);
        int number = 0;
        Integer currentDigit = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            currentDigit = dictionary.get(s.substring(i, i + 1));
            if (currentDigit * 4 < number)
                number -= currentDigit;
            else
                number += currentDigit;
        }
        return number;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);
        int number = dictionary.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Integer first = dictionary.get(s.charAt(i - 1));
            Integer second = dictionary.get(s.charAt(i));
            if (first < second) {
                number += second - 2 * first;
            } else
                number += second;
        }
        return number;
    }

    public static int romanToInt1(String s) {
        Map<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer integer0 = dictionary.get(s.charAt(i));
            if (i < s.length() - 1) {
                Integer integer1 = dictionary.get(s.charAt(i + 1));
                if (integer0 < integer1) {
                    number += integer1 - integer0;
                    ++i;
                } else
                    number += integer0;
            } else
                number += integer0;
        }
        return number;
    }
}

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * Constraints:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
