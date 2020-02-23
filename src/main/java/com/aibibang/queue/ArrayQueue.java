package com.aibibang.queue;

/**
 * @author Truman.P.Du
 * @date 2020/02/23
 * @description 用数组实现一个顺序队列
 */
public class ArrayQueue<E> {
    private Object[] array;
    private int size;
    private int tail;
    private int head;

    public ArrayQueue(int initialCapatity) {
        array = new Object[initialCapatity];
    }

    public boolean add(E element) throws Exception {
        if (size == array.length) {
            throw new Exception("queue is full.");
        }
        if (tail >= array.length) {
            //移动数据
            Object[] temp = new Object[array.length];
            System.arraycopy(array, head, temp, 0, size);
            array = temp;
            head = 0;
            tail = size;
        }
        array[tail] = element;
        size++;
        tail++;
        return true;
    }

    public E poll() throws Exception {
        if (size == 0) {
            throw new Exception("queue is empty.");
        }
        E result = (E) array[head];
        head++;
        size--;
        return result;
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(5);

        try {
            for (int i = 0; i < 6; i++) {
                arrayQueue.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayQueue.poll());
        }


        try {
            for (int i = 0; i < 50; i++) {
                arrayQueue.add(i);
                System.out.println(arrayQueue.poll());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
