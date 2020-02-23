package com.aibibang.queue;

/**
 * @author Truman.P.Du
 * @date 2020/02/23
 * @description 实现一个循环队列
 */
public class CircularQueue<E> {
    private Object[] array;
    private int size;
    private int head;
    private int tail;

    public CircularQueue(int initialCapatity) {
        array = new Object[initialCapatity];
    }

    public boolean add(E element) throws Exception {
        if (size == array.length) {
            throw new Exception("queue is full.");
        }
        int index = tail % array.length;
        array[index] = element;
        size++;
        tail++;
        return true;
    }

    public E poll() throws Exception {
        if (size == 0) {
            throw new Exception("queue is empty.");
        }
        int index = head % array.length;
        E result = (E) array[index];
        head++;
        size--;
        return result;
    }


    public static void main(String[] args) throws Exception {

        CircularQueue circularQueue = new CircularQueue(5);

        /*try {
            for (int i = 0; i < 10; i++) {
                circularQueue.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(circularQueue.poll());
        }*/


        try {
            for (int i = 0; i < 100; i++) {
                circularQueue.add(i);
                System.out.println(circularQueue.poll());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
