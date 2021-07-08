package org.example.lc.primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/

两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

说明：
输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。

进阶：
如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

*/
public class test007 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 5, 6, 7, 8};
        int[] intersect = new test007().intersect(nums1, nums2);
        Arrays.stream(intersect).forEach(System.out::println);
        
    }

    public int[] intersect(int[] nums1, int[] nums2){
        //先对两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                //如果i指向的值小于j指向的值，说明i指向的值小，i往后移一步
                i++;
            }else if(nums1[i] > nums2[j]){
                //如果j指向的值小于i指向的值，说明j指向的值小，j往后移一步
                j++;
            }else{
                //如果i和j指向的值相同，说明这两个值是重复的，把它加入到集合list中，然后i和j同时往后移一步
                list.add(nums1[i]);
                i++;
                j++;
            }

        }
        //把list转为数组
        int index = 0;
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //先把数组nums1的所有元素都存到map中，其中key是数组中的元素，value是这个元素在数组中出现的次数
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[1], 0)+1);
        }

        //然后再遍历nums2数组，查看map中是否包含nums2的元素，
        //如果包含，就把当前值加入到集合list中，然后再把对应的value值减一
        for(int i=0; i<nums2.length; i++){
            if(map.getOrDefault(nums2[i], 0) > 0){
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
    
        //把集合list转为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}
