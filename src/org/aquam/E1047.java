package org.aquam;

import java.util.Stack;

// 5/9/2023
// 1047. Remove All Adjacent Duplicates In String
/**
 * StringBuilder executes significantly faster than the String class
 * when performing the concatenation or modification operations.
 * Modifying a String creates a new String in the heap memory.
 * To change the content of the String, we should consider the StringBuilder class.
 */
public class E1047 {

    public static void main(String[] args) {
        String s1 = "abbaca";
        String s2 = "azxxzy";
        String h1 = "abcdef";

        // substring for String = not including last index
        // StringBuilder has a remove function

        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("aaadcd"));
        System.out.println(removeDuplicates(s1));
        System.out.println(removeDuplicates(s2));
    }

    public static String removeDuplicates(String s) {
        // StringBuilder is better than String
        StringBuilder stackString = new StringBuilder();
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            if (stackString.length() == 0) {
                stackString.append(s.charAt(i));
            }
            else {
                char top = stackString.charAt(stackString.length() - 1);
                if (top != s.charAt(i)) {
                    stackString.append(s.charAt(i));
                } else {
                    stackString.deleteCharAt(stackString.length() - 1);
                }
            }
        }
        return stackString.toString();
    }

    public static String removeDuplicatesFourth(String s) {
        Stack<Character> stack = new Stack<>();
        int stringLength = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < stringLength; i++) {
            if (!stack.empty() && stack.peek() == chars[i])
                stack.pop();
            else {
                stack.push(chars[i]);
            }
        }
        StringBuilder stackString = new StringBuilder();
        for (Character c : stack)
            stackString.append(c);
        return stackString.toString();
    }

    public static String removeDuplicatesThird(String s) {
        // with array and index
        int sLength = s.length();
        char[] stackArray = new char[sLength];
        int stackIndex = 0;
        for (int i = 0; i < sLength; i++) {
            if (stackIndex == 0) {
                stackArray[stackIndex++] = s.charAt(i);
            } else {
                char top = stackArray[stackIndex - 1];
                if (top != s.charAt(i))
                    stackArray[stackIndex++] = s.charAt(i);
                else
                    --stackIndex;
            }
        }
        String sequence = "";
        for (int i = 0; i < stackIndex; i++) {
            sequence += stackArray[i];
        }
        return sequence;
    }

    public static String removeDuplicatesSecond(String s) {
        // StringBuilder is better than String
        String stackString = "";
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            if (stackString.isBlank()) {
                stackString += s.charAt(i);
            }
            else {
                char top = stackString.charAt(stackString.length() - 1);
                if (top != s.charAt(i)) {
                    stackString += s.charAt(i);
                } else {
                    stackString = stackString.substring(0, stackString.length() - 1);
                }
            }
        }
        return stackString;
    }

    public static String removeDuplicatesFirst(String s) {
        Stack<Character> stack = new Stack<>();
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            if (stack.empty())
                stack.push(s.charAt(i));
            else {
                Character top = stack.pop();
                if (top != s.charAt(i)) {
                    stack.push(top);
                    stack.push(s.charAt(i));
                }
            }
        }
        String stackString = "";
        for (Character c : stack) {
            stackString += c;
        }
        return stackString;
    }
}

/**
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 *
 * Example 1:
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Example 2:
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
