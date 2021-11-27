package CB_Assignments.recursion;

import java.util.*;

public class DictionarySmaller {
    
    public static void main(String args[]) {
        // Your Code Here
		Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
		String copyOfStr = new String(str);
		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		str = new String(temp);
        List<String> list = new ArrayList<>();
        getAllPermutations(str, list, "");
        int idx = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).compareTo(copyOfStr) == 0) {
                idx = i;
                break;
            }
        }
        for(int i = 0; i < idx; i++) {
			System.out.println(list.get(i));
		}
		scn.close();
    }

	public static void getAllPermutations(String ques, List<String> list, String ans) {
		if(ques.length() == 0) {
			list.add(ans);
			return;
		}

		//recursive calls
		for(int i = 0; i < ques.length(); i++) {
			char ithchar = ques.charAt(i);
			getAllPermutations(ques.substring(0,i) + ques.substring(i+1), list, ans + ithchar);
		}
	}
    
}
