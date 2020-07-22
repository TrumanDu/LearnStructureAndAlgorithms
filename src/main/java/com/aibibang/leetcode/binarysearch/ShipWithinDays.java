package com.aibibang.leetcode.binarysearch;

/**
 * @author: Truman.P.Du
 * @date: 2020/7/22 22:42
 * @description: https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * 本质上和吃香蕉一个类型题，这个题要注意的如何写出canFinish方法
 * canFinish方法：两个注意点，一个是天数判断，一个是是否超过船的运输能力
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int low=1;
        int max = getMax(weights);
        //这里可用二分查找提速
        for(int k=1;k<max+1;k++){
            if(canFinsh(weights,k,D)){
                return k;
            }
        }

        return -1;
    }

    public int getMax(int[] weights){
        int max=0;
        for(int weight:weights){
            max=max+weight;
        }
        return max;

    }

    public boolean canFinsh(int[] weights,int k, int D){
        int day=0;
        int ship=0;
        for(int weight:weights){
            if(weight>k){//此处注意
                return false;
            }
            if(day>D){
                return false;
            }
            if((weight+ship)>k){
                ship=weight;
                day=day+1;
            }else{
                ship = ship+weight;
            }
        }
        day=day+1;//此处注意

        if(day>D){
            return false;
        }else{
            return true;
        }

    }
}
