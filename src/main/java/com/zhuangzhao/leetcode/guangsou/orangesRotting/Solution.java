package com.zhuangzhao.leetcode.guangsou.orangesRotting;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {
    public int orangesRotting(int[][] grid) {
        //1、创建一个队列，利用先进先出的特性实现广搜，把初始点添加到队列中
        ///2、创建一个set，把初识点也添加到set中，
        ///3、判断这个队列不为空，将队列的头节点出队列，如果为空，则返回-1代表无解。
        ///4、判断出队列的元素是否为目标值，如果是，则返回目标值的索引。如果不是，则将扩展的节点添加到队列及其set中。

        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new Node(i,j,0));
                    set.add(new Node(i,j,0));
                }
            }
        }

        while (!queue.isEmpty()){
           Node node =  queue.poll();
           grid[node.row][node.col] = 2;
           if(hasOrangeBad(grid)){
               if(node.row+1<=grid.length-1 && grid[node.row+1][node.col] != 0
                       && set.contains((new Node(node.row+1, node.col, node.step+1)))){
                   queue.add(new Node(node.row+1, node.col, node.step+1));
                   set.add(new Node(node.row+1, node.col, node.step+1));
               }
               if(node.row-1 >= 0 && grid[node.row-1][node.col] != 0
                       && !set.contains((new Node(node.row-1, node.col, node.step+1)))) {
                   queue.add(new Node(node.row-1, node.col, node.step+1));
                   set.add(new Node(node.row-1, node.col, node.step+1));
               }
               if (node.col-1 >= 0 && grid[node.row][node.col-1] != 0
                       && !set.contains(new Node(node.row, node.col-1, node.step+1))) {
                   queue.add(new Node(node.row, node.col-1, node.step+1));
                   set.add(new Node(node.row, node.col-1, node.step+1));
               }
               if (node.col+1 <= grid[node.row].length - 1 && grid[node.row][node.col + 1] != 0
                       && !set.contains(new Node(node.row, node.col+1, node.step+1))) {
                   queue.add(new Node(node.row, node.col+1, node.step+1));
                   set.add(new Node(node.row, node.col+1, node.step+1));
               }
           }else{
               return node.step;
           }
        }
        return -1;
    }

    private Boolean hasOrangeBad(int[][] grid){
        Boolean flag = false;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};

        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(grid));
    }


}

class Node {
    int row;
    int col;
    int step;

    public Node(int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return row == node.row && col == node.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}