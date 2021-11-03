package com.zhuangzhao.leetcode.guangsou.one;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {


    public int minStepToTarget(int source, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(source, 0));
        Set<Integer> set = new HashSet<>();
        set.add(source);
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;
            System.out.print(count + ": " + node.value + "[" + node.index + "]" + "      ");
            if (node.value == target) {
                System.out.println("\ncount = " + count);
                return node.index;
            } else {
                if ((!set.contains(node.value + 1)) && ((node.value + 1) <= target)) {
                    queue.add(new Node(node.value + 1, node.index + 1));
                    set.add(node.value + 1);
                }

                if ((!set.contains(node.value * 2)) && ((node.value * 2) <= target)) {
                    queue.add(new Node(node.value * 2, node.index + 1));
                    set.add(node.value * 2);

                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStepToTarget(1, 100));
    }
}

class Node {
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
