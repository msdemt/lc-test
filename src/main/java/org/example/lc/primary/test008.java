package org.example.lc.primary;

import java.util.Arrays;

/*
https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/

加一
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1：
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

示例 2：
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。

示例 3：
输入：digits = [0]
输出：[1]

提示：
1 <= digits.length <= 100
0 <= digits[i] <= 9
*/
public class test008 {

    public static void main(String[] args) {
        int[] digits = {9,8,7};
        int[] plusOne = new test008().plusOne(digits);
        Arrays.stream(plusOne).forEach(System.out::print);
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                //如果数组当前元素不等于9，直接加1，然后直接返回
                digits[i]++;
                return digits;
            } else {
                //如果数组当前元素等于9，那么加1之后，肯定会变为0，我们先让它变为0
                digits[i] = 0;
            }
        }
        //除非数组中的元素都是9，否则不会走到这一步
        //如果数组的元素都是9，我们只需要把数组的长度增加1，并且把数组的第一个元素置为1即可
        int temp[] = new int[length+1];
        temp[0] = 1;
        return temp;
    }
}
