package com.spider;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String[] args) {

        //WQH test001

        AppTest appTest = new AppTest();
        int[] ints = appTest.noStringNum(new int[]{6,10});
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<>();
        int[] xb = null;
        for (int i = 0;i<nums.length;i++){
            //从map中取出和为target的 下标
            if (map.get(target-nums[i])!=null){
                xb = new int[]{i, (int) map.get(target - nums[i])};
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        return xb;
    }
    //给定一个数组 返回其中不连续的数字
    public int[] noStringNum(int[] nums){
        //两种情况： 1.不连续数字存在于数组中   2.不连续数字不存在数组中
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        List<Integer> notStringNumList = new ArrayList<Integer>();
        //通过 min 、 max 即可得出不连续数字是否存在数组中
        if (max-min != nums.length-1){//存在
            int slow;//慢下标
            int fast;//快下标
            for (int i = 0;i<nums.length;i++){
                slow = i;
                fast = i+1;
                if (fast<nums.length) {
                    if (nums[fast] - nums[slow] > 1) {//差值大于1则证明存在不连续数字
                        int count = nums[fast] - nums[slow] - 1;//差值的个数
                        int notstringnum = nums[slow];
                        while (count > 0) {
                            notstringnum++;
                            notStringNumList.add(notstringnum);
                            count--;
                        }
                    }
                }
            }
        }else {//不存在
            return null;
        }
        int[] result = new int[notStringNumList.size()];
        for (int i = 0;i<result.length;i++){
            result[i] = notStringNumList.get(i);
        }
        return result;
    }
}
