package com.wairdell.leetcode.problems.unsolved;

import java.util.Arrays;

/**
 * date   : 2024/4/26 10:18
 * desc   :
 */
public class CountGoodTriplets {

    public static void main(String[] args) {
        CountGoodTriplets triplets = new CountGoodTriplets();
        System.out.println(triplets.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
//        System.out.println(triplets.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        Arrays.sort(arr);
        int cnt = 0;
        int s = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int mn = arr[i];
            int l = s;
            int r = i + 1;
            while (l < i && r < arr.length) {
                int ln = arr[l];
                if (mn - ln > a) {
                    l++;
                    s = l;
                    continue;
                }
                int rn = arr[r];
                if (rn - mn > b) {
                    break;
                }
                if (rn - ln > c) {
                    l++;
                    continue;
                }
                //0 1 1 3 7 9
                cnt += (i - l) * (r - i);
                break;
            }
            //0,1,1
            //113
            //013
            //013
        }
        return cnt;
    }

}
