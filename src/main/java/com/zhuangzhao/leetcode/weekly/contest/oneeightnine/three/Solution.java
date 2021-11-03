package com.zhuangzhao.leetcode.weekly.contest.oneeightnine.three;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < favoriteCompanies.size(); i++, index++) {
            boolean flag = true;
            int j = 0;
            for (j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) {
                    continue;
                } else {
                    if (favoriteCompanies.get(j).size() >= favoriteCompanies.get(i).size() &&
                            favoriteCompanies.get(j).containsAll(favoriteCompanies.get(i))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                list.add(index);
            } else {
                favoriteCompanies.remove(i--);
            }
        }
        return list;
    }
}