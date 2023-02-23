package com.wairdell.leetcode;

import java.util.Arrays;

/**
 * author : fengqiao
 * date   : 2023/2/22 14:02
 * desc   :
 */
public class QuickSorter {

    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        //用data[start] 作为基数，本次方法后基数放到应该在的索引(即索引前的数都小于这个数、索引后的数都大于这个数)
        int l = start, r = end, t = data[start];
        //因为 start 位置已记录，那么第一个无效位置就可以是 start 和 l(l = start)
        while (l < r) {
            //寻找后面小于基数的数的索引
            while (l < r && data[r] > t) {
                r--;
            }
            //找到索引放入到无效位置
            if (l < r) {
                data[l++] = data[r];
            }
            //上面的操作后，r位置元素是无效的

            //寻找前面大于基数的数
            while (l < r && data[l] < t) {
                l++;
            }
            if (l < r) {
                data[r--] = data[l];
            }
            //这里操作后，l 位置的元素也是无效的
        }
        //这里 l 和 r 应该是相等的，也即是基数的索引
        data[l] = t;

        //找到的索引前后部分也执行这个操
        quickSort(data, start, l - 1);
        quickSort(data, l + 1, end);
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 5, 7, 1, 9, 6};
        new QuickSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }

}
