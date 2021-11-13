package CB_Assignments.recursion;

import java.util.*;
public class First_Index {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int ans = printFirstIndex(arr, m, 0);
        System.out.println(ans);
        scn.close();
    }

    public static int printFirstIndex(int[] arr, int target, int index) {
        if(index == arr.length) {
            return -1;
        }

        if(arr[index] == target) {
            return index;
        }

        return printFirstIndex(arr, target, index+1);
    }
    
}
