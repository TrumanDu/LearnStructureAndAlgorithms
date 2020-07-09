package com.aibibang.leetcode.primes;

import java.util.Arrays;

/**
 * @author: Truman.P.Du
 * @date: 2020/7/9 22:10
 * @description:
 * 统计所有小于非负整数 n 的质数的数量。
 * 解题思路：排除法，是素数，它的倍数一定不是素数。
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] array = new boolean[n];
        Arrays.fill(array,true);
        for(int i=2;i*i<n;i++){
            if(array[i]){
                for(int j=2*i;j<n;j=j+i){
                    array[j] = false;
                }
            }
        }
        int count=0;
        for(int k=2;k<n;k++){
            if(array[k]){
                count++;
            }
        }
        return count;
    }
}
