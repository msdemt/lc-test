package org.example.lc.primary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/

两数之和

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

提示：
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
*/
public class test011 {

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 5, 8};
        int target = 6;
        int[] twoSum = new test011().twoSum(nums, target);
        Arrays.stream(twoSum).forEach(System.out::print);

        System.out.println();
        
        int[] twoSum1 = new test011().twoSum1(nums, target);
        Arrays.stream(twoSum1).forEach(System.out::print);
    }

    /**
     * 暴力破解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Hash Map解决
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(m.get(target - nums[i]) != null){
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
    
}
