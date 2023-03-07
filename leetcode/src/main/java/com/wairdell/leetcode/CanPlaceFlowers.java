package com.wairdell.leetcode;

/**
 * author : fengqiao
 * date   : 2023/3/7 16:58
 * desc   :
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int joined = 0;
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n == 1;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i > 1 && i < flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        joined++;
                        flowerbed[i] = 1;
                    }
                } else if (i == 0) {
                    if (flowerbed[i + 1] == 0) {
                        joined++;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i - 1] == 0) {
                        joined++;
                        flowerbed[i] = 1;
                    }
                }
                if (joined >= n) {
                    return true;
                }
            }
        }
        return joined >= n;
    }

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0, 1}, 1));
    }

}
