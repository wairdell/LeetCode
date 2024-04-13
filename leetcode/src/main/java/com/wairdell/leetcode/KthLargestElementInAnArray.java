package com.wairdell.leetcode;

import java.util.Random;

/**
 * date   : 2024/4/12 13:57
 * desc   :
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray.HeapImpl impl = new KthLargestElementInAnArray.HeapImpl();
        System.out.println(impl.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(impl.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
        System.out.println(impl.findKthLargest(new int[]{2, 1}, 1));
        System.out.println(impl.findKthLargest(new int[]{1, 2, 3, 4, 5, 6}, 1));
        System.out.println("------------------------------------");
        KthLargestElementInAnArray.PartitionImpl impl2 = new KthLargestElementInAnArray.PartitionImpl();
        System.out.println(impl2.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(impl2.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
        System.out.println(impl2.findKthLargest(new int[]{2, 1}, 1));
        System.out.println(impl2.findKthLargest(new int[]{1, 2, 3, 4, 5, 6}, 1));
    }

    static class HeapImpl {

        public int findKthLargest(int[] nums, int k) {
            int length = nums.length;
            //第一次构建堆(因为最后面的节点是没有叶子的，所以对最后面的有叶子的到根节点做堆化操作)
            for (int i = (nums.length - 2) / 2; i >= 0; i--) {
                siftDown(nums, length, i);
            }

            //求前K位最大的值，那么直接把K前面的元素都出堆，堆顶就是前K位最大的值
            while (--k > 0) {
                length--;
                swap(nums, 0, length);
                siftDown(nums, length, 0);
            }
            return nums[0];
        }

        private void siftDown(int[] nums, int length, int i) {
            while (true) {
                //将当前节点与左叶子节点和右叶节点进行比较，得到最大的位置
                int l = i * 2 + 1, r = i * 2 + 2, mark = i;
                if (l < length && nums[mark] < nums[l]) {
                    mark = l;
                }
                if (r < length && nums[mark] < nums[r]) {
                    mark = r;
                }
                //当前位置就是最大的直接return，无需交换值
                if (mark == i) return;

                //将两个位置的值进行交换，因为叶子节点的值发生了改变，用while循环对叶子节点做相同的操作
                swap(nums, i, mark);
                i = mark;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

    static class PartitionImpl {

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int[] partition(int[] nums, int l, int r) {
            int len = r - l + 1;
            int j = l + new Random().nextInt(len);
            int pivot = nums[j];
            int less = l, greater = r, i = l;
            while (i <= greater) {
                if (nums[i] < pivot) {
                    swap(nums, i, less);
                    i++;
                    less++;
                } else if (nums[i] > pivot) {
                    swap(nums, i, greater);
                    greater--;
                } else {
                    i++;
                }
            }
            return new int[]{less, greater};
        }

        public int findKthLargest(int[] nums, int k) {
            int l = 0, r = nums.length - 1;
            int target = nums.length - k;
            while (true) {
                int[] result = partition(nums, l, r);
                int less = result[0];
                int greater = result[1];
                if (target >= less && target <= greater) {
                    return nums[target];
                } else if (target < less) {
                    r = less - 1;
                } else {
                    l = greater + 1;
                }
            }
        }
    }


}
