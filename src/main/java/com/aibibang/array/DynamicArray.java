package com.aibibang.array;

/**
 * @author Truman.P.Du
 * @date 2019/08/16
 * @description 实现一个支持动态扩容的数组
 */
public class DynamicArray<E> {
    private Object[] array;
    private int cursor = 0;

    public DynamicArray() {
        array = new Object[10];
    }

    public DynamicArray(int initialCapacity) {
        array = new Object[initialCapacity];
    }


    public boolean add(E element) {
        if (cursor > array.length - 1) {
            //数组扩容
            growArray();
        }
        array[cursor] = element;
        cursor++;

        return true;
    }

    public void set(int index, E element) {
        if (index > array.length - 1) {
            //数组扩容
            growArray();
        }
    }

    public E get(int index) {
        if (index > array.length-1) {
            throw new IllegalArgumentException("指定index的数据不存在");
        }
        return array[index] == null ? null : (E) array[index];
    }

    public void remove(int index) {
        if (index < array.length-1) {
            array[index] = null;
        }
    }


    public int size() {
        return cursor;
    }

    /**
     * 每次扩容oldLength/2
     */
    private void growArray() {
        int oldLength = array.length;
        int newCapacity = oldLength + (oldLength >> 1);
        Object[] tempArray = new Object[newCapacity];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        array = tempArray;
    }


    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<>();
        for (int i = 0; i < 100; i++) {
            array.add(i + "");
        }
        System.out.println(array.size());
        for (int i = 0; i < 100; i++) {
            System.out.println(array.get(i));
        }
    }

}
