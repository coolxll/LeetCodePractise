package com.leetcode.string;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
public class FundStatEasyAli {


    public void fundstat(String input) {
        HashMap<String,Double> fundMoney = new HashMap<>();
        String[] items = input.split(";");
        for(String item:items) {
            String[] pair = item.split(" ",2);
            String code = pair[0];
            String amount = pair[1];
            double amountVal = Double.parseDouble(amount);
            double originVal = fundMoney.getOrDefault(code, 0.00);
            originVal += amountVal;
            fundMoney.put(code,originVal);
        }

        Set<Map.Entry<String,Double>> set = fundMoney.entrySet();


        List<Map.Entry<String, Double>> list = set.stream().sorted(((o1, o2) -> (int) (o2.getValue() - o1.getValue()))).collect(Collectors.toList());

//        Iterator iter = set.iterator();
//
//        LinkedList<Map.Entry<String,Double>> list = new LinkedList();
//
//        while(iter.hasNext()) {
//            Map.Entry<String,Double> entry = (Map.Entry<String, Double>) iter.next();
//            list.add(entry);
//        }
//
//
//        for(int i=0;i<list.size();i++) {
//            for(int j=i+1;j<list.size();j++) {
//                if(list.get(i).getValue() < list.get(j).getValue()) {
//                    swap(list,i,j);
//                }
//            }
//        }

        log.info(JSON.toJSONString(list));
    }

    private void swap(List list,int i,int j) {
        Map.Entry<String,Double> o = (Map.Entry<String, Double>) list.get(j);
        list.set(j,list.get(i));
        list.set(i,o);
    }

    @Test
    public void test() {
        fundstat("020001 1000;020003 2000.15;020001 5000.00;020003 123.01;000345 100.00");
    }
}
