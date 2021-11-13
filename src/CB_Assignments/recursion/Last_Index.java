package CB_Assignments.recursion;

import java.util.*;

public class Last_Index {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scn.nextInt();
        int m = scn.nextInt(); // number who's last occurrence is to be found out in the array
        int ans = printLastIndex(arr, m, arr.length-1);
        System.out.println("------------");
        System.out.println(ans);
        scn.close();
    }

    public static int printLastIndex (int[] arr, int target, int index) {
        if(index < 0) {
            return -1;
        }
        // base-case
        if(arr[index] == target) {
            return index;
        }

        return printLastIndex(arr, target, index-1);
    } 
}
