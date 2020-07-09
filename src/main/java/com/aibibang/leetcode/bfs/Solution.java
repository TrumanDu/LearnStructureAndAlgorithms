package com.aibibang.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author: Truman.P.Du
 * @date: 2020/7/9 22:12
 * @description: 打开转盘锁
 * https://leetcode-cn.com/problems/open-the-lock/
 * 解题思路：bfs模板+求一步所有可能性方法
 */
public class Solution {
    public int openLock(String[] deadends, String target) {

        int step = 0;
        Set<String> deadendsSet = new HashSet<String>();
        for (String str : deadends) {
            deadendsSet.add(str);
        }

        Queue<String> queue = new ArrayDeque<String>();
        Set<String> set = new HashSet<String>();
        queue.add("0000");
        set.add("0000");
        while (queue.size() != 0) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.remove();
                if (deadendsSet.contains(str)) {
                    continue;
                }
                if (str.equals(target)) {
                    return step;
                }

                for (int i = 0; i < 4; i++) {
                    String[] result = getString(str, i);
                    for (String ss : result) {
                        if (!set.contains(ss)) {
                            queue.add(ss);
                            set.add(ss);
                        }
                    }
                }
            }


            step++;
        }
        return -1;
    }

    public String plus(String str, int index) {
        char[] ch = str.toCharArray();
        if (ch[index] == '9') {
            ch[index] = '0';
        } else {
            ch[index] += 1;
        }
        return new String(ch);
    }

    public String minute(String str, int index) {
        char[] ch = str.toCharArray();
        if (ch[index] == '0') {
            ch[index] = '9';
        } else {
            ch[index] -= 1;
        }
        return new String(ch);
    }

    public String[] getString(String str, int index) {

        String[] result = new String[2];

        result[0] = plus(str, index);
        result[1] = minute(str, index);

        return result;

    }
}
