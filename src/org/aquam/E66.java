package org.aquam;

// 5/25/2023
// 66. Plus One
public class E66 {

    public static void main(String[] args) {
        plusOne(new int[] {1,2,3});
        plusOne(new int[] {4,3,2,1});
        plusOne(new int[] {9, 8, 9});
        plusOne(new int[] {9, 9, 9});
        plusOne(new int[] {9});
        plusOne(new int[] {9,9,9});
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] digits2 = new int[digits.length + 1];
        digits2[0] = 1;
        return digits2;
    }

    public static int[] plusOne2(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (plus == 1) {
                if (digits[i] < 9) {
                    digits[i] = digits[i] + plus;
                    plus = 0;
                } else {
                    if (i == 0) {
                        digits[i] = 0;
                        int[] digits2 = new int[digits.length + 1];
                        digits2[0] = 1;
                        return digits2;
                    } else {
                        digits[i] = 0;
                    }
                }
            }
        }
        return digits;
    }

    public static int[] plusOne1(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + plus;
                plus = 0;
            } else {
                if (i == 0) {
                    if (plus == 1) {
                        digits[i] = 0;
                        int[] digits2 = new int[digits.length + 1];
                        digits2[0] = 1;
                        /*
                        // если аж до первой цифры дошли и осталась +1,
                        // то значит, что на всех других мы прибавляли её к 9, значит там везде нули,
                        // поэтому увеличиваем массив на единицу по размеру и первое число это 1, остальные 0
                        for (int j = 0; j < digits.length; j++) {
                            digits2[j + 1] = digits[j];
                        }
                         */
                        return digits2;
                    }
                } else {
                    if (plus == 1)
                        digits[i] = 0;
                }
            }
        }
        return digits;
    }
}

/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
