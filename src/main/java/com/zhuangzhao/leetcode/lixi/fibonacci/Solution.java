package com.zhuangzhao.leetcode.lixi.fibonacci;

public class Solution {
    //f(0) =0; f(1) = 1 f(n)=?

    int count = 0;

    public int fibonacci(int n) {
//        if(n <= 1){
//            count ++;
//            return n;
//        }else {
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//        if ( n <= 1){
//            return  n;
//        }else{
//            int[] arr = new int[n+1];
//            arr[0] = 0;
//            arr[1] = 1;
//            for(int i = 2 ;i < arr.length; i++){
//                arr[i] = arr[i-1]+arr[i-2];
//            }
//            return arr[n];
//        }
        if (n <= 1) {
            return n;
        } else {
            int a = 0;
            int b = 1;
            int temp = 0;
            for (int i = 2; i <= n; i++) {

                temp = a + b;
                a = b;
                b = temp % 1000000007;
            }
            return b;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fibonacci(46));
        System.out.println(s.fibonacci(47));
        System.out.println(s.fibonacci(48));
    }
}
