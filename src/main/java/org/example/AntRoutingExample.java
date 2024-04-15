import java.util.ArrayList; //import the Array List class from the package java.until
import java.util.List; //import the List class from the package java.until
import java.util.Random; //import the Random class from the package java.until

/*
simulate ants finding the shortest path between two points on a grid.
The Ant class represents an ant which moves around the grid.
The move() method determines the next position for the ant based on its current position and the grid.
The getNeighbors() method returns a list of neighboring positions around the ant's current position.
The pickNextPosition() method randomly selects one of the neighboring positions for the ant to move to.
The AntRoutingExample class is the main class where the simulation is run. It initializes the grid, creates an ant, and moves it for a certain number of steps.
 */

class Ant { // Ant Class to represent ant
    private int x; //private integer of x dimension of ant's location on grid
    private int y; //private integer of y dimension of ant's location on grid
    private int[][] grid; //Two-dimensional integer array for grid that ant walks on

    public Ant(int x, int y, int[][] grid) { //setter for ant class variables
        this.x = x; //sets private integer of x dimension to provided input
        this.y = y; //sets private integer of y dimension to provided input
        this.grid = grid; // sets private two-dimensional integer array from provided input
    }

    public void move() { //method for ant movement
        List<int[]> neighbors = getNeighbors(x, y, grid.length, grid[0].length); //array list of integer arrays that hold the neighboring positions of the ant's current position
        int[] nextPosition = pickNextPosition(neighbors); //integer array that stores the randomized position of the ant's next movement
        this.x = nextPosition[0]; //sets ant's x dimension (private integer) to x dimension of new randomized position
        this.y = nextPosition[1]; //sets ant's y dimension (private integer) to y dimension of new randomized position
    }

    private List<int[]> getNeighbors(int x, int y, int maxX, int maxY) { //private method that returns array list of integer arrays that stores all neighboring positions
        List<int[]> neighbors = new ArrayList<>(); //array list of integer arrays to hold neighboring positions
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = x + dx; //x dimension of potential neighbor position
                int newY = y + dy; //y dimension of potential neighbor position
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && !(dx == 0 && dy == 0)) { //if statement to determine if current potential neighbor position (newX, newY) is a valid position
                    neighbors.add(new int[]{newX, newY}); //if valid neighbor position, add to 'neighbors' array list
                }
            }
        }
        return neighbors; //return the array list of integer arrays that stores all neighbors of ant's current position
    }

    private int[] pickNextPosition(List<int[]> neighbors) { //private method that returns an integer array that stores the randomized position of the ant's next movement
        Random rand = new Random(); //create instance of random class
        int index = rand.nextInt(neighbors.size()); //create random integer from 0 to size of array list of integer arrays that store the neighbors of the ant's position
        return neighbors.get(index); //return the randomly selected position
    }

    public int getX() { //getter that returns ant's x dimension
        return x;
    }

    public int getY() { //getter that returns ant's y dimension
        return y;
    }
}

public class AntRoutingExample { //class to run ant movement simulation

    public static void main(String[] args) {
        int[][] grid = new int[10][10]; //create two-dimensional integer array for grid that ant walks on
        // Set obstacle at (3,3)
        grid[3][3] = 1;

        Ant ant = new Ant(0, 0, grid); //create new ant object that starts at (0,0) and will walk on the 10x10 provided grid
        int steps = 20; //create steps integer
        for (int i = 0; i < steps; i++) { // For loop that will run 20 times. Ant will move 20 times.
            ant.move(); //ant movement method is called
            System.out.println("Ant moved to: (" + ant.getX() + ", " + ant.getY() + ")"); //prints ant's new position
        }
    }
}