package com.atguigu;

import java.util.HashSet;
import java.util.Set;

public class T {
    //问题：一个大小为n的数组，里面的数都属于范围[0, n-1]，有不确定的重复元素，找到至少一个重复元素

    private static int a = 10;
    public static void main(String[] args) throws InterruptedException {
        // n=5
        Integer[] arr = new Integer[]{1,2,2,3,3};
        System.out.println(findRepeatNum0(arr));
        System.out.println(findRepeatNum1(arr));
        System.out.println(findRepeatNum2(arr));

        T t = new T();

    }

    /**
     * 使用双重循环进行判断
     * @param arr
     * @return
     */
    private static Integer findRepeatNum0(Integer[] arr){
        int repeatNum = -1;

        int size = arr.length;
        for (int i=0; i<size-1; i++) {
            for (int j=i+1; j<size; j++){
                if(arr[i].intValue() == arr[j].intValue()) {
                    repeatNum = arr[i];
                    break;
                }
            }
        }
        return repeatNum;
    }


    /**
     * 借助redis 布隆过滤器思想
     * 初始化一个与原数组同长度的数组，遍历原数组的数据值  在新数组中在相应的数据值的下标下置为1
     * 一旦遍历出现同样数据值位置出现了1 说明该数值重复了
     * @param arr
     * @return
     */
    private static Integer findRepeatNum1(Integer[] arr){
        int repeatNum = -1;
        Integer[] tempArr = new Integer[arr.length];

        for(int num : arr){
            // 由于原数组里面的数据都小于 n（数组的长度），所以这里直接用 数据值 作为下标判断（而不进行取模运算）
            // 如果该数据值所在的新数组的下标为null 或者 0，则将其置为1
            if (tempArr[num] == null || tempArr[num] == 0) {
                tempArr[num] = 1;
            } else {
                repeatNum = num;
                break;
            }
        }

        return repeatNum;
    }



    /**
     * 利用Set 特点（存放的元素不重复）
     * @param arr
     * @return
     */
    private static Integer findRepeatNum2(Integer[] arr){
        Integer repeatNum = -1;
        Set<Integer> tempSet = new HashSet<Integer>();
        int size = arr.length;
        for (int i=0; i<size; i++) {
            if(!tempSet.add(arr[i])){
                repeatNum = arr[i];
                break;
            }
        }
        return repeatNum;
    }



}
