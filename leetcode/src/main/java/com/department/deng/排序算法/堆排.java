package com.department.deng.排序算法;

/**
 * Created by deng on 19-4-22.
 */
public class 堆排 {
    public static int[] sort(int[] a, int low, int high) {

        int mid = (low + high) / 2;

        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, high, mid);
        }
        return a;
    }

    private static void merge(int[] a, int low, int high, int mid) {

        int[] temp = new int[high - low + 1];

        int index = 0;
        int first = low;
        int second = mid + 1;

        while (index < temp.length && (first <= mid || second <= high)) {
            if (first <= mid && second <= high) {
                if (a[first] < a[second]) {
                    temp[index++] = a[first++];
                } else {
                    temp[index++] = a[second++];
                }
            } else if (first <= mid) {
                temp[index++] = a[first++];
            } else if (second <= high) {
                temp[index++] = a[second++];
            }
        }
        for (int i = 0; i <= high - low; i++) {
            a[low + i] = temp[i];
        }
    }


    public static void main(String[] args) {

        int[] a = {3, 1, 4, 5, 9, 2, 6, 8, 7};
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
