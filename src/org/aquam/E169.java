package org.aquam;

import java.util.HashMap;

// 6/14/2023
// 169. Majority Element
public class E169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer number = map.get(num);
                if (number + 1 > length / 2)
                    return num;
                map.put(num, ++number);
            } else
                map.put(num, 1);
        }
        return nums[0];
    }
}
