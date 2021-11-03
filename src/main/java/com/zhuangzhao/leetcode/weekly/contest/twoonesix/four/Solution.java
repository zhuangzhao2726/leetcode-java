package com.zhuangzhao.leetcode.weekly.contest.twoonesix.four;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumEffort(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(tasks[i][0], tasks[i][1]));
        }
        taskList.sort((task1, task2) -> {
            if ((task1.minimum - task1.actual) > (task2.minimum - task2.actual)) {
                return 1;
            } else if ((task1.minimum - task1.actual) == (task2.minimum - task2.actual)) {
                return task1.minimum - task2.minimum;
            } else {
                return -1;
            }
        });
        int count = 0;
        for (Task task : taskList) {
            if (count + task.actual < task.minimum) {
                count = task.minimum;
            } else {
                count += task.actual;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] tasks = {{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}};
//        int[][] tasks = {{1,2},{2,4},{4,8}};
        System.out.println(solution.minimumEffort(tasks));
    }
}


class Task {
    int actual;
    int minimum;


    public Task() {
    }

    public Task(int actual, int minimum) {
        this.actual = actual;
        this.minimum = minimum;
    }
}