package CB_Assignments.recursion;

import java.util.*;
public class Generate_Parenthesis {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        generateParenthesis(n, "", 0, 0);
        scn.close();
    }

    public static void generateParenthesis(int n, String ans, int opening, int closing) {
        // +ve base-case
        if(opening == n && closing == n) {
            System.out.println(ans);
            return;
        }

        // -ve base-case
        if(opening > n || closing > opening) {
            return;
        }

        // recursive call for opening braces
        generateParenthesis(n, ans+"(", opening+1,closing);
        // recursive call for closing braces
        generateParenthesis(n, ans+")", opening, closing+1);
    }

}
