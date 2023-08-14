package com.lyx.leetcode;

/**
 * 12.整数转罗马数字
 *
 * 思路：从高位到低位逐一转换
 */
public class Lc0012 {

    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        if (num >= 1000) {
            int c = num / 1000;
            while (c > 0) {
                res.append("M");
                c--;
            }
            return res.toString() + intToRoman(num % 1000);
        } else if (num >= 100) {
            if (num >= 900) {
                return "CM" + intToRoman(num % 100);
            } else if (num >= 500) {
                return "D" + intToRoman(num - 500);
            } else if (num >= 400) {
                return "CD" + intToRoman(num % 100);
            } else {
                int c = num / 100;
                while (c > 0) {
                    res.append("C");
                    c--;
                }
                return res.toString() + intToRoman(num % 100);
            }
        } else if (num >= 10) {
            if (num >= 90) {
                return "XC" + intToRoman(num % 10);
            } else if (num >= 50) {
                return "L" + intToRoman(num - 50);
            } else if (num >= 40) {
                return "XL" + intToRoman(num % 10);
            } else {
                int c = num / 10;
                while (c > 0) {
                    res.append("X");
                    c--;
                }
                return res.toString() + intToRoman(num % 10);
            }
        } else {
            if (num == 9) {
                return "IX";
            } else if (num >= 5) {
                return "V" + intToRoman(num - 5);
            } else if (num == 4) {
                return "IV";
            } else {
                int c = num;
                while (c > 0) {
                    res.append("I");
                    c--;
                }
                return res.toString();
            }
        }
    }

}
