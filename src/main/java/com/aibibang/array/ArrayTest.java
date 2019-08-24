package com.aibibang.array;

/**
 * @author Truman.P.Du
 * @date 2019/08/24
 * @description 两个有序数组的合并
 */
public class ArrayTest {
    /**
     * 两个有序数组的合并
     * 使用插入法
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] merge(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        for (int i = array1.length; i < result.length; i++) {
            for (int j = i; j > 0 && result[j - 1] > result[j]; j--) {
                //交换
                int temp = result[j - 1];
                result[j - 1] = result[j];
                result[j] = temp;
            }
        }

        return result;

    }


    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};
        int[] result = arrayTest.merge(array1, array2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
