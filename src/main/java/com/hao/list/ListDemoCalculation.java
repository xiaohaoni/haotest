package com.hao.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2021-01-05 11:16
 **/
public class ListDemoCalculation {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
       /* HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i],i)};
            }

        }*/
        return nums;
    }

    public static void addList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10007; i++) {
            list.add(i);
        }
        int num = list.size();
        int count = (int) (num / 50);
        int last = num % 50;
        for (int i = 0; i < count; i++) {
            List<Integer> newList = list.subList(0 + i * 50, 50 + i * 50);
            System.out.println("第" + i + "次" + newList);
        }
        if (last > 0) {
            List<Integer> newList = list.subList(num - last, num);
            System.out.println(newList);
        }
    }
}
