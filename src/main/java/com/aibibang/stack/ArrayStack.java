package com.aibibang.stack;

/**
 * @author Truman.P.Du
 * @date 2020/02/23
 * @description 用数组实现一个顺序栈
 */
public class ArrayStack<E> {

    private Object[] array;
    private int size = 0;
    private int cursor = 0;

    public ArrayStack(int initialCapatity) {
        array = new Object[initialCapatity];
    }

    public void push(E element) throws Exception {
        if (size >= array.length) {
            throw new Exception("stack is full!");
        }
        array[cursor] = element;
        cursor++;
        size++;
    }

    public E pop() throws Exception {
        if (size == 0) {
            throw new Exception("stack has no element!");
        }
        E element = (E) array[--cursor];
        size--;
        return element;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        try {
            for (int i = 0; i <6 ; i++) {
                stack.push(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i <6 ; i++) {
                System.out.println(stack.pop());;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
