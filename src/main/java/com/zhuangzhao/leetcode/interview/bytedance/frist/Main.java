package com.zhuangzhao.leetcode.interview.bytedance.frist;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList();
        for (int i = 0; i < 10; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < 10; j++) {
                list.add(j);
            }
            arrays.add(list);
        }
        Main test = new Main();
        List<Integer> result = test.mergeSort2(arrays);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i) + ", ");
        }
    }
    
    
    public List<Integer> mergeSort2(List<List<Integer>> arrays) {
        if(arrays.size() <= 1) {
            return arrays.get(0);
        }
        List<List<Integer>> list01 = new ArrayList<>();
        int mid = (arrays.size() - 1) / 2;
        for (int i = 0; i <= mid; i++) {
            list01.add(arrays.get(i));
        }
        List<Integer> result01 = mergeSort2(list01);
        List<List<Integer>> list02 = new ArrayList<>();
        for (int i = mid + 1; i < arrays.size(); i++) {
            list02.add(arrays.get(i));
        }
        List<Integer> result02 = mergeSort2(list02);
        List<Integer> result = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while(index1 < result01.size() || index2 < result02.size()) {
            if (index1 == result01.size()) {
                result.add(result02.get(index2++));
            } else if (index2 == result02.size()) {
                result.add(result01.get(index1++));
            } else if (result01.get(index1) <= result02.get(index2)){
                result.add(result01.get(index1++));
            } else {
                result.add(result02.get(index2++));
            }
        }
        return result;
    }
}