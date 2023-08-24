package com.lyx.leetcode;

/**
 * 2337.移动片段得到字符串
 *
 * 思路：双指针
 * 时间复杂度：O(N)
 *
 * @version 2023/08/22
 */
public class Lc2337 {
    public boolean canChange(String start, String target) {
        int l = start.length();
        // start起始指针，从0到l逐一递增
        int ps = 0;
        for (int pt = 0; pt < l; pt++) {
            char c = target.charAt(pt);
            if (c == '_') {
                continue;
            }
            if (c == 'L') {
                // 为L时，起始指针到当前位置区间内必须全是'_'
                // 同时调整起始指针到当前位置
                while (ps < pt) {
                    if (start.charAt(ps++) != '_') {
                        return false;
                    }
                }
                // 当前位置右边第一个非'_'字符必定是L
                while (ps <= l) {
                    // 指针越界或L找到之前存在R，直接返回false
                    if (ps == l || start.charAt(ps) == 'R') {
                        return false;
                    }
                    if (start.charAt(ps) == 'L') {
                        break;
                    }
                    ps += 1;
                }
            }
            if (c == 'R') {
                // 如果当前'R'位置在起始指针左边，直接返回false
                if (pt < ps) {
                    return false;
                }
                // 在起始指针到当前位置区间内至少有一个'R'
                // 且'R'找到之前不能有'L'
                while (ps <= pt) {
                    if (start.charAt(ps) == 'R') {
                        break;
                    } else if (start.charAt(ps) == 'L') {
                        return false;
                    } else if (ps == pt) {
                        // 区间内全是'_'
                        return false;
                    }
                    ps += 1;
                }
            }
            // 更新起始指针为已遍历位置的下一个
            ps += 1;
        }
        // 当target遍历完了之后起始指针ps还没到终点
        // 即start还没遍历完，那么剩余区间必须全为'_'
        while (ps < l) {
            if (start.charAt(ps++) != '_') {
                return false;
            }
        }
        return true;
    }
}
