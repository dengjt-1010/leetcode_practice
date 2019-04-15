package com.department.deng.排序算法;

/**
 * Created by deng on 19-4-15.
 * 快排
 * <p>
 * <p>
 * topK:   https://www.cnblogs.com/sunshisonghit/p/4357551.html
 */
public class QuickSortMethod {

    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }


    public static void main(String[] args) {

        int[] a = {3, 1, 4, 5, 9, 2, 6, 8, 7};

        QuickSortMethod.sort(a, 0, a.length - 1);

        for (int t : a) {
            System.out.println(t + ",");
        }
    }
}
