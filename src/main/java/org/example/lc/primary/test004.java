package org.example.lc.primary;

import java.util.Arrays;

/*

https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/

旋转数组

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

进阶：
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？

示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

提示：
1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
*/
public class test004 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        new test004().rotate(arr, 2);
        Arrays.stream(arr).forEach(System.out::print);

        System.out.println();

        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        new test004().rotate1(arr1, 2);
        Arrays.stream(arr1).forEach(System.out::print);

        System.out.println();

        int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        new test004().rotate1(arr2, 2);
        Arrays.stream(arr2).forEach(System.out::print);
    
        System.out.println();
        
        int[] arr3 = { 1, 2, 3, 4, 5, 6 };
        new test004().rotate1(arr3, 2);
        Arrays.stream(arr3).forEach(System.out::print);
    }

    /**
     * 方式一 使用临时数组
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int temp[] = new int[length];
        // 把原数组值放到一个临时数组中
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }

        // 然后把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }

    /**
     * 方式二 多次反转
     * 
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1); // 先反转全部的元素
        reverse(nums, 0, k - 1); // 再反转前k个元素
        reverse(nums, k, length - 1); // 接着反转剩余元素
    }

    // 把数组中从[start，end]之间的元素两两交换,也就是反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - k - 1); // 先反转前面的
        reverse(nums, length - k, length - 1); // 接着反转后面k个
        reverse(nums, 0, length - 1); // 最后反转全部元素
    }

    public void rotate3(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            if (visited[index]) {
                // 如果访问过，再次访问的话，就会出现原地打转的情况
                // 不能再访问当前元素了，我们直接从下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            } else {
                // 把当前值保存在下一个位置，保存之前要把下一个位置的值记录下来
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }

}
