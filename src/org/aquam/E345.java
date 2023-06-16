package org.aquam;

import java.util.Stack;

// 6/8/2023
// 345. Reverse Vowels of a String
public class E345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int j = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (i >= j)
                break;
            if (vowels.indexOf(chars[i]) != -1) {
                while (vowels.indexOf(chars[j]) == -1)
                    --j;
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public static String reverseVowels2(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        char[] charVowels = new char[chars.length];
        int k = 0;
        for (char c : chars) {
            if (vowels.indexOf(c) != -1)
                charVowels[k++] = c;
        }
        for (int i = 0; i < chars.length; i++) {
            if (vowels.indexOf(chars[i]) != -1)
                chars[i] = charVowels[--k];
        }
        return String.valueOf(chars);
    }

    public static String reverseVowels1(String s) {
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (vowels.indexOf(c) != -1)
                stack.push(c);
        }
        for (int i = 0; i < chars.length; i++) {
            if (vowels.indexOf(chars[i]) != -1)
                chars[i] = stack.pop();
        }
        return String.valueOf(chars);
    }
}
