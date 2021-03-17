package com.leetcode.number;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        qSort(nums,0,nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr, int top, int tail) {
        if(top >= tail) return;
        int left = top, right = tail;
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] < temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        if(left == right) {
            arr[left] = temp;
        }
        if(left != top) quickSort(arr,0,left-1);
        if(right != tail) quickSort(arr,right+1,arr.length - 1);
    }

    public void qSort(int[] a, int l, int r) {
        if(l >= r) return;
        int i = l, j = r, x = a[l]; //l的位置空出来了
        while (i < j) {
            while(i<j && a[j] >= x) {//往后找第一个小于X的
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while(i<j && a[i] < x) { //往前找第一个大于X的
                i++;
            }
            if(i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = x;
        qSort(a,l,i-1);
        qSort(a,i+1,r);
    }
}
