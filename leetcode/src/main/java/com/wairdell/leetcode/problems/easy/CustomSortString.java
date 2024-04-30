package com.wairdell.leetcode.problems.easy;

/**
 * date   : 2024/4/30 11:54
 * desc   :  自定义字符串排序 https://leetcode.cn/problems/custom-sort-string
 */
public class CustomSortString {

    public static void main(String[] args) {
        CustomSortString sortString = new CustomSortString();
        System.out.println(sortString.customSortString("cbafg", "abcd"));
    }

    private int compare(int[] sizeMap, int ch1, int ch2) {
        int size1 = sizeMap[ch1 - 'a'];
        int size2 = sizeMap[ch2 - 'a'];
        if (size1 == -1 || size2 == -1) return 0;
        if (size1 > size2) {
            return 1;
        } else if (size1 < size2) {
            return -1;
        }
        return 0;
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    private int[] partition(char[] s, int[] sizeMap, int l, int r) {
        char pivot = s[l];
        int less = l, i = l, greater = r;
        while (i <= greater) {
            int compare = compare(sizeMap, s[i], pivot);
            if (compare < 0) {
                swap(s, i++, less++);
            } else if (compare > 0) {
                swap(s, i, greater--);
            } else {
                i++;
            }
        }
        return new int[]{less, greater};
    }

    private void quickSort(char[] s, int[] sizeMap, int l, int r) {
        if (l >= r) return;
        int[] ret = partition(s, sizeMap, l, r);
        quickSort(s, sizeMap, l, ret[0] - 1);
        quickSort(s, sizeMap, ret[1] + 1, r);
    }

    public String customSortString(String order, String s) {
        int[] sizeMap = new int['z' - 'a' + 1];
        for (int i = 0; i < order.length(); i++) {
            sizeMap[order.charAt(i) - 'a'] = i;
        }
        char[] charArray = s.toCharArray();
        quickSort(charArray, sizeMap, 0, charArray.length - 1);
        return new String(charArray);
    }

}
