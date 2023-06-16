package org.aquam;

// 5/29/2023
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class E28plus {

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("hellohihey", "hi"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    /*
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int nLen = needle.length();

        int[] nFreq = new int[26];
        for (int i = 0; i < nLen; i++) {
            nFreq[needle.charAt(i) - 'a']++;
        }

        int[] hFreq = new int[26];
        for (int i = 0; i < nLen - 1; i++) {
            hFreq[haystack.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= haystack.length() - nLen; i++) {
            hFreq[haystack.charAt(i + nLen - 1) - 'a']++;
            if (equal(nFreq, hFreq) && strEq(needle, haystack, i)) {
                return i;
            }

            hFreq[haystack.charAt(i) - 'a']--;
        }

        return -1;
    }

    boolean equal(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    boolean strEq(String needle, String haystack, int offset) {
        for (int i = 0; i < needle.length(); i++) {
            if (needle.charAt(i) != haystack.charAt(i + offset)) {
                return false;
            }
        }

        return true;
    }
     */




    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (haystack.charAt(i + j) == needle.charAt(j)) {
                ++j;
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        if (haystack.contains(needle))
            return haystack.indexOf(needle);
        else
            return -1;
    }

    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
