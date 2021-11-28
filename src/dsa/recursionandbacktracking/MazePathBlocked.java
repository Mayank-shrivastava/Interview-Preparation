package dsa.recursionandbacktracking;

public class MazePathBlocked {
    public static void main(String[] args) {
        int[][] maze = {{0,1,0,0},{0,0,0,0},{0,1,0,0},{0,1,1,0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        printMazePathBlocked(maze, 0, 0, "", visited);


    }

    // Bactracking intro: we can move to all 4 position from the single cell
    public static void printMazePathBlocked(int[][] maze, int cr, int cc, String ans, boolean[][] visited) {
        // +ve base case
        if(cr == maze.length-1 && cc == maze[0].length - 1) {
            System.out.println(ans);
            return;
        }

        // -ve base case
        if(cr < 0 || cc < 0 || cr >= maze.length || cc >= maze[0].length || visited[cr][cc] || maze[cr][cc] == 1) {
            return;
        }


        visited[cr][cc] = true;

        // recursive calls
        // top
        printMazePathBlocked(maze, cr-1, cc, ans + "T", visited);
        // down
        printMazePathBlocked(maze, cr+1, cc, ans + "D", visited);
        // left
        printMazePathBlocked(maze, cr, cc-1, ans + "L", visited);
        // right
        printMazePathBlocked(maze, cr, cc+1, ans + "R", visited);

        visited[cr][cc] = false; // undo the work
    }
}
