package CB_Assignments.recursion;


import java.util.*;
public class SmartKeyboard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printSmartKeyBoard(str, "",0);
        scn.close();
    }

    public static void printSmartKeyBoard(String str, String ans, int index) {
        if(index == str.length()) {
            System.out.println(ans);
            return;
        }
        String[] table  = {"", ".+@$", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String letters = table[str.charAt(index)-'0'];
        for(int i = 0; i < letters.length(); i++) {
            printSmartKeyBoard(str, ans + letters.charAt(i), index+1);
        } 
    }
}
