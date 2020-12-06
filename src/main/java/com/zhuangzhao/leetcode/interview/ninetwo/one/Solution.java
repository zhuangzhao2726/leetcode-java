package com.zhuangzhao.leetcode.interview.ninetwo.one;

import java.util.List;
import java.util.Scanner;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-09-02 19:08
 */
public class Solution {


    public static void main(String[] args) {

        int count = 6;
        int[] nums = {8,2,3,5,3,7};
        int[] types = {2,2,2,2,2,2};

        Solution solution = new Solution();
        Result result = solution.search(count, nums, types);
        if (result == null) {
            System.out.println("null");
        } else {
            for (int location : result.getLocation()) {
                System.out.print(location + " ");
            }
            System.out.println();
            System.out.println(result.getType());
            System.out.println(result.getTotal());
        }
    }



    public Result search(int count, int[] nums, int[] types) {
        int red = 0;
        int blue = 0;
        for (int type : types) {
            if (type == 1) {
                red++;
            } else {
                blue++;
            }
        }
        if (red < 3 && blue < 3) {
            return null;
        }

        Bobby[] redBobby = new Bobby[red];
        Bobby[] blueBobby = new Bobby[blue];


        int redIndex = 0;
        int blueIndex = 0;
        for (int i = 0; i < count; i++) {
            Bobby bobby = new Bobby(i + 1, nums[i]);
            if (types[i] == 1) {
                redBobby[redIndex++] = bobby;
            } else {
                blueBobby[blueIndex++] = bobby;
            }
        }
        sort(redBobby);
        sort(blueBobby);
        Result redResult = generateResult(redBobby, 1);
        Result blueResult = generateResult(blueBobby, 2);

        if (redResult == null) {
            return blueResult;
        } else if (blueResult == null) {
            return redResult;
        } else {
            if (redResult.getTotal() < blueResult.getTotal()) {
                return blueResult;
            } else {
                return redResult;
            }
        }


    }



    private Result generateResult(Bobby[] bobbies, int type) {
        if (bobbies.length < 3) {
            return null;
        }
        int[] location = new int[3];
        location[0] = bobbies[bobbies.length - 3].getIndex();
        location[1] = bobbies[bobbies.length - 2].getIndex();
        location[2] = bobbies[bobbies.length - 1].getIndex();
        int total = bobbies[bobbies.length - 3].getNum() + bobbies[bobbies.length - 2].getNum() + bobbies[bobbies.length - 1].getNum();
        return new Result(location, type, total);
    }


    private void sort(Bobby[] bobbies) {
        for (int i =0; i < bobbies.length; i++) {
            int max = 0;
            for (int j = 1; j < bobbies.length - i; j++) {
                if (compareLess(bobbies[max], bobbies[j])) {
                    max = j;
                }
            }
            Bobby bobby = bobbies[bobbies.length - 1 -i];
            bobbies[bobbies.length - 1 -i] = bobbies[max];
            bobbies[max] = bobby;
        }
    }

    private boolean compareLess(Bobby bobby1, Bobby bobby2) {
        if (bobby1.getNum() < bobby2.getNum()) {
            return true;
        } else if (bobby1.getNum() < bobby2.getNum()) {
            return bobby1.getIndex() > bobby2.getIndex();
        }
        return false;
    }



}

class Result {

    private int[] location;

    private int type;

    private int total;


    public Result(int[] location, int type, int total) {
        this.location = location;
        this.type = type;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public int getType() {
        return type;
    }

    public int[] getLocation() {
        return location;
    }
}


class Bobby {
    private int index;

    private int num;

    public Bobby(int index, int num) {
        this.index = index;
        this.num = num;
    }


    public int getIndex() {
        return index;
    }

    public int getNum() {
        return num;
    }
}