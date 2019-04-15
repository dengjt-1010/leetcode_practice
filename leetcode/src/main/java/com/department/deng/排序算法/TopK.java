package com.department.deng.排序算法;

/**
 * Created by deng on 19-4-15.
 * 基于快排  topK
 * <p>
 * https://www.cnblogs.com/sunshisonghit/p/4357551.html
 */
public class TopK {
    public static int Partition(int a[], int low, int high) {
        a[0] = a[low];
        int pivokey = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivokey) --high;
            a[low] = a[high];
            while (low < high && a[low] <= pivokey) ++low;
            a[high] = a[low];
        }
        a[low] = a[0];
        return low;
    }

    public static void display(int a[], int k) {
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 相比于快排，提前终止了递归。
     */
    public static int selectK(int a[], int start, int end, int k) {
        int index = 0;
        if (start < end) {
            index = Partition(a, start, end);
            if (index == k)//正好找到第k大的数
            {
                index = k;
            } else if (index < k) {

                /**
                 * //还要从index的右边找k-index个数?????我觉得应该是k呢？？？？？
                 */
                index = selectK(a, index + 1, end, k);
            } else if (index > k)//k个数都在Index的左边
            {
                index = selectK(a, start, index - 1, k);
            }
        }
        return index;

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
