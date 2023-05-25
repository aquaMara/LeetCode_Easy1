package org.aquam;

import java.util.Arrays;

// 5/16/2023
// 1700. Number of Students Unable to Eat Lunch
public class E1700 {

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int zeroStudents = 0;
        int oneStudents = 0;
        for (int student : students) {
            if (student == 0)
                ++zeroStudents;
            else
                ++oneStudents;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeroStudents == 0)  // sandwiches 0 left, but no students 0 left - that means that this sandwich will be on top
                    return oneStudents; // and 1 students will change their places without a chance to eat
                --zeroStudents;
            } else {
                if (oneStudents == 0)   // here we have 1 sandwich on top, but no 1 students left
                    return zeroStudents;    // if students 0 left, they will change their places infinitely
                --oneStudents;  // but sandwich 1 will still be on top, so they won't have a chance to eat
            }
        }
        return 0;   // if we are not in cycle - no sandwiches left, sandwiches.length = students.length => everybody is fed
    }

    // memory 40 mb beats 98.33%
    // memory 0 ms beats 100%
    public static int countStudents2(int[] students, int[] sandwiches) {
        int unfed = students.length;
        int counter = 0;
        int bigIndex = students.length;
        int smallIndex = bigIndex;
        int length = students.length;
        for (int i = 0; i < sandwiches.length; i++) {
            while (sandwiches[i] != students[bigIndex - smallIndex]) {
                counter++;

                smallIndex = smallIndex - 1 == 0 ? bigIndex : smallIndex - 1;
                if (counter == length)
                    return unfed;
            }

            students[bigIndex - smallIndex] = -1;
            smallIndex = smallIndex - 1 == 0 ? bigIndex : smallIndex - 1;;
            --unfed;
            counter = 0;
        }
        return unfed;
    }

    public static int countStudents1(int[] students, int[] sandwiches) {
        for (int i = 0; i < sandwiches.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (sandwiches[i] == students[0]) {
                    students = Arrays.copyOfRange(students, 1, students.length);
                    break;
                } else {
                    int temp = students[0];
                    students = Arrays.copyOfRange(students, 1, students.length + 1);
                    students[students.length - 1] = temp;
                }
                if (j == students.length - 1)
                    return students.length;
            }
        }
        return students.length;
    }
}

/**
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively.
 * All students stand in a queue. Each student either prefers square or circular sandwiches.
 * The number of sandwiches in the cafeteria is equal to the number of students.
 * The sandwiches are placed in a stack. At each step:
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 *
 * Example 1:
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 *
 * Example 2:
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 *
 * Constraints:
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] is 0 or 1.
 * students[i] is 0 or 1.
 */
