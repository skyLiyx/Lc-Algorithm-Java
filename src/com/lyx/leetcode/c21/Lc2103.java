package com.lyx.leetcode.c21;

/**
 * 2103.环和杆
 *
 * @version 2023/11/02
 */
public class Lc2103 {
    public int countPoints(String rings) {
        int[][] set = new int[10][3];
        int ans = 0;
        for (int i = 0; i < rings.length(); i+=2) {
            char color = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';
            if (set[index][0] == 1 && set[index][1] == 1 && set[index][2] == 1) {
                continue;
            }
            setColor(set, index, color);
            if (set[index][0] == 1 && set[index][1] == 1 && set[index][2] == 1) {
                ans++;
            }
        }
        return ans;
    }

    private void setColor(int[][] set, int index, char color) {
        if (color == 'R') {
            set[index][0] = 1;
        } else if (color == 'G') {
            set[index][1] = 1;
        } else {
            set[index][2] = 1;
        }
    }
}
