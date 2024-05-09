package com.wairdell.leetcode.problems;

/**
 * date   : 2024/5/9 9:42
 * desc   : 给植物浇水 II https://leetcode.cn/problems/watering-plants-ii
 */
public class WateringPlantsII {

    public static void main(String[] args) {
        WateringPlantsII plantsII = new WateringPlantsII();
//        System.out.println(plantsII.minimumRefill(new int[]{2, 2, 3, 3}, 5, 5));
//        System.out.println(plantsII.minimumRefill(new int[]{2, 2, 3, 3}, 3, 4));
        System.out.println(plantsII.minimumRefill(new int[]{923, 65, 50, 788, 446, 122, 987, 355, 528, 590, 69, 107, 656, 676, 454, 604, 213, 299, 969, 239, 341, 940, 690, 195, 884, 135, 499, 38, 440, 857, 404, 266, 786, 915, 564, 246, 271, 977, 775, 978, 166, 636, 494, 284, 435, 630, 584, 590, 401, 167}, 1455, 1343));
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int i = 0, j = plants.length - 1;
        int remA = capacityA, remB = capacityB;
        while (i <= j) {
            if (remA < plants[i]) {
                remA = capacityA;
                ans++;
            }
            if (i < j && remA >= plants[i]) {
                remA -= plants[i];
                i++;
            }


            if (remB < plants[j]) {
                remB = capacityB;
                ans++;
            }
            if (i < j && remB >= plants[j]) {
                remB -= plants[j];
                j--;
            }

            if (i == j) {
                if (remA < plants[i] && remB < plants[i]) {
                    ans++;
                }
                break;
            }
        }
        return ans;
    }

}
