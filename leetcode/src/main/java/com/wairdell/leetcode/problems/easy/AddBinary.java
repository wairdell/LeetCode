package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/28 16:45
 * desc   : 二进制求和 https://leetcode.cn/problems/add-binary/
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary binary = new AddBinary();
        System.out.println(binary.addBinary("11", "10"));
    }

    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        StringBuilder ans = new StringBuilder();
        char carry = '0';
        for (int i = 0; i < maxLength; i++) {
            int i1 = a.length() - 1 - i;
            char ch1 = i1 < 0 ? '0' : a.charAt(i1);
            int i2 = b.length() - 1 - i;
            char ch2 = i2 < 0 ? '0' : b.charAt(i2);
            if (ch1 == '1' && ch2 == '1') {
                ans.insert(0, carry);
                carry = '1';
            } else if (ch1 == '1' || ch2 == '1') {
                ans.insert(0, (carry == '1' ? '0' : '1'));
            } else {
                ans.insert(0, carry);
                carry = '0';
            }
        }
        if (carry == '1') {
            ans.insert(0, '1');
        }
        return ans.toString();
    }



}
