package org.aquam;

import java.util.Arrays;

// 6/6/2023
// 14. Longest Common Prefix
public class E14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;
        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) == last.charAt(index))
                ++index;
            else
                break;
        }
        if (index == 0)
            return "";
        else
            return first.substring(0, index);
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                int i1 = strs[i].indexOf(prefix);
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.equals(""))
                return prefix;
        }
        return prefix;
    }

    public static String longestCommonPrefix1(String[] strs) {
        int index = 0;
        int controlLength = strs[0].length();
        for (int i = 0; i < strs.length - 1; i++) {
            while (index < strs[i].length() && index < strs[i + 1].length()) {
                if (strs[i].charAt(index) != strs[i + 1].charAt(index) || index >= controlLength)
                    break;
                if (strs[i].charAt(index) == strs[i + 1].charAt(index))
                    ++index;
            }
            if (index == 0)
                return "";
            if (index < controlLength)
                controlLength = index;
            index = 0;
        }
        return strs[0].substring(0, controlLength);
    }
}

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
