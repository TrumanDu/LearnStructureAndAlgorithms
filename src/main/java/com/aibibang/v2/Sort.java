package com.aibibang.v2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: Truman.P.Du
 * @date: 2020/11/30 19:37
 * @description: 经典排序算法复习
 * 温故而知新
 */
public class Sort {

    /**
     * 冒泡排序
     * @param wait2SortArray
     * @return
     */
    public int[] bubbleSort(int[] wait2SortArray){
        for (int i = 0; i <wait2SortArray.length ; i++) {
            for (int j = 0; j < wait2SortArray.length-1-i; j++) {
                if(wait2SortArray[j]>wait2SortArray[j+1]){
                    swap(wait2SortArray,j,j+1);
                }
            }
        }
        return wait2SortArray;
    }

    /**
     * 选择排序
     * @param wait2SortArray
     * @return
     */
    public int[] selectionSort(int[] wait2SortArray){
        for (int i = 0; i < wait2SortArray.length-1; i++) {
            int min = i;
            for (int j = i+1; j < wait2SortArray.length; j++) {
                if(wait2SortArray[j]<wait2SortArray[min]){
                    min = j;
                }
            }
            if(min!=i){
                swap(wait2SortArray,i,min);
            }
        }
        return wait2SortArray;
    }

    /**
     * 归并排序
     * @param wait2SortArray
     * @return
     */
    public int[] mergeSort(int[] wait2SortArray){

        mergeSortS(wait2SortArray,0,wait2SortArray.length-1);
        return wait2SortArray;
    }


    public void mergeSortS(int[]array,int p,int q){
        if(p>=q){
            return;
        }
        int k = (p+q)/2;
        mergeSortS(array,p,k);
        mergeSortS(array,k+1,q);
        merge(array,p,k,q);
    }

    public void merge(int[] array,int p,int k,int q){
       int[]temp = new int[q-p+1];
       int pi=p;
       int qi=k+1;
       int i=0;
       while (pi<=k&&qi<=q){
           if(array[pi]<array[qi]){
               temp[i++] = array[pi++];
           }else {
               temp[i++] = array[qi++];
           }
       }

        while (pi<=k){
            temp[i++] = array[pi++];
        }

        while (qi<=q){
            temp[i++] = array[qi++];
        }
        System.arraycopy(temp,0,array,p,temp.length);
    }

    /**
     * 快速排序
     * @param wait2SortArray
     * @return
     */
    public int[] quickSort(int[] wait2SortArray){

        return wait2SortArray;
    }

    /**
     * 堆排序
     * @param wait2SortArray
     * @return
     */
    public int[] heapSort(int[] wait2SortArray){

        return wait2SortArray;
    }


    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println("=================bubbleSort=================");
        Arrays.stream(sort.bubbleSort(new Random().ints(1, 50).distinct().limit(10).toArray())).forEach(i->System.out.println(i));
        System.out.println("=================selectionSort=================");
        Arrays.stream(sort.selectionSort(new Random().ints(1, 50).distinct().limit(10).toArray())).forEach(i->System.out.println(i));
        System.out.println("=================mergeSort=================");
        Arrays.stream(sort.mergeSort(new Random().ints(1, 50).distinct().limit(10).toArray())).forEach(i->System.out.println(i));

    }
}
