package com.ccf.sort.quick;

import java.util.Arrays;

public class QuickSort {
    public void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //对a数组中，从lo到hi的元素进行切分
        int partition = partition(a, lo, hi);
        // 对左边分组中的元素进行排序
        sort(a, lo, partition - 1);
        // 对右边分组中的元素进行排序
        sort(a, partition + 1, hi);
    }

    public int partition(Comparable[] a, int lo, int hi) {
        int right = hi;
        int left = lo;
        int baseIndex = lo;
        while (true) {

            while (right > left && less(a[baseIndex], a[right])) {
                right--;
            }

            while (right > left && less(a[left], a[baseIndex])) {
                left--;
            }

            if (right <= left) {
                break;
            } else {
                exch(a, right, left);
            }
        }
        exch(a, baseIndex, right);
        return right;
    }

    /**
     * 比较v元素是否小于w元素
     */
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 数组元素i和j交换位置
     */
    private void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
