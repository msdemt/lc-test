package org.example.lc.primary;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 */
public class test003 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        test003 test = new test003();
        test.rotate(nums, 2);

        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
    }

    public void rotate(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }


}
