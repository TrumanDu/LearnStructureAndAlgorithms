package com.aibibang.array;

/**
 * @author Truman.P.Du
 * @date 2020/02/20
 * @description 实现一个大小固定的有序数组(从小到大)，支持动态增删改操作
 */
public class SortedArray {

    private int[] array;
    public int length;
    private int count = 0;


    public SortedArray(int initialCapacity) {
        array = new int[initialCapacity];
        length = initialCapacity;
    }

    private void checkParam(int index) {
        if (count == 0 || index < 0 || index > count) {
            throw new IllegalArgumentException("index not exist!");
        }
    }

    public boolean add(int value) throws Exception {
        if (count >= length) {
            throw new Exception("array is full!");
        }
        if (count == 0 || value > array[count - 1]) {
            array[count] = value;
            count++;
            return true;
        }

        count++;
        for (int i = 0; i < count; i++) {
            if (array[i] > value) {
                for (int j = count; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = value;
                break;
            }
        }

        return true;
    }

    public int find(int index) {
        checkParam(index);
        return array[index];
    }

    public boolean del(int index) {
        checkParam(index);
        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }
        count--;
        return false;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(find(i));
        }
    }

    public static void main(String[] args) throws Exception {
        SortedArray sortedArray = new SortedArray(10);
        sortedArray.add(9);
        sortedArray.add(10);
        sortedArray.add(4);
        sortedArray.add(6);
        sortedArray.add(5);
        sortedArray.add(3);

        sortedArray.printAll();
        System.out.println("--------------------");
        sortedArray.del(0);
        //sortedArray.del(10);
        sortedArray.del(4);

        sortedArray.printAll();
    }


}
