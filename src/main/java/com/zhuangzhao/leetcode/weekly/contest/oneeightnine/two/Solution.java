package com.zhuangzhao.leetcode.weekly.contest.oneeightnine.two;

class Solution {
    public String arrangeWords(String text) {
        String[] array = text.split(" ");
        sort(array);
        String join = String.join(" ", array).toLowerCase();
        if (join.length() == 1) {
            return join.toUpperCase();
        } else {
            return join.substring(0, 1).toUpperCase() + join.substring(1);
        }
    }

    private void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].length() > array[j + 1].length()) {
                    String value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                }
            }
        }
    }


    public static void main(String[] args) {
        String text = "a b n ";
        String[] split = text.split(" ");
        System.out.println(split);

        Solution solution = new Solution();
        System.out.println(solution.arrangeWords("Keep calm and code on"));
    }
}