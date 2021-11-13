package CB_Assignments.recursion;

import java.util.*;

public class Reverse_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        reversedArray(arr, 0);
        scn.close();
    }

    public static void reversedArray(int[] arr, int i) {
        if(i == arr.length) {
            return;
        }
        // make all the recursive calls
        reversedArray(arr,i+1);
        System.out.print(arr[i] + " ");
        
    }
    
}
