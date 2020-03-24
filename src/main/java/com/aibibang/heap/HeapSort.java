package com.aibibang.heap;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/12 22:53
 * @description: 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 * 将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 */
public class HeapSort {

    public int[] sort(int[] array) {
        int n = array.length;
        for (int i = n / 2; i >= 1; i--) {
            heapify(array, n, i);
        }
        int k = n;
        while (k > 1) {
            swap(array, 1, k);
            k--;
            heapify(array, k, 1);
        }

        return array;
    }


    public int[] heapify(int[] array, int n, int i) {
        int temp = i;
        while (true) {
            if (2 * i <= n && array[i] < array[2 * i]) {
                temp = 2 * i;
            } else if (2 * i + 1 <= n && array[i] < array[2 * i + 1]) {
                temp = 2 * i + 1;
            } else {
                break;
            }
            swap(array, i, temp);
            i = temp;
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
