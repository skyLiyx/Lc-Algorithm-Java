package com.lyx.leetcode;

/**
 * 12.整数转罗马数字
 *
 * 思路：从高位到低位逐一转换
 */
public class Lc0012 {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman_0(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                roman.append(symbol);
                num -= value;
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public String intToRoman_1(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        if (num >= 1000) {
            while (num >= 1000) {
                res.append("M");
                num -= 1000;
            }
            return res.toString() + intToRoman_1(num);
        } else if (num >= 100) {
            if (num >= 900) {
                return "CM" + intToRoman_1(num % 100);
            } else if (num >= 500) {
                return "D" + intToRoman_1(num - 500);
            } else if (num >= 400) {
                return "CD" + intToRoman_1(num % 100);
            } else {
                while (num >= 100) {
                    res.append("C");
                    num -= 100;
                }
                return res.toString() + intToRoman_1(num);
            }
        } else if (num >= 10) {
            if (num >= 90) {
                return "XC" + intToRoman_1(num % 10);
            } else if (num >= 50) {
                return "L" + intToRoman_1(num - 50);
            } else if (num >= 40) {
                return "XL" + intToRoman_1(num % 10);
            } else {
                while (num >= 10) {
                    res.append("X");
                    num -= 10;
                }
                return res.toString() + intToRoman_1(num);
            }
        } else {
            if (num == 9) {
                return "IX";
            } else if (num >= 5) {
                return "V" + intToRoman_1(num - 5);
            } else if (num == 4) {
                return "IV";
            } else {
                while (num >= 1) {
                    res.append("I");
                    num--;
                }
                return res.toString();
            }
        }
    }

}
