package CB_Assignments.recursion;

import java.util.*;

public class MazePath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        int ways = printMazePath(rows-1, cols-1, "", 0,0);
        System.out.println();
        System.out.println(ways);
        scn.close();
    }

    public static int printMazePath(int er, int ec, String ans, int cr, int cc) {
        // +base case
        if(er == cr && ec == cc && (cr == cc || cc > cr || cr > cc)) {
            System.out.print(ans + " ");
            return 1;
        }

        // -ve base
        if(cr > er || cc > ec ) {
            return 0;
        }

        int count = 0;
        // recursive calls
        // horizontal move
        count += printMazePath(er, ec, ans+"V", cr+1, cc);
        // vertical move
        count += printMazePath(er, ec, ans+"H", cr, cc+1);
        
        return count;

    }


}
