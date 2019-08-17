package com.aibibang.array;

/**
 * @author Truman.P.Du
 * @date 2019/08/16
 * @description 实现一个大小固定的有序数组，支持动态增删改操作
 */
public class SortedArray<E> {
    Object[] array;
    private int size = 0;

    public SortedArray(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    public boolean add(E element) {
        if (size > array.length - 1) {
            remove(0);
        }
        array[size] = element;
        size++;
        return true;
    }

    public boolean set(int index, E element) {
        if (index > array.length - 1) {
            return false;
        }
        array[index] = element;

        return true;
    }

    public E get(int index) {
        if (index > array.length - 1) {
            throw new IllegalArgumentException("数组越界！");
        }
        return array[index] == null ? null : (E) array[index];
    }

    public boolean remove(int index) {
        if (index > array.length - 1) {
            return false;
        }
        //移动数据
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        size--;
        return true;
    }



    public static void main(String[] args) {
        SortedArray<Integer> array = new SortedArray<>(10);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000_000; i++) {
            array.add(i);
        }
        System.out.println("costs :" + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < 10; i++) {
            System.out.println(array.get(i));
        }
    }
}
