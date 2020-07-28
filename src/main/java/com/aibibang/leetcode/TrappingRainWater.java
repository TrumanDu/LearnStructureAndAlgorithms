package com.aibibang.leetcode;

/**
 * @author: Truman.P.Du
 * @date: 2020/7/28 23:15
 * @description:
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 解题思路：计算每个位置的存水量=min(l_max[i],r_max[i])-height[i]
 * l_max[i],r_max[i]分别代表左右两侧在i位置的最大值。
 * 可以使用备忘录先对l_max[i],r_max[i]计算
 *
 * 还有一种更优算法，双指针，这里忽略
 * https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/jie-yu-shui
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int length = height.length;
        if(length<2){
            return 0;
        }
        int[]l_max = new int[length];
        int[]r_max = new int[length];

        l_max[0]=height[0];
        r_max[length-1]=height[length-1];
        //从左到右
        for(int i=1;i<length-1;i++){
            l_max[i]=max(l_max[i-1],height[i]);
        }
        //从右到左
        for(int i=length-2;i>=0;i--){
            r_max[i]=max(r_max[i+1],height[i]);
        }
        int size=0;
        for(int i=0;i<length-1;i++){
            size=size+(min(l_max[i],r_max[i])-height[i]);
        }
        return size;
    }

    public int max(int a,int b){
        return a>b?a:b;
    }

    public int min(int a,int b){
        return a<b?a:b;
    }
}
