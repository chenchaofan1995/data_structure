package com.ccf.sort.shell;

import java.util.Arrays;

public class Shell {


    /**
     * 对数组内的元素进行排序
     *
     * @param a
     */
    public void sort2(Comparable[] a) {
        //1. 确定增长量h的最大值
        int N = a.length;
        int h = 1;
        while (h < N / 2) {
            h = h * 2 + 1;
        }

        while (h >= 1) {
            for (int i = N - 1; i > h; i--) {
                for (int j = i; j >= h; j = j - h) {
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    }
                }
            }
            h = h / 2;
        }
    }

    /**
     * 对数组内的元素进行排序
     *
     * @param a
     */
    public void sort(Comparable[] a) {
        //1. 确定增长量h的最大值
        int N = a.length;
        int h = 1;
        while (h < N / 2) {
            h = h * 2 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    }
                }
            }
            h = h / 2;
        }
    }

    /**
     * 判断v是否大于w
     *
     * @param v
     * @param w
     * @return
     */
    public boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
     *
     * @param a
     * @param i
     * @param j
     */
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1,3,5};
        Shell shell = new Shell();
        shell.sort2(a);
        System.out.println(Arrays.toString(a));
    }
}
