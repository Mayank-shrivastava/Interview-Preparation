package CB_Assignments.recursion;

import java.util.*;

public class Nth_Triangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(nthTriangle(n));
        scn.close();
    }

    public static int nthTriangle(int n) {
        if(n == 0) {
            return 0;
        }

        // recursive-call
        int ans = n;
        ans = ans + nthTriangle(n-1);
        return ans;
    
    }
}
