package org.example.lc.primary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/

存在重复元素

给定一个整数数组，判断是否存在重复元素。

如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。


示例 1:
输入: [1,2,3,1]
输出: true

示例 2:
输入: [1,2,3,4]
输出: false
*/
public class test005 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 1};
        System.out.println(new test005().containsDuplicate(nums));
        System.out.println(new test005().containsDuplicate1(nums));
    }

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 先排序，再比较
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    /**
     * 使用set集合
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //因为集合set中不能有重复的元素，如果有重复的元素，添加就会失败，返回false
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }

    /**
     * 使用set集合，判断长度，效率没有上面的高
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //如果有重复的元素，set中会覆盖，导致size减小
        //如果没有重复元素，set的大小等于nums的长度
        return set.size() != nums.length;
    }
    
}
