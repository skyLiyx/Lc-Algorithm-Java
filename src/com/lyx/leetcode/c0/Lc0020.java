package com.lyx.leetcode.c0;

import java.util.*;

/**
 * 20.有效的括号
 *
 * 思路：栈
 *
 * @version 2023/09/01
 */
public class Lc0020 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(c) != stack.peek()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
