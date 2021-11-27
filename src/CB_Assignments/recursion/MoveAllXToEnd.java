package CB_Assignments.recursion;

import java.util.Scanner;

public class MoveAllXToEnd {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String ans = moveAllXToEnd(str);
        System.out.println(ans);
        scn.close();
    }

    public static String moveAllXToEnd(String str) {
        if(str.length() == 0) {
            return str;
        }
        
       if(str.charAt(0) == 'x') {
           return moveAllXToEnd(str.substring(1)) + 'x';
       } else {
           return  str.charAt(0) + moveAllXToEnd(str.substring(1));
       }
    }
}
