package com.leetcode.minihackthon;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem2 {

    private static Node root = new Node(0, 0);

    private static HashMap<Integer, Integer> valueMap = new HashMap<>();
    private static HashMap<Integer, List<Integer>> parentMap = new HashMap<>();
    private static List<List<Node>> levelNodeMap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        int numOfEmployee = Integer.parseInt(firstLine);
        String friendScores = br.readLine();
        String employeeId = br.readLine();
        String[] friendScoreList = friendScores.split(" ");
        String[] employeeIdList = employeeId.split(" ");
        int output = solution2(numOfEmployee,friendScoreList,employeeIdList);
        System.out.println(output);
    }

    private static int solution2(int numOfEmployee, String[] friendScoreList, String[] employeeIdList) {
        if(numOfEmployee == 0) {
            return 0;
        }

        for (int i = 0; i < friendScoreList.length; i++) {
            int value = Integer.parseInt(friendScoreList[i]);
            valueMap.put(i, value);
        }
        for (int i = 0; i < employeeIdList.length; i ++) {
            int parent = Integer.parseInt(employeeIdList[i]);
            if (!parentMap.containsKey(parent)) {
                parentMap.put(parent, new ArrayList<>());
            }
            parentMap.get(parent).add(i);
            if (parent == -1) {
                root.value = valueMap.get(i);
                root.index = i;
            }
        }
        insertNode(root);
        dfs(root, 0);

        Collections.reverse(levelNodeMap);
        for (int i = 0; i < levelNodeMap.size(); i ++ ) {
            for (int j = 0; j < levelNodeMap.get(i).size(); j ++) {
                Node node = levelNodeMap.get(i).get(j);
                if (i == 0) {
                    node.maxValueWithoutSelf = 0;
                    node.maxValueWithSelf = node.value;
                } else {
                    node.maxValueWithSelf = node.value;
                    for (Node child: node.children) {
                        node.maxValueWithSelf += child.maxValueWithoutSelf;
                        node.maxValueWithoutSelf += Math.max(child.maxValueWithSelf, child.maxValueWithoutSelf);
                    }
                }
            }
        }
        return Math.max(root.maxValueWithoutSelf, root.maxValueWithSelf);
    }

    private static void dfs(Node node, int level) {
        if (level >= levelNodeMap.size()) {
            levelNodeMap.add(new ArrayList<>());
        }
        levelNodeMap.get(level).add(node);
        for (Node childNode: node.children) {
            dfs(childNode, level + 1);
        }
    }

    private static void insertNode(Node node) {
        if (parentMap.containsKey(node.index)) {
            List<Integer> children = parentMap.get(node.index);
            for (int child: children) {
                Node childNode = new Node(valueMap.get(child), child);
                node.children.add(childNode);
                insertNode(childNode);
            }
        }
    }

    static class Node {
        int value;
        int index;
        int maxValueWithoutSelf;
        int maxValueWithSelf;
        List<Node> children;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
            this.children = new ArrayList<>();
        }
    }

    @Test
    public void test() {
        String[] friendScoreList = "1 1 1 1 1 1 1".split(" ");
        String[] employeeIdList = "2 2 4 4 -1 3 3".split(" ");
        int output = solution2(7, friendScoreList, employeeIdList);
        System.out.println(output);
    }
}
