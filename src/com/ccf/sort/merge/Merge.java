package com.ccf.sort.merge;

import java.util.Arrays;

public class Merge {
    //归并所需要的辅助数组
    private Comparable[] assist;

    /* 对数组a中的元素进行排序 */
    public void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    /**
     * 对数组a中从lo到hi的元素进行排序
     */
    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        //对lo到mid之间的元素进行排序；
        sort(a, lo, mid);
        //对mid+1到hi之间的元素进行排序
        sort(a, mid + 1, hi);
        //对lo到mid这组数据和mid到hi这组数据进行归并
        merge(a, lo, mid, hi);
    }

    /**
     * 对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并
     */
    private void merge(Comparable[] a, int lo, int mid, int hi) {
        //定义一个指针，指向assist数组中开始填充数据的索引
        int i = lo;
        //定义一个指针，指向第一组数据的第一个元素
        int p1 = lo;
        //定义一个指针，指向第二组数据的第一个元素
        int p2 = mid + 1;

        //比较左边小组和右边小组中的元素大小，哪个小，就把哪个数据填充到assist数组中
        while (p1 <= mid && p2 <= hi) {
            if (this.less(a[p1], a[p2])) {
                this.assist[i] = a[p1];
                i++;
                p1++;
            } else {
                this.assist[i] = a[p2];
                i++;
                p2++;
            }
        }

        while (p1 <= mid) {
            this.assist[i] = a[p1];
            i++;
            p1++;
        }
        while (p2 <= hi) {
            this.assist[i] = a[p2];
            i++;
            p2++;
        }

        //到现在为止，assist数组中，从lo到hi的元素是有序的，再把数据拷贝到a数组中对应的索引处
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
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
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        Merge merge = new Merge();
        merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
