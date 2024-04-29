/*
Programmers: Royal
Course:  CS212, Mr. John
Due Date: 4/2/2024
Assignment: PA 4
Problem Statement: Create a program that determines if a given maze can be solved
Data In: File name
Data Out: Maze solution 
Credits: geeksforgeeks.org, stackoverflow.com
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Method to read the maze from a file
    private static char[][] readMazeFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read in dimensions
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

    // Helper method to check if a position is valid within the maze's dimensions
    private static boolean isValidPosition(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    // Method to traverse the maze
    private static boolean exploreMaze(char[][] maze, int row, int col, int[][] directions) {
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
        outputMaze(maze);

        // Explore neighbors
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check to see if new position is valid, not a wall, or not explored
            if (isValidPosition(newRow, newCol, maze.length, maze[0].length) && maze[newRow][newCol] != '#' && maze[newRow][newCol] != 'x') {
                // Call the method recursively to explore the neighbor
                if (exploreMaze(maze, newRow, newCol, directions)) {
                    return true;
                }
            }
        }

        // There's no solution from this cell, so go back
        return false;
    }

    // Method to output the maze
    private static void outputMaze(char[][] maze) {
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

        return exploreMaze(maze, start[0], start[1], directions);
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

    // Main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            // Get user input for name of the file
            System.out.println("Enter the name of the maze file: ");
            String fileName = in.next();
            // Declare 2D array for maze details
            char[][] maze = readMazeFromFile(fileName);

            // Output the maze
            System.out.println("Maze:");
            outputMaze(maze);

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
            System.out.println("Error: " + e.getMessage());
        }
    }
}
