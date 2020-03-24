package com.aibibang.algorithms;

/**
 * @author Truman.P.Du
 * @date 2020/02/26
 * @description
 */
public class Sort {
    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public int[] insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public int[] mergeSort(int[] array) {
        array = mergetA(array, 0, array.length - 1);
        return array;
    }

    public int[] mergetA(int[] array, int p, int r) {
        if (p >= r) {
            return new int[]{array[r]};
        }

        int q = (p + r) / 2;

        int[] array1 = mergetA(array, p, q);
        int[] array2 = mergetA(array, q + 1, r);
        int[] result = merget(array1, array2);
        return result;
    }

    public int[] merget(int[] a, int[] b) {
        int j = 0;
        int k = 0;
        int[] array = new int[a.length + b.length];
        for (int i = 0; i < array.length; i++) {
            if (j >= a.length) {
                array[i] = b[k];
                k++;
                continue;
            } else if (k >= b.length) {
                array[i] = a[j];
                j++;
                continue;
            } else {
                if (a[j] < b[k]) {
                    array[i] = a[j];
                    j++;
                } else {
                    array[i] = b[k];
                    k++;
                }
            }
        }
        return array;
    }

    /**
     * 快速排序
     *
     * @param array
     * @return
     */
    public int[] quickSort(int[] array) {
        quick(array, 0, array.length - 1);
        return array;
    }

    public void quick(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(array, p, r);
        quick(array, p, q - 1);
        quick(array, q + 1, r);
    }

    public int partition(int[] array, int p, int r) {

        int i = p;
        for (int j = p; j < r; j++) {
            if (array[j] < array[r]) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, r);
        return i;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 编程实现O(n)时间复杂度内找到一组数据的第K大元素
     * @param array
     * @param k
     * @return
     */
    public int findK(int[] array, int k) {
        return find(array, 0, array.length - 1, k-1);
    }

    public int find(int[] array, int p, int r, int k) {

        int q = partition(array, p, r);

        if (k == q) {
            return array[k];
        } else if (k > p) {
            return find(array, q + 1, r, k);
        } else {
            return find(array, p, q - 1, k);
        }
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = {2, 10, 5, 6, 3, 8, 1};
        //int[] result = sort.bubbleSort(array);
        //int[] result = sort.selectionSort(array);
        //int[] result = sort.insertSort(array);
        //int[] result = sort.mergeSort(array);
        int[] result = sort.quickSort(array);
        for (int i : result) {
            System.out.println(i);
        }

        System.out.println(sort.findK(array,7));
        System.out.println(sort.findK(array,1));

    }
}
