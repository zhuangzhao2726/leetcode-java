package com.zhuangzhao.leetcode.lixi.binarysearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl{
    boolean isBadVersion(int version){
        return false;
    }
}


public class SolutionTwo extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left+(right -left) / 2;
            if (isBadVersion(mid)) {
                right= mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}