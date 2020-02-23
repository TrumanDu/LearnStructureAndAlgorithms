package com.aibibang.array;

/**
 * @author Truman.P.Du
 * @date 2020/02/20
 * @description 实现一个支持动态扩容的数组
 */
public class DynamicArray<E> {
    private Object[] array;
    public int length;
    private int cursor;

    public DynamicArray(int initialCapacity) {
        array = new Object[initialCapacity];
        length = initialCapacity;
        cursor = 0;
    }

    public void add(E element) {
        if (cursor >= length) {
            growCapacity();
        }
        array[cursor] = element;
        cursor++;
    }

    public E get(int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("index not exist!");
        }
        return (E) array[index];
    }

    public void put(int index, E element) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("index not exist!");
        }
        array[index] = element;
    }

    /**
     * 将数组扩容增加1/2
     */
    private void growCapacity() {
        int newCapacity = length + length / 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, length);
        array = newArray;
        length = newCapacity;
    }


    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(10);

        for (int i = 0; i < 16; i++) {
            dynamicArray.add(i);
        }

        for (int i = 0; i < 16; i++) {
            System.out.println("index:  " + i + " value:  " + dynamicArray.get(i));
        }
    }

}
