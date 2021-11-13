package leetcode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    // squares of the sorted array
    // Two pointer approach - Optimized O(N) solution
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int insertedIndex = nums.length - 1;
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[insertedIndex] = nums[left]*nums[left];
                left++;
                insertedIndex--;
            } else {
                ans[insertedIndex] = nums[right]*nums[right];
                right--;
                insertedIndex--;
            }
        } 
        return ans;
    }

    // count unhappy friends Leetcode: 1583
    public static int unhappyFriend(int n, int[][] preferences, int[][] pairs) {
        return 0;
    }
}
