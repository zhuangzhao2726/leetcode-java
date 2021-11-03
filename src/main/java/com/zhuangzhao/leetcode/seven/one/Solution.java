package com.zhuangzhao.leetcode.seven.one;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String simplifyPath(String path) {
        String[] splits = path.split("/");
        List<String> list = new ArrayList<>();
        for (String split : splits) {
            switch (split) {
                case "":
                case ".":
                    break;
                case "..":
                    if (list.size() > 0) {
                        list.remove(list.size() - 1);
                    }
                    break;
                default:
                    list.add(split);
            }
        }
        StringBuffer buffer = new StringBuffer();
        if (list.isEmpty()) {
            buffer.append("/");
        } else {
            list.forEach(str -> buffer.append("/").append(str));
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//"));
    }
}