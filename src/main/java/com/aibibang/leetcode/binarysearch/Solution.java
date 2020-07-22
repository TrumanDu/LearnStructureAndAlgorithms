package com.aibibang.leetcode.binarysearch;

/**
 * @author: Truman.P.Du
 * @date: 2020/7/22 22:01
 * @description:
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 * 先写好算法思路（没有思路的时候暴力解法），保留方法名，然后挨个实现
 * 利用左侧二分查找法提高速度。
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int length = getMax(piles);
        int max = length;
        while(low<=max){
            int mid = low+(max-low)/2;
            if(canFinsh(piles,mid,H)){
                max=mid-1;
            }else{
                low = mid+1;
            }
        }

        if(low>length||!canFinsh(piles,low,H)){
            return -1;
        }

        return low;
        // for(int k=1;k<max+1;k++){
        //    if(canFinsh(piles,k,H)){
        //       return k;
        //   }
        //}

        //return -1;
    }

    public int getMax(int[] piles){
        int temp= 0;
        for(int pile:piles){
            if(pile>temp){
                temp = pile;
            }
        }

        return temp;
    }

    public boolean canFinsh(int[] piles,int k,int H){
        int times=0;
        for(int pile:piles){
            times = times+timeOf(pile,k);
            if(times>H){
                return false;
            }
        }

        if(times>H){
            return false;
        }else{
            return true;
        }
    }

    public int timeOf(int pile,int k){
        return (pile/k+(pile%k>0?1:0));
    }
}
