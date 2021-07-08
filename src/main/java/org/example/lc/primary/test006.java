package org.example.lc.primary;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/

只出现一次的数字

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,1]
输出: 1
*/
public class test006 {
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 2, 3, 4};
        System.out.println(new test006().singleNumber(nums));

        System.out.println(new test006().singleNumber1(nums));
    }

    /**
     * a^a=0；自己和自己异或等于0
     * a^0=a；任何数字和0异或还等于他自己
     * a^b^c=a^c^b；异或运算具有交换律
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * 使用 Set 解决
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                //如果添加失败，说明这个值在集合Set中已存在，我们把它移除掉
                set.remove(num);
            }
        }
        //最终集合Set中只有一个元素，直接返回即可
        return (int) set.toArray()[0];
    }
}
