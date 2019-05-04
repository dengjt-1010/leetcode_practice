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
            array[lo] = array[hi];

            while (array[lo] <= key && lo < hi) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[lo] = key;
        return lo;
    }

    private static void selectK(int a[], int left, int right, int k) {

        if (left >= right) {
            return;
        }

        int choose = partition(a, left, right);

        if (choose < k) {
            selectK(a, choose + 1, right, k);
        } else if (choose > k) {
            selectK(a, left, choose - 1, k);
        }
    }

    public static void display(int a[], int k) {
        for (int i = 0; i <= k - 1; i++) {
            System.out.print(a[i] + " ");
        }
    }



    public static void main(String args[]) {
        int k = 5;
        int a[] = {49, 38, 29, 65, 97, 76, 13, 27, 49, 22, 19};
        if (k >= 0 && k <= a.length - 1) {
            selectK(a, 1, a.length - 1, k);
            display(a, k);
        } else {
            System.out.println("Are You Kidding Me?");
        }

    }
}
