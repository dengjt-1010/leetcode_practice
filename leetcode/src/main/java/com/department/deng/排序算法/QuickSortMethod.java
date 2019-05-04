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


    private static int partition(int[] request, int start, int end) {

        int key = request[start];

        while (start < end) {

            while (key < request[end] && start < end) {
                end--;
            }
            request[start] = request[end];
            while (key > request[start] && start < end) {
                start++;
            }
            request[end] = request[start];
        }

        request[start] = key;
        return start;
    }

    private static void sort(int[] request, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = partition(request, start, end);
        sort(request, start, mid - 1);
        sort(request, mid + 1, end);

    }


    public static void main(String[] args) {

        int[] a = {3, 1, 4, 5, 9, 2, 6, 8, 7};

        QuickSortMethod.sort(a, 0, a.length - 1);

        for (int t : a) {
            System.out.println(t + ",");
        }
    }
}
