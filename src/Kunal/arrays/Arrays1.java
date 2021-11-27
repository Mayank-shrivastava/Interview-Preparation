package Kunal.arrays;

import java.util.Arrays;

public class Arrays1 {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }


    // 1.Build Permutation
    public static int[] buildArray(int[] nums) {
        // solving in O(1) space complexity
        // make the number in the form of a = q*b + r
        // where q = nums.length b = nums[nums[i]] % q and r = nums[i]
        int q = nums.length;
        for(int i = 0; i < q; i++) {
            int r = nums[i];
            int b = nums[nums[i]] % q;
            nums[i] = q * b + r;
        }
        
        for(int i = 0; i < q; i++) {
            nums[i] = nums[i]/q;
        }
        
        return nums;
    }
    

    // 26.Remove duplicates from sorted array
    // nice question solve on revision
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int ptr = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[ptr++] = nums[i]; 
            }
        }
        return ptr;
    }

    // 66.Plus one
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArr = new int[n+1];
        newArr[0] = 1;
        return newArr;
    }
}
