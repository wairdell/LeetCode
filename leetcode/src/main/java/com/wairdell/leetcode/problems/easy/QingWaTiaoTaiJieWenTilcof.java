package com.wairdell.leetcode.problems.easy;

/**
 * author : fengqiao
 * date   : 2023/9/15 16:37
 * desc   : 跳跃训练 https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 */
public class QingWaTiaoTaiJieWenTilcof {

    public static void main(String[] args) {
        System.out.println(new QingWaTiaoTaiJieWenTilcof().numWays(2));
        System.out.println(new QingWaTiaoTaiJieWenTilcof().numWays(7));
        System.out.println(new QingWaTiaoTaiJieWenTilcof().numWays(0));
        System.out.println(new QingWaTiaoTaiJieWenTilcof().numWays(100));
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
        }
        return f[n - 1];
    }

}
