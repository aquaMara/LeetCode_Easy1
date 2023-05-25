package org.aquam;

// 5/17/2023
// 231. Power of Two
// https://leetcode.com/problems/power-of-two/description/
public class E231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(30));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(2));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        if (n % 2 == 0)
            return isPowerOfTwo(n / 2);
        return n == 1;
    }

    public static boolean isPowerOfTwo1(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        while (n % 2 == 0) {
            n = n / 2;
            if (n == 1)
                return true;
        }
        return false;
    }

    public static boolean isDivisibleByTwo(int n) {
        int lastDigit = n % 10;
        int lastDigitDivisibleByTwo = lastDigit % 2;
        if (lastDigitDivisibleByTwo == 0)
            return true;
        return false;
    }
}

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 *
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 * Input: n = 3
 * Output: false
 *
 * Constraints:
 * -231 <= n <= 231 - 1
 *
 * Follow up: Could you solve it without loops/recursion?
 */