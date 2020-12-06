package com.zhuangzhao.leetcode.four;

class Solution2 {

    /**
     * 一点理解：求两个数据的第[(m + n + 1) / 2] 和第[(m + n + 2) / 2]大的数;
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;

        int index1 = 0;
        int index2 = 0;

        int index = 0;

        int left1 = 0;
        int right1 = length1 - 1;
        int left2 = 0;
        int right2 = length2 - 1;


       while (index <= (length1 + length2) / 2) {

           int mid11 = left1 + (right1 - left1) / 2;
           int mid12 = left1 + (right1 - left1 + 1) / 2;

           int mid21 = left2 + (right2 - left2) / 2;
           int mid22 = left2 + (right2 - left2 + 1) / 2;

            if(left1 > right1) {
                return ((double)(nums2[(length / 2 - length1)] + nums2[(length + 1) / 2 - left1])) / 2;
            } else if(left2 > right2) {
                return ((double)(nums1[(length / 2 - length2)] + nums1[(length + 1) / 2 - left2])) / 2;
            } else {
                if(nums1[mid12] >= nums2[mid22]){
                    right1 = mid11;
                } else {
                    right2 = mid21;
                }

                if(nums1[mid11] <= nums2[mid21]){
                    if(index + (mid11 - left1 + 1) <= ((length - 1))){
                        left1 = mid12;
                    }




                } else {
                    right2 = mid21;
                }



            }



           index1 = left1 + (right2 - left1) / 2;
           index2 = left2 + (right2 - left2) / 2;
           if(index1 >= left1 && index2 >= left2) {
               if (nums1[index1] <= nums2[index2]) {

               }
           }

       }
       return 0;
    }
}