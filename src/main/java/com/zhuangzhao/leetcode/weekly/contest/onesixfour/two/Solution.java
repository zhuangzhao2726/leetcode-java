package com.zhuangzhao.leetcode.weekly.contest.onesixfour.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int countServers(int[][] grid) {

        List<Integer> row = new ArrayList<>();

        List<Integer> col = new ArrayList<>();



        List<Integer> doubleRow = new ArrayList<>();

        List<Integer> doubleCol = new ArrayList<>();



        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if(row.contains(i)) {
                        doubleRow.add(i);
                    } else {
                        row.add(i);
                    }
                    if(col.contains(j)) {
                        doubleCol.add(j);
                    } else {
                        col.add(j);
                    }
                }
            }
        }

        Set<Node> nodes = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if((doubleRow.contains(i) || doubleCol.contains(j)) && grid[i][j] == 1) {
                    nodes.add(new Node(i, j));
                }
            }
        }
        return nodes.size();
        
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = {{1,0},{0,1}};

        System.out.println(solution.countServers(grid));;


        int[][] test = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};

        System.out.println(solution.countServers(test));;






    }
}


class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Node) {
            return this.x == ((Node) obj).x && this.y == ((Node) obj).y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new Integer(x).hashCode() + new Integer(y).hashCode();
    }
}