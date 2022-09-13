public class test {
    public static void main(String[] args) {
        Maze test = new Maze();
        System.out.println(test.loadMaze("src/mazes/maze-4"));
        System.out.println(test.toString());
        System.out.println(test.getStart());
        System.out.println(test.getEnd());
        System.out.println(test.getNeighbors(test.getStart()));
        

    }
}
