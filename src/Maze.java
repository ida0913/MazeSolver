import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.SpinnerDateModel;

import java.util.*;

public class Maze {
    private Square[][] maze;
    private int[][] testMaze;

    public boolean loadMaze(String filename) {

        File file;
        Scanner scanner;
        try {
            file = new File(filename);
            scanner = new Scanner(file);
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            this.maze = new Square[rows][cols];
            testMaze = new int[rows][cols];
            // iterate thru maze
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int temp = scanner.nextInt();
                    maze[i][j] = new Square(i, j, temp);
                    testMaze[i][j] = temp;

                }
            }
            for (int[] x : testMaze) {
                for (int y : x) {
                    System.out.print(y + " ");
                }
                System.out.println();
            }
            scanner.close();

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Your fucking file isn't there");
            return false;
        }

    }

    public List<Square> getNeighbors(Square s) {

        int row = s.getRow();
        int col = s.getCol();
        System.out.println(row);
        System.out.println(col);

        ArrayList<Square> neighbors = new ArrayList<>();
        if (row - 1 > 0) {
            if (maze[row - 1][col] != null) {
                neighbors.add(maze[row - 1][col]);
            }
        }

        if (row + 1 < maze.length) {
            if (maze[row + 1][col] != null) {
                neighbors.add(maze[row + 1][col]);

            }
        }

        if (col - 1 > 0) {
            if (maze[row][col - 1] != null) {
                neighbors.add(maze[row][col - 1]);
            }
        }

        if (col + 1 < maze[0].length) {
            if (maze[row][col + 1] != null) {
                neighbors.add(maze[row][col + 1]);
            }
        }

    

    return neighbors;

    }

    public void reset() {

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j].reset();
            }
        }
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {

                ret += maze[i][j].toString() + " ";
            }
            ret += "\n";
        }
        return ret;
    }

    public Square getStart() {
        for (int i = 0; i < testMaze.length; i++) {
            for (int j = 0; j < testMaze[0].length; j++) {

                if (testMaze[i][j] == 2) {
                    return maze[i][j];
                }
            }
        }
        return null;
    }

    public Square getEnd() {
        for (int i = 0; i < testMaze.length; i++) {
            for (int j = 0; j < testMaze[0].length; j++) {
                if (testMaze[i][j] == 3) {
                    return maze[i][j];
                }
            }
        }
        return null;
    }

}