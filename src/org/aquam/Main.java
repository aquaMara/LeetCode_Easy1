package org.aquam;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int l = 10 % 10;
        int sdl = 9 % 10;
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(242));
        System.out.println(isPalindrome(243));
        System.out.println(isPalindrome(-242));
        System.out.println(isPalindrome(9));

    }

    public static boolean isPalindrome0(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString().equals(String.valueOf(x));
    }

    public static boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i))
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        // check, as 0, 1, 2, 3/// are palindromes
        // but 10 wil give 1, 100 will give 1, 1000 will give 1 and etc - 100% not palindromes
        // if number is < 0 than it is also 100% not a palindrome
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int trueNumber = x;
        int reversedNumber = 0;
        while (x > 0) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x = x / 10;
        }
        return trueNumber == reversedNumber;
    }
}
