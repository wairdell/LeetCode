package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/3/7 16:58
 * desc   : 种花问题 https://leetcode.cn/problems/can-place-flowers/description/
 */
public class CanPlaceFlowers {

    static class Impl {

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

    }

    static class ImplNew {

        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int joined = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    i++;
                } else {
                    boolean previous = (i == 0 || flowerbed[i - 1] == 0);
                    boolean next = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                    if (previous && next) {
                        joined++;
                        if (joined >= n) return true;
                        i++;
                    }
                }
            }
            return joined >= n;
        }

    }


    public static void main(String[] args) {
        CanPlaceFlowers.ImplNew canPlaceFlowers = new CanPlaceFlowers.ImplNew();
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));//true
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));//false
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));//true
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0}, 1));//true
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0, 1}, 1));//false

        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 1));//true
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0}, 1));//true
    }

}
