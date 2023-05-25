package org.aquam;

// 5/23/2023
// 283. Move Zeroes
public class E283 {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{0,1,0,0,3,12});
        moveZeroes(new int[]{0});
    }

    public static void moveZeroes(int[] nums) {
        int notZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeros++] = nums[i];
            }
        }
        for (int i = notZeros; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void moveZeroes1(int[] nums) {
        int moveDigit = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                ++moveDigit;
            else if (moveDigit != 0)
                nums[i - moveDigit] = nums[i];

        }
        while (moveDigit != 0) {
            nums[nums.length - moveDigit--] = 0;
        }
    }
}

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * Follow up: Could you minimize the total number of operations done?
 */
