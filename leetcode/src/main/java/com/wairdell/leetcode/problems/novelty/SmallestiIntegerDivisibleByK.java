package com.wairdell.leetcode.problems.novelty;

import java.util.HashSet;
import java.util.Set;

/**
 * date   : 2024/4/28 13:33
 * desc   : 可被 K 整除的最小整数 https://leetcode.cn/problems/smallest-integer-divisible-by-k
 */
public class SmallestiIntegerDivisibleByK {

    public static void main(String[] args) {
        SmallestiIntegerDivisibleByK byK = new SmallestiIntegerDivisibleByK();
        System.out.println(byK.smallestRepunitDivByK(1));
        System.out.println(byK.smallestRepunitDivByK(2));
        System.out.println(byK.smallestRepunitDivByK(3));
    }

    public int smallestRepunitDivByK(int k) {
        int res = 1 % k, len = 1;
        Set<Integer> set = new HashSet<>();
        set.add(res);
        while (res != 0) {
            res = (res * 10 + 1) % k;
            len++;
            if (set.contains(res)) {
                return -1;
            }
            set.add(res);
        }
        return len;
    }

}
