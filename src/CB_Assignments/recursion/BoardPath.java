package CB_Assignments.recursion;

import java.util.Scanner;
public class BoardPath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt(); // faces that dice have
        int ans = printBoardPath(m, n, 0, "");
        System.out.println();
        System.out.println(ans);
        scn.close();
    }

    public static int printBoardPath(int m, int n,int curr,String ans) {
        // +ve base-cases
        if(curr == n) {
            System.out.print(ans + " ");
            return 1;
        }
        // -ve base-case
        if(curr > n) {
            return 0;
        }

        int count = 0;
        // recursive calls
        for (int index = 1; index <= m; index++) {
           count += printBoardPath(m, n, curr+index, ans+index);
        }
        return count;
    }
}
