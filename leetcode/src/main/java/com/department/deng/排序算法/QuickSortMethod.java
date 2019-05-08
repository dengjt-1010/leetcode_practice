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

    private static int partition(int a[], int low, int high) {

        int key = a[low];
        while (low < high) {
            while (a[high] > key && low < high) {
                high--;
            }
            a[low] = a[high];

            while (a[low] < key && low < high) {
                low++;
            }
            a[high] = a[low];
        }

        a[low] = key;
        return low;
    }

    private static void sort(int a[], int low, int high) {
        if (low < high) {
            int part = partition(a, low, high);
            sort(a, low, part - 1);
            sort(a, part + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] a = {3, 1, 4, 5, 9, 2, 6, 8, 7};

        QuickSortMethod.sort(a, 0, a.length - 1);

        for (int t : a) {
            System.out.println(t + ",");
        }
    }
}
