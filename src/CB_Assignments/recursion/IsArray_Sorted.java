package CB_Assignments.recursion;

import java.util.*;
public class IsArray_Sorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
        boolean ans = isArraySorted(arr, 0);
        System.out.println(ans);
        scn.close();
    }

    public static boolean isArraySorted(int[] arr, int index) {
        if(index+1 == arr.length) {
            return true;
        }

        if(arr[index] > arr[index + 1]) {
            return false;
        }

        // recursive-calls
        return isArraySorted(arr, index+1);
    }
}

