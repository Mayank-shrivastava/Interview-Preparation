package CB_Assignments.recursion;

import java.util.*;

public class MazePathDiagonal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        int ways = printMazePathD(rows-1, cols-1, "", 0,0);
        System.out.println();
        System.out.println(ways);
        scn.close();
    }
    public static int printMazePathD(int er,int ec, String ans, int cr, int cc) {
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
        count += printMazePathD(er, ec, ans+"V", cr+1, cc);
        // vertical move
        count += printMazePathD(er, ec, ans+"H", cr, cc+1);
        // diagonal move
        count += printMazePathD(er, ec, ans+"D", cr+1, cc+1);
        return count;

    }
}
// expected output
// VVHH VHVH VHHV VHD VDH HVVH HVHV HVD HHVV HDV DVH DHV DD
// 13

// your output
// VVHH VHVH VHHV VHD VDH HVVH HVHV HVD HHVV HDV DVH DHV DD 
// 13