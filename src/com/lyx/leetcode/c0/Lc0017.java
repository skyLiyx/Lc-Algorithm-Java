package com.lyx.leetcode.c0;

import java.util.*;

/**
 * 17.电话号码的字母之和
 *
 * 思路：枚举+递归
 *
 * @version 2023/09/01
 */
public class Lc0017 {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> digitCharactersMap = new HashMap<>();
        digitCharactersMap.put('2', new char[]{'a', 'b', 'c'});
        digitCharactersMap.put('3', new char[]{'d', 'e', 'f'});
        digitCharactersMap.put('4', new char[]{'g', 'h', 'i'});
        digitCharactersMap.put('5', new char[]{'j', 'k', 'l'});
        digitCharactersMap.put('6', new char[]{'m', 'n', 'o'});
        digitCharactersMap.put('7', new char[]{'p', 'q', 'r', 's'});
        digitCharactersMap.put('8', new char[]{'t', 'u', 'v'});
        digitCharactersMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> resList = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            combine(resList, digitCharactersMap.get(c));
        }
        return resList;
    }

    private void combine(List<String> list, char[] chars) {
        if (list.isEmpty()) {
            for (char c : chars) {
                list.add(String.valueOf(c));
            }
            return;
        }
        List<String> tmp = new ArrayList<>();
        for (String s : list) {
            for (char c : chars) {
                tmp.add(s + c);
            }
        }
        list.clear();
        list.addAll(tmp);
    }
}
