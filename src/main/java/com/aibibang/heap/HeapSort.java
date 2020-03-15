package com.aibibang.heap;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/12 22:53
 * @description:
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
            if (2 * i <= n && array[temp] < array[2 * i]) {
                temp = 2 * i;
            } else if (2 * i + 1 <= n && array[temp] < array[2 * i + 1]) {
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
