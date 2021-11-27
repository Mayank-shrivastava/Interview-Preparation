package CB_Assignments.recursion;

import java.util.*;

public class DictionaryLarger {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String copyOfStr = new String(str);
        char[] temp = str.toCharArray();
        Arrays.sort(temp); // arrange all characters of the str in lexicographical order
        str = new String(temp);
        lexicoGreater(str, false, copyOfStr, "");
        scn.close();
    }

    public static void lexicoGreater(String str, boolean isithCharGreater, String original, String ans) {
        if(str.length() == 0) {
            if(ans.compareTo(original) > 0) {
                System.out.println(ans);
            }
            return;
        }

        // recursive calls
        for(int i = 0; i < str.length(); i++) {
            // permutation of string logic
            String ros = str.substring(0, i) + str.substring(i+1);
            char ch = str.charAt(i);
            if(isithCharGreater) {
                lexicoGreater(str, isithCharGreater, original, ans + ch);
            } else {
                if(str.charAt(i) >= str.charAt(0)) {
                    lexicoGreater(ros, isithCharGreater || ch > str.charAt(0), original, ans + ch);
                } 
            }
        }
    }
}
