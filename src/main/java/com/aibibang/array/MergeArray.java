package com.aibibang.array;

/**
 * @author Truman.P.Du
 * @date 2020/02/20
 * @description 实现两个有序数组合并为一个有序数组
 * 实现该算法有多个思路
 * 1：遍历新数据组，从另外两个数组依次获取最小的值，放到新数组里，然后移动下标，继续，直至把新数组填满
 */
public class MergeArray {

    public int[] mergeSortedArray(int[] s1, int[] s2) {
        if (s1.length == 0 || s2.length == 0) {
            return s1.length == 0 ? s2 : s1;
        }
        int[] newArray = new int[s1.length + s2.length];
        int s1_index = 0;
        int s2_index = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (s1_index >= s1.length) {
                newArray[i] = s2[s2_index];
                s2_index++;
            } else if (s2_index >= s2.length) {
                newArray[i] = s1[s1_index];
                s1_index++;
            } else {
                if (s1[s1_index] < s2[s2_index]) {
                    newArray[i] = s1[s1_index];
                    s1_index++;
                } else {
                    newArray[i] = s2[s2_index];
                    s2_index++;
                }
            }
        }
        return newArray;
    }

    public static void main(String[] args) throws Exception {
        int[] s1 = {1, 2, 6, 9};
        int[] s2 = {2, 3, 4, 5, 6, 7, 8, 9};

        MergeArray mergeArray = new MergeArray();
        int[] s3 = mergeArray.mergeSortedArray(s1, s2);
        for (int i = 0; i < s3.length; i++) {
            System.out.println(s3[i]);
        }
    }
}
