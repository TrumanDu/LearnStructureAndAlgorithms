package com.aibibang.heap;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/12 21:06
 * @description: 优先级队列
 */
public class PriorityQueue {
    private int[] array;
    private int count;

    public PriorityQueue(int initialCapacity) {
        array = new int[initialCapacity + 1];
    }

    public void enqueue(int data) {
        if (count > array.length - 1) {
            return;
        }
        count++;
        array[count] = data;
        int i = count;
        while (i / 2 > 0 && array[i / 2] < array[i]) {
            swap(array, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int dequeue() {

        if (count == 0) {
            return -1;
        }

        int result = array[1];

        array[1] = array[count];
        count--;
        int i = 1;
        while ((2 * i <= count && array[2 * i] > array[i]) || (2 * i + 1 <= count && array[2 * i + 1] > array[i])) {
            if (array[2 * i] > array[i]) {
                swap(array, i, 2 * i);
                i = 2 * i;
            } else {
                swap(array, i, 2 * i + 1);
                i = 2 * i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(1);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(2);

        while (priorityQueue.count> 0) {
            System.out.println(priorityQueue.dequeue());
        }
    }
}
