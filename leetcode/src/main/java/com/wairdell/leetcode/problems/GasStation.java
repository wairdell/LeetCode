package com.wairdell.leetcode.problems;

import com.sun.org.apache.bcel.internal.generic.FADD;

/**
 * date   : 2024/4/26 18:06
 * desc   : 加油站 https://leetcode.cn/problems/gas-station
 */
public class GasStation {

    public static void main(String[] args) {
        GasStation station = new GasStation();
        System.out.println(station.canCompleteCircuit(new int[]{4, 5, 2, 6, 5, 3}, new int[]{3, 2, 7, 3, 2, 9}));//-1
        System.out.println(station.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));//3
        System.out.println(station.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));//-1
        System.out.println(station.canCompleteCircuit(new int[]{5, 8, 2, 8}, new int[]{6, 5, 6, 6}));//3
        System.out.println(station.canCompleteCircuit(new int[]{1, 1, 3}, new int[]{2, 2, 1}));//2
        System.out.println(station.canCompleteCircuit(new int[]{5}, new int[]{4}));//0

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] mx = new int[gas.length];
        int[] mxl = new int[gas.length];
        int[] mxi = new int[gas.length];
        int j = 0;
        boolean isPositive = true;
        int max = 0;
        int z = 0;
        for (int i = 0; i < mx.length; i++) {
            mx[i] = gas[i] - cost[(i) % mx.length];
            if (i == 0) {
                mxl[j] = mx[i];
                isPositive = mx[i] > 0;
                continue;
            }
            if (isPositive && mx[i] >= 0) {
                mxl[j] += mx[i];
                if (max < mxl[j]) {
                    max = mx[j];
                    z = j;
                }
            } else if (!isPositive && mx[i] <= 0) {
                mxl[j] += mx[i];
            } else {
                mxl[++j] = mx[i];
                mxi[j] = i;
                isPositive = !isPositive;
            }
        }
        if (j == 0) return mxl[0] > 0 ? 0 : -1;
        if (mxl[0] < 0 && mxl[j] < 0) {
            mxl[0] = mxl[0] + mxl[j];
            mxi[0] = mxi[j];
        } else if (mxl[0] > 0 && mxl[j] > 0) {
            mxl[0] = mxl[0] + mxl[j];
            mxi[0] = mxi[j];
            if (z == j) {
                z = 0;
            }
        } else {
            j++;
        }
        int sum = 0;
        for (int i = 0; i < j; i++) {
            sum += mxl[i];
        }
        if (sum < 0) return -1;
        /*for (int i = z; i < j + z - 1; i++) {
            int first = mxl[i % j];
            int second = mxl[(i + 1) % j];
            if (first + sum + second == 0 && i + 1 != j + z - 1) {
                return -1;
            } else if (first + sum + second < 0) {
                return -1;
            } else {
                sum += (first + (i + 1) % j);
            }
        }*/
        max = -1;
        for (int i = 0; i < j; i++) {
            int i1 = mxl[(i + 1) % j] + mxl[i];
            if (mxl[i] > 0 && i1 > max) {
                max = i1;
                z = i;
            }
        }
        return mxi[z];
    }


}
