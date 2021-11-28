package CB_Assignments.recursion;

import java.util.Scanner;

public class RatChasesCheese {

    static boolean isNoAnsFound = false;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        char[][] board = new char[row][col];
        for(int i = 0; i < row; i++) {
            String input = scn.next();
            for(int j = 0; j < col; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        int[][] ansBoard = new int[row][col];
        ratChasesCheese(board, 0, 0, ansBoard);
        if(!isNoAnsFound) {
            System.out.println("NO PATH FOUND");
        }
        scn.close();
    }

    public static void ratChasesCheese(char[][] board, int row, int col, int[][] ansBoard) {
        // +ve base cases
        if(row == board.length-1 && col == board[0].length-1) {
            isNoAnsFound = true;
            ansBoard[ansBoard.length-1][ansBoard[0].length-1] = 1;
            for(int i = 0; i < ansBoard.length; i++) {
                for(int j = 0; j < ansBoard[0].length; j++) {
                    System.out.print(ansBoard[i][j] + " ");
                }
                System.out.println();
            }
            
        }

        // +ve base case
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X' || ansBoard[row][col] == 1) {
            return;
        }


        ansBoard[row][col] = 1;

        // recursive calls
        
        ratChasesCheese(board, row, col-1, ansBoard);
    
        ratChasesCheese(board, row, col+1, ansBoard);
         
        ratChasesCheese(board, row+1, col, ansBoard);
         
        ratChasesCheese(board, row-1, col, ansBoard);

        ansBoard[row][col] = 0; // undo step or backtracking
    }
}
