package com.wairdell.leetcode.exapmle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * date   : 2024/4/13 21:53
 * desc   : 桶排序
 *          它通过设置一些具有大小顺序的桶，每个桶对应一个数据范围，将数据平均分配到各个桶中；然后，在每个桶内部分别执行排序；最终按照桶的顺序将所有数据合并。
 */
public class BucketSort {

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] input = {4, 1, 3, 2};
        bucketSort.bucketSort(input);
        System.out.println(Arrays.toString(input));

        int[] input2 = {4, 5, 9, 7, 3, 2};
        bucketSort.bucketSort(input2);
        System.out.println(Arrays.toString(input2));
    }

    void bucketSort(int[] args) {
        int k = 3;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < args.length; i++) {
            max = Math.max(args[i], max);
            min = Math.min(args[i], min);
        }
        float section = Math.max(1f, (max - min) * 1f / (k - 1));
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < args.length; i++) {
            int which = (int) ((args[i] - min) / section);
            buckets.get(which).add(args[i]);
        }
        int i = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int j = 0; j < bucket.size(); j++) {
                args[i++] = bucket.get(j);
            }
        }
    }

}
