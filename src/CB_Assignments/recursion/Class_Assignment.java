package CB_Assignments.recursion;

import java.util.*;

public class Class_Assignment {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int i = 1;
        while (t-- > 0) {
            // logic of the program
            int n = scn.nextInt();
            System.out.println("#"+ i + " : " + solve("", n, false));
            i++;
        }
        scn.close();
    }

    public static int solve(String ans, int n, boolean isPreviousCallOfb) {
        // +ve base-case
        if(ans.length() == n) {
            return 1;
        }

        // -ve base-case
        if(ans.length() > n) {
            return 0;
        }
        int count = 0;
        // call for the character 'a'
        count+=solve(ans + 'a', n, false);
       // call for the character 'b'
        if (!isPreviousCallOfb) {
           count+=solve(ans + 'b', n, true);
        }
        return count;
    }
}
