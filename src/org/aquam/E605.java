package org.aquam;

// 6/30/2023
// 605. Can Place Flowers
public class E605 {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                if (--n == 0)
                    return true;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        boolean left, right;

        for (int i = 0; i < flowerbed.length; i++) {
            left = false;
            right = false;
            if (flowerbed[i] == 0) {
                if (i == 0 || flowerbed[i - 1] == 0)
                    left = true;
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
                    right = true;
                if (left && right) {
                    flowerbed[i] = 1;
                    if (--n == 0)
                        break;
                }
            }
        }
        return n <= 0;
    }

    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int flowerCounter = 0;
        boolean left, right;

        for (int i = 0; i < flowerbed.length; i++) {
            left = false;
            right = false;
            if (flowerbed[i] == 0) {
                if (i == 0 || flowerbed[i - 1] == 0)
                    left = true;
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
                    right = true;
                if (left && right) {
                    flowerbed[i] = 1;
                    ++flowerCounter;
                }
            }
        }
        return flowerCounter >= n;
    }
}

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return true if n new flowers can be planted in the flowerbed
 * without violating the no-adjacent-flowers rule and false otherwise.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 * Constraints:
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
