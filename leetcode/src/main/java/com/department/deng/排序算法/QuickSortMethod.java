package com.department.deng.排序算法;

/**
 * Created by deng on 19-4-15.

 *          快排的思想：
 *         https://baijiahao.baidu.com/s?id=1617821935743300963&wfr=spider&for=pc
 * <p>
 * <p>
 *        topK:   https://www.cnblogs.com/sunshisonghit/p/4357551.html
 */
public class QuickSortMethod {


    public static int partition(int[] array, int lo, int hi) {

        int key = array[lo];
        while (lo < hi) {

            while (array[hi] >= key && lo < hi) {
                hi--;
            }
            array[lo] = array[hi];

            while (array[lo] < key && lo < hi) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[lo] = key;
        return lo;

    }

    public static void sort(int[] array, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = partition(array, lo, hi);

        sort(array, lo, mid - 1);
        sort(array, mid + 1, hi);
    }


    public static void main(String[] args) {

        int[] a = {3, 1, 4, 5, 9, 2, 6, 8, 7};

        QuickSortMethod.sort(a, 0, a.length - 1);

        for (int t : a) {
            System.out.println(t + ",");
        }
    }
}
