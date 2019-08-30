package com.aibibang.stack;

/**
 * @author Truman.P.Du
 * @date 2019/08/29
 * @description 用数组实现一个顺序栈
 */
public class ArrayStack<E> {
    Object[] array;
    private int size = 0;

    public ArrayStack(int initialCapaticy) {
        array = new Object[initialCapaticy];
    }

    public void push(E element) throws Exception {
        if (size >= array.length) {
            throw new Exception("栈已满");
        }
        array[size++] = element;
    }

    public E pop() throws Exception {
        if (size <= 0) {
            throw new Exception("栈内无数据");
        }
        E element = (E) array[--size];
        return element;
    }
}
