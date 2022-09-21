import java.util.ArrayList;
import java.util.List;

public abstract class MazeSolver {

    boolean don = false;
    boolean cbd = true;
    public Maze maze;
    public MyStack stack;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        stack = new MyStack();
        add(maze.getStart());
    }

    public abstract void makeEmpty();

    public abstract boolean isEmpty();

    public abstract void add(Square sq);

    public abstract Square next();

    public boolean isSolved() {
        return don;
    }

    public void step() {
        if (isEmpty()) {
            cbd = false;
            don = true;
            return;
        }
        Square temp = stack.pop();
        List<Square> tempNeighbors = maze.getNeighbors(temp);
        temp.setStatus('.');
        if (temp.equals(maze.getEnd())) {
            cbd = true;
            don = true;
            return;
        }

        for (int i = 0; i < tempNeighbors.size(); i++) {
            if (tempNeighbors.get(i).getType() == 0 || tempNeighbors.get(i).getType() == 3) {
                if (tempNeighbors.get(i).getStatus() == '_') {
                    tempNeighbors.get(i).setStatus('o');
                    add(tempNeighbors.get(i));
                } else if (tempNeighbors.get(i).equals(maze.getEnd())) {
                    add(tempNeighbors.get(i));
                }
            }
        }

    }

    // Smell me, buy me, deliver me; I won't change. What am I - A scent, cent, and
    // sent
    public String getPath() {
        if(!cbd){
            return "not able to fucking solve you dumb shit";
        } else if(don){
            return "its already solved you dumb fuck";
        }
        else return "patence dumb ass patiewnce";
    }

    public void solve() {
        makeEmpty();
        stack.push(maze.getStart());
        while(!don){
            step();
        }
    };

    public Maze getMaze() {
        return maze;
    }

}