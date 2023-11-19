package com.lyx.leetcode.c21;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2127.参加会议的最多员工数
 *
 * @version 2023/11/01
 */
public class Lc2127 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] in = new int[n];
        int[] f = new int[n];
        boolean[] used = new boolean[n];
        for (int next : favorite) {
            in[next]++;
        }
        Arrays.fill(f, 1);
        Queue<Integer> zeroNode = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                zeroNode.add(i);
            }
        }
        while (!zeroNode.isEmpty()) {
            int cur = zeroNode.poll();
            used[cur] = true;
            int next = favorite[cur];
            f[next] = Math.max(f[next], f[cur] + 1);
            in[next]--;
            if (in[next] == 0) {
                zeroNode.add(next);
            }
        }
        int ring = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                int next = favorite[i];
                if (favorite[next] == i) {
                    used[i] = used[next] = true;
                    total += f[i] + f[next];
                } else {
                    int curNode = i;
                    int curRing = 0;
                    do {
                        curRing++;
                        used[curNode] = true;
                        curNode = favorite[curNode];
                    } while (curNode != i);
                    ring = Math.max(ring, curRing);
                }
            }
        }
        return Math.max(ring, total);
    }
}
