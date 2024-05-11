package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/5/10 17:49
 * desc   : 统计已测试设备 https://leetcode.cn/problems/count-tested-devices-after-test-operations
 */
public class CountTestedDevicesAfterTestOperations {

    public static void main(String[] args) {
        CountTestedDevicesAfterTestOperations operations = new CountTestedDevicesAfterTestOperations();
        System.out.println(operations.countTestedDevices(new int[]{1, 1, 2, 1, 3}));
        System.out.println(operations.countTestedDevices(new int[]{0,1,2}));
    }

    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - ans > 0) {
                ans++;
            }
        }
        return ans;
    }

}
