package CB_Assignments.recursion;

import java.util.*;
public class Print_Subsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int count = printSubsequence(str, "");
        System.out.println();
        System.out.println(count);
        scn.close();
    }

    public static int printSubsequence(String str, String ans) {
        if(str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        char ch = str.charAt(0); // capture the first character of the string
        // here we have two choices 
        //   1. either first character will participate in the subsequence 
        //   2. or it will not participate in the subsequence
        // yes
        count += printSubsequence(str.substring(1), ans + ch);
        // no
        count += printSubsequence(str.substring(1), ans);

        return count;
    }
}
