package com.aibibang.leetcode;

import java.util.*;

/**
 * @author Truman.P.Du
 * @date 2021/8/7 22:49
 * @description
 */
public class Test {
    public int[] twoSum(int[] nums, int target) {
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            String key = String.valueOf(nums[i]);
            map.put(key,i+"");
        }

        ArrayDeque<String> queue = new ArrayDeque<String>();

        String[] a = (String[]) queue.toArray();

        for(int i=0;i<nums.length;i++){
            String key = String.valueOf(target - nums[i]);
            if(map.containsKey(key)){
                return new int[]{i,Integer.parseInt(map.get(key))};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Test test = new Test();

        Arrays.stream(test.twoSum(new int[]{3, 2, 4}, 6)).forEach(i->{
            System.out.println(i);
        });
    }
}
