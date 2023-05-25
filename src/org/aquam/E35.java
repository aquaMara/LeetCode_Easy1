package org.aquam;

// 4/28/2023
// 35. Search Insert Position
public class E35 {

    public static void main(String[] args) {

        int x = 1 / 2;
        int y = 1 - 1 / 2;
        double l = (7 * 1.0 - 6) / 2;
        int m = (int) Math.ceil(l);


        int ml = (int) Math.ceil((7 * 1.0 - 6) / 2);


        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9, 11, 14, 15, 16}, 1));

        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9, 11, 14, 15, 16}, 16));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9, 11, 14, 15, 16}, 8));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9, 11, 14, 15, 16}, 3));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9, 11, 14, 15, 16}, 15));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9, 11, 14, 15, 16}, 11));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9, 11}, 9));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8, 9}, 3));
        int[] nums1 = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums1, 5));
        System.out.println(searchInsert(nums1, 2));
        System.out.println(searchInsert(nums1, 4));
        System.out.println(searchInsert(nums1, 7));
        System.out.println(searchInsert(nums1, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int i = endIndex - (endIndex - startIndex) / 2; // start + (end - start) / 2    // (start + end) / 2
            if (target < nums[i])
                endIndex = i - 1;
            else if (target > nums[i])
                startIndex = i + 1;
            else
                return i;
        }
        return startIndex;
    }

    public static int searchInsertFirst(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int i = nums.length / 2;
        if (nums[nums.length - 1] < target)
            return nums.length;
        if (nums[0] >= target)
            return 0;
        while (i != endIndex) {
            if (target < nums[i]) {   // left, startIndex doesn't change
                endIndex = i;
                i = endIndex - (int) Math.ceil((endIndex * 1.0 - startIndex) / 2);
            } else if (target > nums[i]) {    // right, endIndex doesn't change
                startIndex = i;
                i = endIndex - (endIndex - startIndex) / 2;
            } else {
                return i;
            }
        }
        return i;
    }
}

/**
 * 35. Search Insert Position
 * Easy
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.*
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */