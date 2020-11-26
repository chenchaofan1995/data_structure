package com.ccf.sort.selection;

import java.util.Arrays;

public class Selection {
    /**
     * 对数组内的元素进行排序
     *
     * @param a
     */
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            exch(a, minIndex, i);
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
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        Selection selection = new Selection();
        selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
