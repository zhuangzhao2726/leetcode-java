package com.zhuangzhao.leetcode.four.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1 {

    public Map<String, List<Task>> allocateTask(List<Task> tasks, List<String> userIdList) {
        Map<String, List<Task>> result = new HashMap<>();
        if (tasks == null || tasks.isEmpty()) {
            return result;
        }
        if (userIdList == null || userIdList.isEmpty()) {
            throw new RuntimeException("员工列表不能为空");
        }
        Collections.shuffle(tasks);
        Collections.shuffle(userIdList);
        for (int i = 0; i < tasks.size(); i++) {
            int index = i % userIdList.size();
            if (!result.containsKey(userIdList.get(index))) {
                result.put(userIdList.get(index), new ArrayList<>());
            }
            result.get(userIdList.get(index)).add(tasks.get(i));
        }
        return result;
    }
}


class Task {
    private Long taskId;

    private String desc;
}