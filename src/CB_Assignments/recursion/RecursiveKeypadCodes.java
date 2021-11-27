package CB_Assignments.recursion;

import java.util.Scanner;

public class RecursiveKeypadCodes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int ways = recursiveKeypadCodes(str, "", 0);
        System.out.println();
        System.out.println(ways);
        scn.close();
    }

    public static int recursiveKeypadCodes(String question,String ans, int idx) {
        // base cases
        if(idx == question.length()) {
            System.out.print(ans + " ");
            return 1;
        }
        int count = 0;
        String[] phone = {" ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz"};
        String letters = phone[question.charAt(idx) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            count += recursiveKeypadCodes(question, ans + letters.charAt(i), idx+1);
        }

        return count;
    }
    
}
