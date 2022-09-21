import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.*;
import java.awt.font.TextAttribute;

import javax.swing.*;
import java.net.URL;
import java.text.*;

import javax.swing.SpinnerDateModel;

import java.util.*;

public class Maze {
    private Square[][] maze;
    int rows;
    int cols;

    public boolean loadMaze(String filename) {

        File file;
        Scanner scanner;
        try {
            file = new File(filename);
            scanner = new Scanner(file);
            rows = scanner.nextInt();
            cols = scanner.nextInt();
            this.maze = new Square[rows][cols];
            // iterate thru maze
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int temp = scanner.nextInt();
                    maze[i][j] = new Square(i, j, temp);

                }
            }

            scanner.close();

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Your fucking file isn't there");
            return false;
        }

    }

    public List<Square> getNeighbors(Square s) {
        ArrayList<Square> neighbors = new ArrayList<Square>();
        if (s.getCol() + 1 < cols) {
            neighbors.add(maze[s.getRow()][s.getCol() + 1]);
        }
        if (s.getRow() - 1 >= 0) {
            neighbors.add(maze[s.getRow() - 1][s.getCol()]);
        }

        if (s.getCol() - 1 >= 0) {
            neighbors.add(maze[s.getRow()][s.getCol() - 1]);
        }
        if (s.getRow() + 1 < rows) {
            neighbors.add(maze[s.getRow() + 1][s.getCol()]);
        }
        return neighbors;
    }

    public void reset() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j].getType() == 0) {
                    maze[i][j] = new Square(i, j, 0);
                }
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (maze[i][j].getType() == 2) {
                    return maze[i][j];
                }
            }
        }
        return null;
    }

    public Square getEnd() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j].getType() == 3) {
                    return maze[i][j];
                }
            }
        }
        return null;
    }

}