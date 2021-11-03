package com.zhuangzhao.leetcode.lixi.nine;

class Solution {
    public boolean isPalindrome(int x) {

        //return   new StringBuffer(x + "").reverse().toString().equals(x+"");

        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            String str = String.valueOf(x);
            int fromIndex = 0;
            int toIndex = str.length() - 1;
            while (fromIndex < toIndex) {
                if (str.charAt(fromIndex) == str.charAt(toIndex)) {
                    fromIndex++;
                    toIndex--;
                } else {
                    return false;
                }
            }
            return true;
        }


    }
}