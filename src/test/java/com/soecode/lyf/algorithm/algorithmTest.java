package com.soecode.lyf.algorithm;
import org.junit.Test;

import java.util.*;

public class algorithmTest {

    /**
    * 给定一个无序的整数类型数组，求最长的连续元素序列的长度。
     * 例如：
     * 给出的数组为[100, 4, 200, 1, 3, 2],
     * 最长的连续元素序列为[1, 2, 3, 4]. 返回这个序列的长度：4
     * 你需要给出时间复杂度在O（n）之内的算法
     *
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     *
     * For example,
     * Given[100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
     *
     * Your algorithm should run in O(n) complexity.
    * */
    @Test
    public void test1(){
        int [] a = {100,4, 200,1,3,2};
        System.out.println(longestConsecutive(a));
    }
    public int longestConsecutive(int[] num) {
        int n = num.length;
        if(n<=1){
            return n;
        }
        Arrays.sort(num);

        int length = 0;
        int cur = 1;
        for(int i=1;i<n;i++){
            if(num[i]==num[i-1]){
                continue;
            }
            if(num[i]-num[i-1]==1){
                cur++;
            }else{
                if(cur>length){
                    length = cur;
                }
                cur = 1;
            }
        }
        if(cur>length){
            length = cur;
        }
        return length;
    }

}
