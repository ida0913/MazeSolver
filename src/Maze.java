import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
    private Square[][] maze;
    private Square start;
    private Square end;

    public boolean loadMaze(String filename) {

        File file;
        Scanner scanner;
        try {
            file = new File(filename);
            scanner = new Scanner(file);
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            this.maze = new Square[rows][cols];

            // iterate thru maze
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; cols++) {
                    maze[i][j] = new Square(i, j, scanner.nextInt());
                }
            }
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; i < maze[0].length; j++) {
                    if (maze[i][j].getType() == 2) {
                        start = maze[i][j];
                    } else if (maze[i][j].getType() == 3) {
                        end = maze[i][j];
                    }
                }
            }

            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Your fucking file isn't there");
            return false;
        }

    }

    public List<Square> getNeighbors(Square s){

        int row = s.getRow();
        int col = s.getCol();

        ArrayList<Square> neighbors = new ArrayList<>();

        if(maze[row-1][col]!= null){
            neighbors.add(maze[row-1][col]);
        }
        if(maze[row+1][col] != null){
            neighbors.add(maze[row+1][col]);
        }
        if(maze[row][col-1]!= null){
            neighbors.add(maze[row][col-1]);
        }
        if(maze[row][col+1]!= null){
            neighbors.add(maze[row][col+1]);
        }
        return neighbors;
    }

    public void reset(){
        
        for(int i = 0; i<maze.length; i++){
            for(int j = 0; j<maze[0].length; j++){
                maze[i][j].reset();
            }
        }
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }
}