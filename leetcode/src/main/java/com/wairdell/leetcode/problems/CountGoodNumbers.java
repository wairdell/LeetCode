package com.wairdell.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * date   : 2024/5/9 10:16
 * desc   : 统计好数字的数目 https://leetcode.cn/problems/count-good-numbers
 */
public class CountGoodNumbers {

    public static void main(String[] args) {
        CountGoodNumbers numbers = new CountGoodNumbers();
//        System.out.println(numbers.countGoodNumbers(4));
//        System.out.println(numbers.countGoodNumbers(1));
//        System.out.println(numbers.countGoodNumbers(50));
        System.out.println(numbers.countGoodNumbers(806166225460393L));
    }

    private long pow(int base, long n, Map<Long, Long> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n <= 10) {
            return (long) Math.pow(base, n) % 1000000007;
        }
        long ret = pow(base, n / 2, cache) * pow(base, n - (n / 2), cache) % 1000000007;
        cache.put(n, ret);
        return ret;
    }

    public int countGoodNumbers(long n) {
        long ans = 1;
        long even = n / 2 + (n % 2 == 0 ? 0 : 1);
        long odd = n / 2;
        ans = (ans * pow(5, even, new HashMap<>())) % 1000000007;
        ans = (ans * pow(4, odd, new HashMap<>())) % 1000000007;
        //1000000007
        return (int) ans;
    }

}
