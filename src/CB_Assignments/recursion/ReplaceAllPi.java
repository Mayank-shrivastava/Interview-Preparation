package CB_Assignments.recursion;

import java.util.Scanner;

public class ReplaceAllPi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        while(n-->=1) {
            String str = scn.nextLine();
            String ans = replaceAllPi(str);
            System.out.println(ans);
        }
        scn.close();
    }

    public static String replaceAllPi(String str) {
        if(str.length() == 0 || str.length() == 1) {
            return str;
        }

        if(str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            return "3.14" + replaceAllPi(str.substring(2));
        } else {
            return str.charAt(0) + replaceAllPi(str.substring(1));
        }
    }
}
