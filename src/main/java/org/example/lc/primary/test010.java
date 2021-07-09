package org.example.lc.primary;

import java.util.Arrays;

/*
https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/

移动零

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
*/
public class test010 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 4, 5, 6};
        new test010().moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::print);

        System.out.println();

        int[] nums1 = {1, 2, 3, 0, 0, 4, 5, 6};
        new test010().moveZeroes2(nums1);
        Arrays.stream(nums1).forEach(System.out::print);
    }

    /**
     * 把非0的往前挪
     * @param nums
     */
    public void moveZeroes(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int index = 0;
        //一次遍历，把非零的都往前挪
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        //后面的都是0
        while(index < nums.length){
            nums[index++] = 0;
        }
    }

    /**
     * 参照双指针解决
     * @param nums
     */
    public void moveZeroes1(int[] nums){
        int i =0; //统计前面0的个数
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] == 0){ //如果当前数字是0就不操作
                i++;
            }else if(i != 0){
                //否则，就把但钱数字放到最前面那个0的位置，然后把当前位置设置为0
                nums[j-i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    public void moveZeroes2(int[] nums){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //只要不为0就往前挪
            if(nums[j] != 0){
                //i指向的值和j指向的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }

}
