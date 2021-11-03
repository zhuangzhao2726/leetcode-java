package com.zhuangzhao.leetcode.guangsou.two;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minStepToTarget(int source, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(source, 0));
        int[] arr = new int[target];
        arr[source - 1] = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;
            System.out.print(count + ": " + node.value + "[" + node.index + "]" + "      ");
            if (node.value == target) {
                System.out.println("\ncount = " + count);
                return node.index;
            } else {
                if (node.value + 1 <= target && arr[node.value] == 0 ) {
                    queue.add(new Node(node.value + 1, node.index + 1));
                    arr[node.value] = 1;
                }

                if (node.value * 2 <= target && arr[node.value * 2 - 1] == 0 ) {
                    queue.add(new Node(node.value * 2, node.index + 1));
                    arr[node.value * 2 - 1] = 1;
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