package CB_Assignments.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ways = towerOfHanoi(n, "T1", "T2", "T3");
        System.out.println(ways);
        scn.close();
    }

    public static int towerOfHanoi(int n, String source, String dest, String helper) {
        if(n == 1) {
            System.out.println("Move 1th disc from " + source + " to " + dest);
            return 1;
        }
        int count = 0;
        // recursive calls
        count += towerOfHanoi(n-1, source, helper, dest);
        System.out.println("Move " + n + "th disc from " + source + " to " + dest);
        count += towerOfHanoi(n-1, helper, dest, source);

        return count+1;
    }
}

// Move 1th disc from T1 to T3
// Move 2th disc from T1 to T2
// Move 1th disc from T3 to T2
