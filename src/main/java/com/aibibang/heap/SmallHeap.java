package com.aibibang.heap;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/12 20:54
 * @description: 实现一个小顶堆、
 */
public class SmallHeap {
    private int[] datas;
    // 堆中的数量
    private int count;

    public SmallHeap(int size) {
        datas = new int[size + 1];
    }

    /**
     * 插入
     * 堆化从下往上
     *
     * @param data
     */
    public void insert(int data) {
        if (count > datas.length - 1) {
            return;
        }
        count++;
        datas[count] = data;
        int i = count;
        while (i / 2 > 0 && datas[i / 2] < datas[i]) {
            swap(datas, i / 2, i);
            i = i / 2;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 删除堆顶元素
     * 由上往下，将最后一个元素放置堆顶，然后继续堆化
     */
    public void removeMin() {
        if (count == 0) {
            return;
        }
        datas[1] = datas[count];
        --count;
        int i = 1;
        while ((2 * i <= count && datas[i] > datas[2 * i]) || ((2 * i + 1) <= count && datas[i] > datas[2 * i + 1])) {
            if (datas[i] < datas[2 * i]) {
                swap(datas, i, 2 * i);
                i = 2 * i;
            } else {
                swap(datas, i, 2 * i + 1);
                i = 2 * i + 1;
            }
        }

    }
}
