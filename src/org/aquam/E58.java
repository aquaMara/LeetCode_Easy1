package org.aquam;

// 58. Length of Last Word
// 6/6/2023
public class E58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));

        String s1 = "   Hi KK    ";
        String[] split1 = s1.split(" ");
        String s2 = "   Hi    KK    ";
        String[] split2 = s2.split(" ");
    }

    public static int lengthOfLastWord(String s) {
        int endIndex = s.length() - 1;
        while (endIndex >= 0 && s.charAt(endIndex) == ' ')
            --endIndex;
        int startIndex = endIndex;
        while (startIndex >= 0 && s.charAt(startIndex) != ' ')
            --startIndex;
        return endIndex - startIndex;
    }

    public static int lengthOfLastWord2(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    public static int lengthOfLastWord1(String s) {
        char[] charArray = s.toCharArray();
        int wordLength = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            if (charArray[i] != ' ')
                ++wordLength;
            if (charArray[i] == ' ' && wordLength != 0)
                break;
        }
        return wordLength;
    }
}

/**
 * 58. Length of Last Word
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
