import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
simulate ants finding the shortest path between two points on a grid.
The Ant class represents an ant which moves around the grid.
The move() method determines the next position for the ant based on its current position and the grid.
The getNeighbors() method returns a list of neighboring positions around the ant's current position.
The pickNextPosition() method randomly selects one of the neighboring positions for the ant to move to.
The AntRoutingExample class is the main class where the simulation is run. It initializes the grid, creates an ant, and moves it for a certain number of steps.
 */

class Ant {
    private int x;
    private int y;
    private int[][] grid;

    public Ant(int x, int y, int[][] grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    public void move() {
        List<int[]> neighbors = getNeighbors(x, y, grid.length, grid[0].length);
        int[] nextPosition = pickNextPosition(neighbors);
        this.x = nextPosition[0];
        this.y = nextPosition[1];
    }

    private List<int[]> getNeighbors(int x, int y, int maxX, int maxY) {
        List<int[]> neighbors = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = x + dx;
                int newY = y + dy;
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && !(dx == 0 && dy == 0)) {
                    neighbors.add(new int[]{newX, newY});
                }
            }
        }
        return neighbors;
    }

    private int[] pickNextPosition(List<int[]> neighbors) {
        Random rand = new Random();
        int index = rand.nextInt(neighbors.size());
        return neighbors.get(index);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class AntRoutingExample {

    public static void main(String[] args) {
        int[][] grid = new int[10][10];
        // Set obstacle at (3,3)
        grid[3][3] = 1;

        Ant ant = new Ant(0, 0, grid);
        int steps = 20;
        for (int i = 0; i < steps; i++) {
            ant.move();
            System.out.println("Ant moved to: (" + ant.getX() + ", " + ant.getY() + ")");
        }
    }
}