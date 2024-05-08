package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/8 9:38
 * desc   : 给植物浇水 https://leetcode.cn/problems/watering-plants
 */
public class WateringPlants {

    public static void main(String[] args) {
        WateringPlants plants = new WateringPlants();
        System.out.println(plants.wateringPlants(new int[]{2, 2, 3, 3}, 5));
        System.out.println(plants.wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
        System.out.println(plants.wateringPlants(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
    }

    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int surplus = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (surplus >= plants[i]) {
                ans += 1;
            } else {
                ans += i * 2 + 1;
                surplus = capacity;
            }
            surplus -= plants[i];
        }
        return ans;
    }

}
