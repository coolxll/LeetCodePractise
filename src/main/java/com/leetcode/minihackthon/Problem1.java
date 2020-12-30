package com.leetcode.minihackthon;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String realName = br.readLine().trim();
        String[] realNameList = realName.split(" ");
        String content;
        List<String[]> info = new ArrayList<>();
        while((content = br.readLine()) != null) {
            if("Q".equals(content)) {
                break;
            }
            String[] s = content.split(" ");
            info.add(s);
        }
        String output = solution1(realNameList, info);
        System.out.println(output);
    }

    public static String solution1(String[] realNameList, List<String[]> input) {
        Map<String,Set<String>>possibility = new HashMap<>();
        Set<String> currentOnlineList = new HashSet<>();
        Set<String> ebayNameList = new HashSet<>();
        StringBuilder outputResult = new StringBuilder();
        for(String[] line:input) {
            String event = line[0];
            String name = line[1];
            boolean realNameFlag = false;
            for(String s:realNameList) {
                if(s.equals(name)) {
                    realNameFlag = true;
                }
            }
            if(!realNameFlag) {
                ebayNameList.add(name);
            }
            switch (event) {
                case "E":
                    currentOnlineList.add(name);
                    break;
                case "M":
                    //Most important !!!!!!
                    if(possibility.containsKey(name)) {
                        Set<String> oldSet = possibility.get(name);
                        Set<String> newSet = new HashSet<>(currentOnlineList);
                        oldSet.retainAll(newSet);
                        if(oldSet.size() == 1) { //猜出来了就remove
                            String elem = oldSet.iterator().next();
                            for(Map.Entry<String,Set<String>> entry:possibility.entrySet()) {
                                if(!entry.getKey().equals(name)) {
                                    entry.getValue().remove(elem);
                                    possibility.put(entry.getKey(), entry.getValue());
                                }
                            }
                            currentOnlineList.remove(elem);
                        }
                        possibility.put(name, oldSet);
                    } else {
                        Set<String> newSet = new HashSet<>(currentOnlineList);
                        possibility.put(name,newSet);
                    }
                    break;
                case "L":
                    currentOnlineList.remove(name);
                    break;
                default:
                    break;
            }
        }
        TreeMap<String,String> result = new TreeMap<>();
        for(Map.Entry<String,Set<String>> entry:possibility.entrySet()) {
            Set<String> hashset = entry.getValue();
            String ebayName = "";
            if(hashset.size() == 1) {
                Iterator<String> iterator = hashset.iterator();
                ebayName = iterator.next();
                result.put(ebayName,entry.getKey());
            }
        }


        Iterator iterator = ebayNameList.iterator();
        while(iterator.hasNext()) {
            String name = (String) iterator.next();
            if(!result.containsKey(name)) {
                result.put(name,"???");
            }
        }


        for(Map.Entry<String,String> entry:result.entrySet()) {
            outputResult.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }
        return outputResult.toString().trim();
    }


    @Test
    public void test() {
        String[] realNameList = new String[] {"Liam","Noah","Oliver","William","Elijah","James","Benjamin"};
        List<String[]> inputs = new ArrayList<>();
        inputs.add("E Ironman".split(" "));
        inputs.add("E CaptainAmerica".split(" "));
        inputs.add("M Liam".split(" "));
        inputs.add("M Noah".split(" "));
        inputs.add("L Ironman".split(" "));
        inputs.add("E Thor".split(" "));
        inputs.add("E Batman".split(" "));
        inputs.add("M Liam".split(" "));
        inputs.add("M William".split(" "));
        inputs.add("M James".split(" "));
        inputs.add("L Thor".split(" "));
        inputs.add("M William".split(" "));
        inputs.add("E Barton".split(" "));
        inputs.add("M Oliver".split(" "));
        inputs.add("E BlackPanther".split(" "));
        inputs.add("E Denver".split(" "));
        String solution1 = solution1(realNameList,inputs);
        System.out.println(solution1);
    }

}
