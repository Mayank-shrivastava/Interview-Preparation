package dsa.recursionandbacktracking;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n, 0,0,"");
    }

    public static void generateParenthesis(int n, int opening, int closing, String ans) {
        if(opening == n && closing == n) {
            System.out.println(ans);
            return;
        }

        if(opening < n) {
            generateParenthesis(n, opening+1, closing, ans+"(");
        }

        if(closing < opening) {
            generateParenthesis(n, opening, closing+1, ans+")");
        }
    }
    
}
