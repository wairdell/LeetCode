package com.wairdell.leetcode.problems;

/**
 * date   : 2024/4/29 13:40
 * desc   : 在 D 天内送达包裹的能力 https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days
 */
public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays capacity = new CapacityToShipPackagesWithinDDays();
        System.out.println(capacity.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1));
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(weights[i], max);
            sum += weights[i];
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            int pkg = 0, cnt = 1;
            for (int i = 0; i < weights.length; i++) {
                int weight = weights[i];
                if (pkg + weight > mid) {
                    pkg = weight;
                    cnt++;
                    continue;
                }
                pkg += weight;
            }
            if (cnt > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
