package com.aibibang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Truman.P.Du
 * @date: 2020/8/3 20:45
 * @description:
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        if(pattern.length()!=array.length){
            return false;
        }
        Map<String,String> map =new HashMap<>();
        Set<String> keys = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            String s = pattern.substring(i,i+1);
            if(map.containsKey(s)){
                if(!array[i].equals(map.get(s))){
                    return false;
                }
            }else{
                if(keys.contains(array[i])){
                    return false;
                }
                map.put(s,array[i]);
                keys.add(array[i]);
            }
        }

        return true;
    }
}
