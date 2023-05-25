package org.aquam;

import java.util.Stack;

// 5/9/2023
// 682. Baseball Game
public class E682 {

    public static void main(String[] args) {
        String[] ops1 = new String[]{"5","2","C","D","+"};
        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        String[] ops3 = {"1","C"};
        Stack<Integer> nums = new Stack<>();
        nums.push(1);   // search = 3
        nums.push(2);   // search = 2
        nums.push(3);   // search = 1
        // nums.search(11); search = -1
        int search = nums.search(1);
        int searchw = nums.search(3);
        System.out.println(calPoints(ops1));
        System.out.println(calPoints(ops2));
        System.out.println(calPoints(ops3));

    }

    public static int calPoints(String[] operations) {
        int operationsLength = operations.length;
        int[] stackArray = new int[operationsLength];
        int index = -1;
        for (String operation : operations) {
            switch(operation) {
                case "+":
                    int plus = stackArray[index] + stackArray[index - 1];
                    stackArray[++index] = plus;
                    break;
                case "D":
                    int d = stackArray[index] * 2;
                    stackArray[++index] = d;
                    break;
                case "C":
                    --index;
                    break;
                default:
                    stackArray[++index] = Integer.parseInt(operation);
                    break;
            }
        }
        int sum = 0;
        while (index >= 0)
            sum += stackArray[index--];
        return sum;
    }

    public static int calPointsSecond(String[] operations) {
        Stack<Integer> baseball = new Stack<>();
        for (String operation : operations) {
            switch (operation) {
                case "+":
                    Integer top = baseball.pop();
                    Integer prevTop = baseball.peek();
                    baseball.push(top);
                    baseball.push(top + prevTop);
                    break;
                case "D":
                    baseball.push(2 * baseball.peek());
                    break;
                case "C":
                    baseball.pop();
                    break;
                default:
                    baseball.push(Integer.valueOf(operation));
                    break;
            }
        }
        int sum = 0;
        while (baseball.size() > 0) {
            sum += baseball.pop();
        }
        return sum;
    }


    public static int calPointsFirst(String[] operations) {
        Stack<Integer> baseball = new Stack<>();
        for (String operation : operations) {
            switch (operation) {
                case "+":
                    Integer top = baseball.pop();
                    Integer prevTop = baseball.pop();
                    baseball.push(prevTop);
                    baseball.push(top);
                    baseball.push(top + prevTop);
                    break;
                case "D":
                    baseball.push(2 * baseball.peek());
                    break;
                case "C":
                    baseball.pop();
                    break;
                default:
                    baseball.push(Integer.valueOf(operation));
                    break;
            }
        }
        int sum = 0;
        while (baseball.size() > 0) {
            sum += baseball.pop();
        }
        return sum;
    }
}

/**
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
 * You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
 *
 * An integer x.
 * Record a new score of x.
 *
 * '+'.
 * Record a new score that is the sum of the previous two scores.
 *
 * 'D'.
 * Record a new score that is the double of the previous score.
 *
 * 'C'.
 * Invalidate the previous score, removing it from the record.
 *
 * Return the sum of all the scores on the record after applying all the operations.
 *
 * The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
 *
 * Example 1:
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 *
 * Example 2:
 * Input: ops = ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "-2" - Add -2 to the record, record is now [5, -2].
 * "4" - Add 4 to the record, record is now [5, -2, 4].
 * "C" - Invalidate and remove the previous score, record is now [5, -2].
 * "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
 * "9" - Add 9 to the record, record is now [5, -2, -4, 9].
 * "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
 * "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
 * The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
 *
 * Example 3:
 * Input: ops = ["1","C"]
 * Output: 0
 * Explanation:
 * "1" - Add 1 to the record, record is now [1].
 * "C" - Invalidate and remove the previous score, record is now [].
 * Since the record is empty, the total sum is 0.
 *
 * Constraints:
 * 1 <= operations.length <= 1000
 * operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
 * For operation "+", there will always be at least two previous scores on the record.
 * For operations "C" and "D", there will always be at least one previous score on the record.
 */
