package org.aquam;

// 5/2/2023
// 20. Valid Parentheses
public class _E20 {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));    // false
        System.out.println(isValid("{[]}"));    // true
        System.out.println(isValid("()[]"));
        System.out.println(isValid("()[]("));
        System.out.println(isValid("()[])"));
    }

    public static boolean isValid(String s) {
        int stringLength = s.length();
        String stackScreen = "";
        String openBrackets = "({[";
        String closeBrackets = ")}]";
        for (int i = 0; i < stringLength; i++) {
            char current = s.charAt(i);
            if (openBrackets.indexOf(current) != -1) {
                stackScreen += current;
            } else if (closeBrackets.indexOf(current) != -1) {
                String openToClose = stackScreen
                        .replaceAll("\\(", ")")
                        .replaceAll("\\{", "}")
                        .replaceAll("\\[", "]");
                String reverse = reverse(openToClose);

                int length = stackScreen.length();
                if (stringLength < i + length)
                    return false;
                String substring = s.substring(i, i + length);
                if (!substring.equals(reverse))
                    return false;
                i = i + length - 1;
                stackScreen = "";
            }
        }
        return true;
    }

    public static String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    /*

                System.out.println();

                for (int j = stackScreen.length() - 1; j >= 0; j--) {
                    char c = s.charAt(i);
                    boolean x stackScreen.charAt(j) == c;
                }
                for (int j = k; j < i + k; j++) {
                    char c = stackScreen.charAt(i - k);
                    boolean x = c == s.charAt(i);
                    System.out.println(x);
                }
     */

    public static boolean isValidWrong2(String s) {
        int k = 1;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == ']' && s.charAt(i - k) == '[')
                    || (s.charAt(i) == '}' && s.charAt(i - k) == '{')
                    || (s.charAt(i) == ')' && s.charAt(i - k) == '('))
                k += 2;
            else if ((s.charAt(i) == ']' && s.charAt(i - k) != '[')
                    || (s.charAt(i) == '}' && s.charAt(i - k) != '{')
                    || (s.charAt(i) == ')' && s.charAt(i - k) != '('))
                return false;
        }
        return true;
    }

    public static boolean isValidWrong1(String s) {
        int roundBracketsNumber = 0;
        int curlyBracketsNumber = 0;
        int squareBracketsNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(': ++roundBracketsNumber; break;
                case ')': --roundBracketsNumber; break;
                case '{': ++curlyBracketsNumber; break;
                case '}': --curlyBracketsNumber; break;
                case '[': ++squareBracketsNumber; break;
                case ']': --squareBracketsNumber; break;
                default: break;
            }
        }
        return roundBracketsNumber == 0 && curlyBracketsNumber == 0 && squareBracketsNumber == 0;
    }
}

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
