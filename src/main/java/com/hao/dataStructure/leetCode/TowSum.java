package com.hao.dataStructure.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-03-08 12:32
 * 两数之和
 **/
public class TowSum {
    public static void main(String[] args) {
        int[] nums ={1,2,34,5,6,3,5,23};
        int target = 10;
        int[] twoSum = twoSum(nums,target);
        System.out.println(Arrays.toString(twoSum));

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
