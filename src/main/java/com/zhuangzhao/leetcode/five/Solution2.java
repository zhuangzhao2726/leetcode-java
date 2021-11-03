package com.zhuangzhao.leetcode.five;


class Solution2 {
    public boolean isPalindrome(String s) {

        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i < j && i < length && j >= 0) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        boolean palindrome = solution2.isPalindrome("123567890987654321");
        System.out.println("123567890987654321   :  " + palindrome);


        palindrome = solution2.isPalindrome("12356789098");
        System.out.println("12356789098   :  " + palindrome);


        palindrome = solution2.isPalindrome("");
        System.out.println("   :  " + palindrome);


        palindrome = solution2.isPalindrome("1");
        System.out.println("1   :  " + palindrome);


        palindrome = solution2.isPalindrome("11");
        System.out.println("11   :  " + palindrome);


        palindrome = solution2.isPalindrome("121");
        System.out.println("121   :  " + palindrome);


        palindrome = solution2.isPalindrome("12");
        System.out.println("12   :  " + palindrome);
    }
}