package org.aquam;

import java.util.LinkedList;
import java.util.Queue;

// 5/14/2023
// 387. First Unique Character in a String
public class E387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
        System.out.println(firstUniqChar("aac"));
        System.out.println(firstUniqChar("aadb"));
    }

    public static int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;

        // O(1) as the length is always same and equal to the length of english alphabet
        for (char i = 'a'; i <= 'z'; i++) {
            int indexOfLetterInString = s.indexOf(i);

            // if indexOfLetterInString == -1 => this char is not found in string
            // if indexOfLetterInString == s.lastIndexOf(c), this char exists in string only once
            // if indexOfLetterInString != s.lastIndexOf(c), this char exists more than once,
            // as we have the first and the last index of it

            // we compare: if index of a current char is less than result (index of prev appropriate char found),
            // this index now becomes the new result
            // if not less => prev char was earlier in string
            if (indexOfLetterInString != -1 && indexOfLetterInString == s.lastIndexOf(i))
                result = indexOfLetterInString < result ? indexOfLetterInString : result;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        boolean findRepeated = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*')
                continue;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    findRepeated = true;
                    chars[j] = '*';
                }
            }
            if (!findRepeated)
                return i;
            else {
                findRepeated = false;
                chars[i] = '*';
            }
        }
        return -1;
    }

    public static void deleteAllRepeatedSymbols(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int firstIndex = sb.indexOf(String.valueOf(c));
            int lastIndex = sb.lastIndexOf(String.valueOf(c));
            if (firstIndex != lastIndex && firstIndex != -1 && lastIndex != -1) {
                sb.deleteCharAt(lastIndex);
            }
        }
    }

    public static int firstUniqChar1(String s) {
        Queue<Character> queue = new LinkedList<>();
        Queue<Character> removalQueue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (queue.contains(chars[i]) || removalQueue.contains(chars[i])) {
                queue.remove(chars[i]);
                removalQueue.offer(chars[i]);
            } else
                queue.offer(chars[i]);
        }
        return queue.isEmpty() ? -1 : s.indexOf(queue.peek());
    }
}

/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
