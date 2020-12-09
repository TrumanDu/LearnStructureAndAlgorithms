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
         quick(wait2SortArray,0,wait2SortArray.length-1);
        return wait2SortArray;
    }

    public void quick(int[] array,int p,int q){
        if(p>=q){
            return;
        }
        int partition = partition(array,p,q);
        quick(array,p,partition-1);
        quick(array,partition+1,q);
    }


    public int partition(int[] array,int p,int q){

        int i = p;

        for (int j = p; j < q; j++) {
            if(array[j]<array[q]){
                swap(array,i,j);
                i++;
            }
        }
        swap(array,i,q);
        return i;
    }

    /**
     * 堆排序
     * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
     * 从最后一个非叶子节点开始n/2-1（如果堆数组是从下标1开始则为n/2）
     * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
     *
     * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
     *
     * 因为下表是从0开始，i 左子节点2*i+1 右子节点2*i+2
     *
     * @param wait2SortArray
     * @return
     */
    public int[] heapSort(int[] wait2SortArray){
        int n = wait2SortArray.length;
        for (int i = n/2-1; i >=0; i--) {
               heapfiy(wait2SortArray,n,i);
        }
        while (n>0){
            n--;
            swap(wait2SortArray,0,n);
            heapfiy(wait2SortArray,n,0);
        }
        return wait2SortArray;
    }

    private void heapfiy(int[] array,int n,int i){
           while (true){
               int max = i;
               if((2*i+1)<n&&array[2*i+1]>array[i]){
                   max = 2*i+1;
               }

               if((2*i+2)<n&&array[2*i+2]>array[i]){
                   max = 2*i+2;
               }

               if(max ==i){
                   break;
               }
               swap(array,i,max);
           }
    }


    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println("=================bubbleSort=================");
        System.out.println(Arrays.toString(sort.bubbleSort(new Random().ints(1, 50).distinct().limit(10).toArray())));
        System.out.println("=================selectionSort=================");
        System.out.println(Arrays.toString(sort.selectionSort(new Random().ints(1, 50).distinct().limit(10).toArray())));
        System.out.println("=================mergeSort=================");
        int[] array = new Random().ints(1, 50).distinct().limit(10).toArray();
        System.out.println(Arrays.toString(sort.mergeSort(array)));
        System.out.println("=================quickSort=================");
        System.out.println(Arrays.toString(sort.quickSort(new Random().ints(1, 50).distinct().limit(10).toArray())));
        System.out.println("=================heapSort=================");
        System.out.println(Arrays.toString(sort.heapSort(new Random().ints(1, 50).distinct().limit(10).toArray())));
    }
}
