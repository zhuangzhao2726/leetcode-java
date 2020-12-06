package com.zhuangzhao.leetcode.six.eight;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        int last = 0;
        int length = -1;
        while (index <= words.length) {
            if (index < words.length && length + 1 + words[index].length() <= maxWidth) {
                length += 1 + words[index].length();
                index++;
            } else if (last < index) {
                if (index == words.length) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(words[last]);
                    for (int i = 1; i < index - last; i++) {
                        buffer.append(" ");
                        buffer.append(words[last + i]);
                    }
                    for (int j = length; j < maxWidth; j++) {
                        buffer.append(" ");
                    }
                    result.add(buffer.toString());
                }
                else if (last == index -1) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(words[last]);
                    for (int j = length; j < maxWidth; j++) {
                        buffer.append(" ");
                    }
                    result.add(buffer.toString());
                } else {
                    int space = (maxWidth - length) / (index - last - 1);
                    int more = (maxWidth - length) % (index - last - 1);
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(words[last]);
                    for (int i = 1; i < index - last; i++) {
                        for (int j = 0; j < space + 1; j++) {
                            buffer.append(" ");
                        }
                        if (i <= more) {
                            buffer.append(" ");
                        }
                        buffer.append(words[last + i]);
                    }
                    result.add(buffer.toString());
                }
                last = index;
                length = -1;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        List<String> list = solution.fullJustify(words, 16);
        solution.print(list);

    }

    private void print(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}