package com.aibibang.backtrack;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/16 19:00
 * @description: 利用回溯算法求解0-1背包问题
 */
public class Package01 {
    int maxResult = 0;

    public void find(int[] array, int n, int w) {
        f(array, 0, 0, n, w);
    }

    public void f(int[] array, int i, int cw, int n, int w) {
        if (i == n || cw > w) {
            if (cw > maxResult) {
                maxResult = cw;
            }
            return;
        }
        //表示不选择当前物品，直接考虑下一个（第 i+1 个），故 cw 不更新
        f(array, i + 1, cw, n, w);
        //调用表示选择了当前物品，故考虑下一个时，cw 通过入参更新为 cw + items[i]
        if (cw + array[i] <= w) {
            f(array, i + 1, array[i] + cw, n, w);
        }
    }
}
