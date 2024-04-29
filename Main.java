import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            // Get user input for name of the file
            System.out.print("Enter the name of the maze file: ");
            String fileName = in.nextLine();
            // Declare 2D array for maze details
            char[][] maze = readMazeFromFile(fileName);

            // Output the maze
            System.out.println("Maze:");
            printMaze(maze);

            // Solve the maze
            boolean solvable = solveMaze(maze);

            // Output the result
            if (solvable) {
                System.out.println("The maze is solvable!");
            } else {
                System.out.println("The maze is not solvable.");
            }
            // Error checking to catch IOException and Exception e
        } catch (IOException e) {
            System.out.println("An error occurred while reading the maze file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } 
    }

    // Method to read the maze from a file
    private static char[][] readMazeFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read dimensions
            String[] dimensions = reader.readLine().split(" ");
            int rows = Integer.valueOf(dimensions[1]);
            int cols = Integer.valueOf(dimensions[0]);
            char[][] maze = new char[rows][cols];

            // Go line by line to read in maze layout
            for (int i = 0; i < rows; i++) {
                String line = reader.readLine();
                for (int j = 0; j < cols; j++) {
                    maze[i][j] = line.charAt(j);
                }
            }

            return maze;
        }
    }

    // Method to print the maze
    private static void printMaze(char[][] maze) {
        // Output each cell in the maze
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    // Method to solve the maze
    private static boolean solveMaze(char[][] maze) {
        //Find the start of the maze
        int[] start = findStart(maze);
        //Check to see if there is a start
        if (start == null) {
            System.out.println("No starting position 'o' found in the maze.");
            return false;
        }

        // Declare array with directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        return dfs(maze, start[0], start[1], directions);
    }

    // DFS method to solve the maze
    private static boolean dfs(char[][] maze, int row, int col, int[][] directions) {
        // Check if we reached the exit
        if (maze[row][col] == '*') {
            return true;
        }

        // Mark current cell as explored, except if it's the exit
        if (maze[row][col] != 'o') {
            maze[row][col] = 'x';
        }

        // Display the maze with explored spaces
        System.out.println("Explored Maze:");
        printMaze(maze);

        // Explore neighbors
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check to see if new position is valid, not a wall, or not explored
            if (isValidPosition(newRow, newCol, maze.length, maze[0].length) && maze[newRow][newCol] != '#' && maze[newRow][newCol] != 'x') {
                // Recursive call to explore the neighbor
                if (dfs(maze, newRow, newCol, directions)) {
                    return true;
                }
            }
        }

        // There's no solution from this cell, so go back
        return false;
    }

    // Helper method to find the starting position of the maze
    private static int[] findStart(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'o') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Helper method to check if a position is valid within the maze bounds
    private static boolean isValidPosition(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    } //end of Method
}//end of main Method
