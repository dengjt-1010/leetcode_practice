package com.department.deng.排序算法;

/**
 * Created by deng on 19-4-15.
 * 基于快排  topK
 * <p>
 * https://www.cnblogs.com/sunshisonghit/p/4357551.html
 */
public class TopK {


    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && lo < hi) {
                hi--;
            }
            array[hi] = array[lo];

            while (array[lo] <= key && lo < hi) {
                lo++;
            }
            array[lo] = array[hi];
        }
        array[lo] = key;
        return lo;
    }

    public static void selectK(int[] array, int lo, int hi, int k) {
        if (lo >= hi) {
            return;
        }
        while (lo < hi) {
            int index = partition(array, lo, hi);
            if (index == k) {
                return;
            } else if (index < k) {
                lo = index + 1;
            } else {
                hi = index - 1;
            }

        }
    }

    public static void display(int a[], int k) {
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i] + " ");
        }
    }



    public static void main(String args[]) {
        int k = 5;
        int a[] = {0, 49, 38, 29, 65, 97, 76, 13, 27, 49, 22, 19};
        if (k > 0 && k <= a.length - 1) {
            selectK(a, 1, a.length - 1, k);
            display(a, k);
        } else {
            System.out.println("Are You Kidding Me?");
        }

    }
}
