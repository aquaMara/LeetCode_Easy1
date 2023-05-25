package org.aquam;

// 5/17/2023
// 258. Add Digits
// https://leetcode.com/problems/add-digits/description/
public class E258 {

    public static void main(String[] args) {
        /*
        Все числа, которые делятся на 9, имеют сумму цифр, равную 9
        1683 / 9 = 187 -> остаток 0
        1683 = 1 + 6 + 8 + 3 = 18 = 1 + 8 = 9 -> ответ 9
        1684 / 9 = 187 + 1 -> остаток 1
        1684 = 1 + 6 + 8 + 4 = 19 = 1 + 9 = 10 = 1 + 0 = 1 -> ответ 1
        В итоге получается, что мы от чисел всегда убираем всё, что самое близкое умноженное на 9 и поллучаем какой-то остаток
        если остаток = 0, то вернём 9
        если остаток != 0, то вернём этот остаток
        Берём 9, потому что это самое большое однозначное число

        Получается, что мы складываем цифры в числе,
        если сумма равна 9, то это число делится на 9 и мы вернём 9 как сумму цифр
        если сумма цифр меньше 9, например 123,то как нам просто найти сумму?
        123 = 9 * 13 + 6, все числы с сумой цифр 9 откидываются, остаётся остаток 6

         */
        int z = 100 % 9;    // 100 = 9 * 11 + 1 -> 1
        int qz = 250 % 9;   // 250 = 9 * 27 + 7 -> 7
        int zw = 413 % 9;   // 413 = 9 * 45 + 8 -> 8
        int zr = 18 % 9;    // 18 = 9 * 2 + 0 -> 0
        int zdr = 11 % 9;   // 11 = 9 * 1 + 2 -> 2
        int zrr = 38 % 9;   // 38 = 9 * 4 + 2 -> 2
        System.out.println(addDigits(4));
        System.out.println(addDigits(1));
        System.out.println(addDigits(36));
        System.out.println(addDigits(100));
        System.out.println(addDigits(38));
        System.out.println(addDigits(0));
    }

    public static int addDigits(int num) {
        int remainder = num % 9;
        if (remainder == 0 && num != 0)
            return 9;
        return remainder;
    }

    public static int addDigits1(int num) {
        int number = 0;
        // num / 10 == 0 => number has only one digit
        while (number != 0 || num / 10 != 0) {
            number += num % 10;
            num = (num - num % 10) / 10;
            if (num == 0) {
                num = number;
                number = 0;
            }
        }
        return num;
    }
}

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Example 1:
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 *
 * Example 2:
 * Input: num = 0
 * Output: 0
 *
 * Constraints:
 * 0 <= num <= 231 - 1
 *
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */