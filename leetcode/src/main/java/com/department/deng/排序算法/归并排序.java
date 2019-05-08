package com.department.deng.排序算法;

/**
 * Created by deng on 19-4-22.
 */
public class 归并排序 {

    private static void sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, high, mid);
        }
    }

    private static void merge(int[] a, int low, int high, int mid) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;
        while (left <= mid || right <= high) {
            if (left <= mid && right <= high) {
                if (a[left] < a[right]) {
                    temp[index++] = a[left++];
                } else {
                    temp[index++] = a[right++];
                }
            } else if (left <= mid) {
                temp[index++] = a[left++];
            } else {
                temp[index++] = a[right++];
            }
        }

        for (int i = low; i <= high; i++) {
            a[i] = temp[i - low];
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
