package com.ccf.sort.insertion;

import java.util.Arrays;

public class Insertion {
    /**
     * 对数组内的元素进行排序
     *
     * @param a
     */
    public void sort(Comparable[] a) {
        //1. 确定增长量h的最大值
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(a[j - 1], a[j])) {
                    exch(a,j-1,j);
                }else{
                    break;
                }
            }
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
        Insertion insertion = new Insertion();
        insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
