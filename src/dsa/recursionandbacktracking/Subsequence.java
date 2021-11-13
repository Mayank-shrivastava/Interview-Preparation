package dsa.recursionandbacktracking;

public class Subsequence {
    public static void main(String[] args) {
        String str = "abc";
        printSubsequence(str, "");
    }

    public static void printSubsequence(String question, String ans) {
        if(question.length() == 0) {
            System.out.println(ans);
            return;
        }
        // capture the first character of the question string
        char ch = question.charAt(0);
        // two recursive calls will be taken place 
        //      1. contains the ch
        //      2. does not contains the ch
        

        // ch will not be included
        printSubsequence(question.substring(1), ans);
        // ch will be included
        printSubsequence(question.substring(1), ans+ch);
    }
}
