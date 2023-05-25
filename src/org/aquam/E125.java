package org.aquam;

// 5/5/2023
public class E125 {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("  "));
    }

    public static boolean isPalindrome(String s) {
        String replaced = s.replaceAll("[^a-zA-Z0-9]", "");
        String lowerCased = replaced.toLowerCase();
        String reversed = "";
        for(int i = lowerCased.length() - 1; i >= 0; i--)
            reversed += lowerCased.charAt(i);
        return reversed.equals(lowerCased);
    }
}
