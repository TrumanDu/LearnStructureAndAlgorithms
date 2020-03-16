package com.aibibang.backtrack;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/16 19:15
 * @description: 利用回溯算法求解八皇后问题
 */
public class Queen {
    int[] array = new int[8];

    public void cal8Queen(int row) {
        if (row == 8) {
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (isOk(row, i)) {
                array[row] = i;
                cal8Queen(row + 1);
            }
        }
    }

    public boolean isOk(int row, int i) {

        int left = --i;
        int right = ++i;

        for (int j = row - 1; j >= 0; j--) {
            if (array[j] == i) {
                return false;
            }

            if (left >= 0) {
                if (array[j] == left) {
                    return false;
                }
            }

            if (right < 8) {
                if (array[j] == right) {
                    return false;
                }
            }
            --left;
            ++right;
        }

        return true;
    }
}
