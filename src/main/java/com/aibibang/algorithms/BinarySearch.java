package com.aibibang.algorithms;

/**
 * @author Truman.P.Du
 * @date 2020/02/26
 * @description
 */
public class BinarySearch {

    /**
     * 实现一个有序数组的二分查找算法
     *
     * @param array
     * @param n
     * @return
     */
    public int binarySearch(int[] array, int n) {
        return search(array, 0, array.length - 1, n);
    }

    public int search(int[] array, int low, int hight, int n) {
        if (low > hight) {
            return -1;
        }
        int middle = (low + hight) / 2;
        if (array[middle] == n) {
            return middle;
        } else if (array[middle] > n) {
            return search(array, low, middle - 1, n);
        } else {
            return search(array, middle + 1, hight, n);
        }
    }

    /**
     * 实现模糊二分查找算法（比如大于等于给定值的第一个元素）
     *
     * @param array
     * @param n
     * @return
     */
    public int firstDataByBinarySearch(int[] array, int n) {
        return firstSearch(array, 0, array.length-1, n);
    }

    public int firstSearch(int[] array, int low, int hight, int n) {
        if (low > hight) {
            return -1;
        }
        int middle = (low + hight) / 2;
        if (array[middle] >= n) {
            if(middle==0||array[middle-1]<n){
                return middle;
            }else {
                return firstSearch(array, low, middle - 1, n);
            }

        } else {
            return firstSearch(array, middle + 1, hight, n);
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {2,2, 4, 6, 8, 10, 23, 50};
        System.out.println(binarySearch.binarySearch(array, 23));
        System.out.println(binarySearch.binarySearch(array, 2));
        System.out.println(binarySearch.binarySearch(array, 50));
        System.out.println(binarySearch.binarySearch(array, 1));
        System.out.println(binarySearch.firstDataByBinarySearch(array, 3));
    }


}
