package com.zhuangzhao.leetcode.weekly.contest.onesixnine.three;

import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {

        Queue<Integer> willVistQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        willVistQueue.add(start);


        while (!willVistQueue.isEmpty()) {
            Integer post = willVistQueue.poll();
            if (post - arr[post] >= 0 && post - arr[post] < arr.length) {
                if (arr[post - arr[post]] == 0) {
                    return true;
                } else if (!visited.contains(post - arr[post])) {
                    willVistQueue.add(post - arr[post]);
                    visited.add(post - arr[post]);
                }
            }

            if (post + arr[post] >= 0 && post + arr[post] < arr.length) {
                if (arr[post + arr[post]] == 0) {
                    return true;
                } else if (!visited.contains(post + arr[post])) {
                    willVistQueue.add(post - arr[post]);
                    visited.add(post + arr[post]);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}