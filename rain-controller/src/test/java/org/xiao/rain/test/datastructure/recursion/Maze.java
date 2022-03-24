package org.xiao.rain.test.datastructure.recursion;

/**
 * 迷宫回溯
 * Author: xiaojl
 * Date: 2021/11/10 22:32
 */
public class Maze {
    
    private static int lines = 8;
    private static int columns = 7;
    public static void main(String[] args) {
        int[][] maze = new int[lines][columns];

        for (int i = 0; i < columns; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        for (int i = 0; i < lines; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[4][1] = 1;
        maze[4][2] = 1;
        maze[4][3] = 1;
        maze[4][3] = 1;
        maze[3][3] = 1;
        maze[2][3] = 1;
        maze[2][2] = 1;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("=======================");

        findWay(maze, 1, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
    
    public static boolean findWay(int[][] maze, int x, int y) {
        
        if(maze[6][5] ==2) {
            return true;
        }
        
        if(maze[x][y] == 0) {
            maze[x][y] = 2;
            
            if(findWay(maze, x+1, y)) {//往下走
                return true;
            } else if(findWay(maze, x, y+1)) {//往右走
                return true;
            } else if(findWay(maze, x - 1, y)) {//往上走
                return true;
            } else if(findWay(maze, x, y-1)) {//往左走
                return true;
            } else {
                maze[x][y] = 3;
                return false;
            }
        } else {
            return false;//可能为1 可能为2 也可能为3 
        }
    }
}
