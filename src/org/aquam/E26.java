package org.aquam;

import java.util.Arrays;

// Remove Duplicates from Sorted Array
public class E26 {

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int[] s = new int[]{1, 2};
        System.out.println(removeDuplicates(nums1));
        System.out.println(removeDuplicates(nums2));
        System.out.println(removeDuplicates(new int[]{2, 3, 8, 8}));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 1;  // from the first element, because 0 element is already present
        int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[k++] = nums[i + 1];
            }
        }
        return k;
    }

    public static int removeDuplicatesGood(int[] nums) {
        int k = 1;  // from the first element, because 0 element is already present
        int numsLength = nums.length;
        int[] oldNums = Arrays.copyOf(nums, numsLength);
        for (int i = 0; i < numsLength - 1; i++) {
            if (oldNums[i] != oldNums[i + 1]) {
                nums[k++] = nums[i + 1];
            }
        }
        return k;
    }

    public static int removeDuplicates1(int[] nums) {
        int k = 0;
        int numsLength = nums.length;
        int[] expectedNums = new int[numsLength];
        expectedNums[k++] = nums[0];
        for (int i = 0; i < numsLength - 1; i++) {
            if (nums[i] != nums [i + 1]) {
                expectedNums[k++] = nums[i + 1];
            }
        }
        return k;
    }

    public static int removeDuplicates0(int[] nums) {
        int k = 0;
        int[] nums34 = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums [i + 1]) {
                nums34[k++] = nums[i];
            }
            if (i == nums.length - 2 && nums[nums.length - 2] != nums[nums.length - 1])
                nums34[k++] = nums[i + 1];
        }
        return k;
    }

}
