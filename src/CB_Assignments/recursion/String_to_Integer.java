package CB_Assignments.recursion;

import java.util.Scanner;

public class String_to_Integer {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int n = str.length();
        int ans = convertStringToInteger(str,n);
        System.out.println(ans);
        scn.close();
    }

    public static int convertStringToInteger(String str,int n) {

        if(n == 1) {
            return str.charAt(0) - '0';
        }

        // creating a number is (first_character_of_remaining_String+ 10* remaining_no_string)
        return (10*convertStringToInteger(str,n-1) + str.charAt(n-1) - '0');
    }
}
