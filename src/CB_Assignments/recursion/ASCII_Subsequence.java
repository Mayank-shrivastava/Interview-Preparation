package CB_Assignments.recursion;

import java.util.*;
public class ASCII_Subsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int ans = printASCIISubsequence(str, "");
        System.out.println();
        System.out.println(ans);
        scn.close();
    }

    public static int printASCIISubsequence(String str, String ans) {
        // base-cases
        if(str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }

        int count = 0;
        char ch = str.charAt(0);
        // character not-included
        count += printASCIISubsequence(str.substring(1), ans);
        // character included
        count += printASCIISubsequence(str.substring(1), ans + ch);
        // ascii code of character included
        count += printASCIISubsequence(str.substring(1), ans + (int)ch);
        return count;
    }
}
