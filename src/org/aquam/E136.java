package org.aquam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// 5/29/2023
// 136. Single Number
// https://stackoverflow.com/questions/1991380/what-does-the-operator-do-in-java
public class E136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{1}));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static int singleNumber2(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
                result -= nums[i];
            } else {
                map.put(nums[i], nums[i]);
                result += nums[i];
            }
        }
        return result;
    }

    public static int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else
                map.put(nums[i], nums[i]);
        }
        return map.values().stream().findAny().get();
    }
}
/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
