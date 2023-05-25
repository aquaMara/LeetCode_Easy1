package org.aquam;

// 263. Ugly Number
// 5/24/2023
public class E263 {

    public static void main(String[] args) {
        int x = 1 % 5;
        int qx = 0 % 5;

        System.out.println(isUgly(60));
        System.out.println(isUgly(6));
        System.out.println(isUgly(1));
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int n) {
        if (n <= 0)
            return false;
        while (n % 2 == 0)
            n = n / 2;
        while (n % 3 == 0)
            n = n / 3;
        while (n % 5 == 0)
            n = n / 5;
        return n == 1;
    }

    // always return !!!
    public static boolean isUgly1(int n) {
        if (n <= 0)
            return false;
        if (n % 2 == 0)
            return isUgly(n / 2);
        else if (n % 3 == 0)
            return isUgly(n / 3);
        else if (n % 5 == 0)
            return isUgly(n / 5);
        return n == 1;
    }
}

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return true if n is an ugly number.
 *
 * Example 1:
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 *
 * Example 2:
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 * Example 3:
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 */