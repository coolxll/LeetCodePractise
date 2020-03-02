package com.leetcode.archive;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Conan on 2017/2/12.
 */
public class BinarySearchTest {
    @Test
    public void binarySearch() throws Exception {
        int[] a = new int[] {1,3,5,6,7,89,111,156};
        int n = a.length;
        int result = BinarySearch.binarySearch(a, n, 89);
        Assert.assertNotEquals(-1,result);
    }

    @Test
    public void intToList() {
        int[] a = new int[] {1,3,5,6,7,89,111,156,82,82};
        List<Integer> intList = IntStream.of(a).boxed().collect(Collectors.toList());
        intList.sort(Comparator.comparingInt(i -> i));
        System.out.println(intList);
    }


}