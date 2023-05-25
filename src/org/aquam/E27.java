package org.aquam;

// 4/27/2023
public class E27 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,2,3};
        System.out.println(removeElement(nums1, 3));
        int[] nums2 = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums2, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }

    public static int removeElementSecond(int[] nums, int val) {
        // 2 3 8 3 2 (3)
        int k = 0;
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] != val) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
        return k;
    }
}
