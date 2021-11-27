package CB_Assignments.recursion;

import java.util.Scanner;

public class MazePathD2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // row and col are same (square matrix)
        int ways = printMazePathD2(n-1, 0,0,"");
        System.out.println();
        System.out.println(ways);
        scn.close();
    }

    public static int printMazePathD2(int end, int cr, int cc, String ans) {
        // +ve base cases
        if(cc == end && cr == end) {
            System.out.print(ans + " ");
            return 1;
        }

        // -ve base case
        if(cc > end || cr > end) {
            return 0;
        }

        int count = 0;
        // recursive calls
        // vertical move
        count += printMazePathD2(end, cr+1, cc, ans+"V");
        // horizontal move
        count += printMazePathD2(end, cr, cc+1, ans+"H");
        // diagonal move
        // this move will be taken place when the player is on the diagonal position
        if(cr == cc || (cr + cc) == end) {
           count += printMazePathD2(end, cr+1, cc+1, ans+"D");
        }

        return count;


    }
}
