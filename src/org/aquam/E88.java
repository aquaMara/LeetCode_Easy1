package org.aquam;

// 88. Merge Sorted Array
// 7/11/2023
public class E88 {

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{3, 4, 8, 0, 0, 0}, 3, new int[]{1, 2, 6}, 3);
        merge(new int[]{2, 3, 8, 9, 0, 0}, 4, new int[]{4, 6}, 2);
        merge(new int[]{2, 5, 8, 9, 0, 0}, 4, new int[]{3, 6}, 2);
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        --m;
        --n;
        int index = nums1.length - 1;

        while (m >= 0 && n >= 0) {
            nums1[index] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            --index;
        }

        // m и так уже на месте, если n < 0, а m >=0
        while (n >= 0) {
            nums1[index] = nums2[n--];
            --index;
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        --m;
        --n;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m < 0) {
                nums1[i] = nums2[n];
                --n;
            } else if (n < 0) {     // лишнее действие
                nums1[i] = nums1[m];
                --m;
            } else if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                --m;
            } else {    // if (nums1[m] < nums2[n])
                nums1[i] = nums2[n];
                n--;
            }
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}

/**
 * 88. Merge Sorted Array
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 *
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 *
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
