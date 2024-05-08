package com.wairdell.leetcode.problems;

import java.util.Arrays;

/**
 * date   : 2024/5/8 15:36
 * desc   : 计数质数 https://leetcode.cn/problems/count-primes
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes primes = new CountPrimes();
        System.out.println(primes.countPrimes(499979));
    }

    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                ans++;
                if ((long) i * i > n) continue;
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        return ans;
    }

}
