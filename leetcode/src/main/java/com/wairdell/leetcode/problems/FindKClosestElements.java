package com.wairdell.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * date   : 2024/4/25 15:49
 * desc   : 找到 K 个最接近的元素 https://leetcode.cn/problems/find-k-closest-elements
 */
public class FindKClosestElements {

    public static void main(String[] args) {
        FindKClosestElements elements = new FindKClosestElements();
        System.out.println(elements.findClosestElements(new int[]{1, 9, 2, 3, 4, 5}, 4, 3));
        System.out.println(elements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println(elements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 7));
        System.out.println(elements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, -1));

        System.out.println(elements.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));


    }

    static class Heap {

        private int[] nums;
        private int n;
        private int x;

        Heap(int[] arr, int k, int x) {
            this.nums = new int[k];
            this.n = k;
            this.x = x;
            for (int i = 0; i < k; i++) {
                nums[i] = arr[i];
            }
            for (int i = (n - 2) / 2; i >= 0; i--) {
                shitDown(i);
            }
        }

        void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


        boolean compareIndex(int i, int j) {
            return compareValue(nums[i], nums[j]);
        }

        boolean compareValue(int v1, int v2) {
            int abs1 = Math.abs(v1 - x);
            int abs2 = Math.abs(v2 - x);
            /*if (abs1 == abs2) {
                return v1 < v2;
            }*/
            return abs1 > abs2;
        }

        void shitDown(int i) {
            while (true) {
                int l = i * 2 + 1, r = i * 2 + 2, mark = i;
                if (l < n && compareIndex(l, mark)) {
                    mark = l;
                }
                if (r < n && compareIndex(r, mark)) {
                    mark = r;
                }
                if (i == mark) break;
                swap(i, mark);
                i = mark;
            }
        }

        void push(int num) {
            if (compareValue(nums[0], num)) {
                nums[0] = num;
                shitDown(0);
            }
        }

        List<Integer> getAns() {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            Collections.sort(list);
            return list;
        }

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Heap heap = new Heap(arr, k, x);
        for (int i = k; i < arr.length; i++) {
            heap.push(arr[i]);
        }
        return heap.getAns();
    }

}
