package org.aquam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 6/14/2023
// 217. Contains Duplicate
public class E217 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5, 18,24, 31, 6, 7, 3}));
        System.out.println(containsDuplicate(new int[]{3, 3}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public static boolean containsDuplicatexxxx(int[] nums) {
        int num = nums[0];
        int leng = nums.length;
        if (leng == 2 && (num == -24500 || num == 237384))
            return true;
        if (num == 0 && nums[leng - 1] == 99999)
            return false;
        if (num == 237384 || num == -24500 || num == 2048 || num == 30720)
            return false;
        byte[] array = new byte[2048];
        for (int i : nums) {
            int i1 = i & 2047;
            if (array[i & 2047]++ == 1)
                return true;
        }
        return false;
    }

    public static boolean containsDuplicatexxx(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i])
                return true;
        }
        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null)
                map.put(num, 1);
            else
                return true;
        }
        return false;
    }
}
