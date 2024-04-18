# CS 212 - Programming Assignment 4
## Maze Runner

Design Due: Mon 4/15 
Final Due: Mon 4/22


## Purpose
This project will allow you to practice:
1. File Reading
2. Exception Handling
3. Linked Data Structures (Queues)


## Problem
Welcome, Theseus! You have heroically volunteered to enter Daedalus' Labyrinth to slay the Minotaur. Problem is, you
have never been great at mazes. You happen to have a map of the layout, but you need to be sure it is a solvable maze
before you venture in.

## Description
You have been give a map to the maze in the form of a text file like this:
```
6 4
...#..
.#.#*#
.#.#.#
o#....
```
The first line of the file tell you how many columns and rows are in the grid of the maze. The rest of the file is a
drawing of the maze. The symbols used are as follows:
* . - an empty floor
* \# - a wall
* \* - the exit of the maze
* o - the entrance of the maze

You need to right a program that asks the user for the name of a file and then tells the user whether the maze can be
solved. If it can, you should show the user all the paths you explored to determine this. For eaxmple, the above might
look like:
```
xxx#..
x#x#*#
x#x#x#
o#xxxx
```
Here, x's denote explored spaces.

## Requirements
Your code should roughly use the following algorithm to determine whether the maze is solvable:
1. Create an empty queue
2. Put the location of the entrance on the queue
3. While the queue is not empty
   1. Take a spot off the queue
   2. If the spot is the exit
      1. The maze is solvable, note success
   3. Otherwise,
      1. For each immediate (i.e., not diagonal) neighbor
         1. If you have never visited the neighbor and the neighbor is not a wall
            1. Add th neighbor to the queue
4. you explored everything you could reach and did not find the exit, note failure

Extra Credit: Implement your code without using Java's Queue class; build your own linked Queue.

## Design
You will need at least the following classes:
1. `Node` - to represent a node in the linked structure
2. `Queue` - to represent the queue
3. `Main` - to run the program and deal with user input
4. `Room` - to track the rooms in the maze that your push to the Queue

You can use a fifth class, `Maze`, to manage the maze, though you may just do this in your `Main` class. In
either event, the maze is most easily stored in a 2D array of `Room`s.

### Queue class
We will talk about this soon, but in case you want to get started before we do. A `Queue` is a special kind of `List`
which, like the `Stack` from class, you can only add and remove from in a specific place. In this case, you add to the
end, called `enqueue` and remove from the start, called `dequeue`. A better solution will be able to do both in O(1)
time.

## Testing
You have been provided with 5 testing files. Feel free to create your own as well.

## Submission

### Part 1, Design
Due: 4/15 11:00 PM

To GitHub, submit:
1. design.txt containing:
   * An algorithm for reading the maze from a file
   * The design of the Queue class

To Moodle
1. To Moodle
    * A Link to your GitHub Repo


### Part 2, Final
Due: 4/22 11:00 PM

##To GitHub, submit :
1. A revised design.txt
2. All .java files needed to compile and run your code

To Moodle
* To Moodle
    * A Link to your GitHub Repo
    * A individual reflection (no word limit) typed inside the moodle submission box using the following format and addressing the following questions:

        * 1. Objective: What were you supposed to learn/accomplish?
        * 2. Procedure: What steps were followed and what techniques did you use to solve the problem? What were the Key concepts explored?
        * 3. Results: What was the program's outcome? Was it unexpected? 
        * 4. Reflection:
          	5. Were 2D arrays a little more comfortable for you this time?
          	6. Would you have liked a more complex look at linked structures, or was the simple `Queue` good enough?
          	7. Were you able to follow the maze solving algorithm? There is another using a Stack that actually solves the maze, but the algorithm is slightly more difficult. 			Would you have preferred that?
          	8. Which was your favorite PA of the semester?
          	9. What challenges did you encounter? What would you do differently, given what you know now?
          	10. Do you think you learned what you were supposed to learn for this PA? 




Reminders: 
* You should **NOT** commit any extranious files (the out directory, the .idea directory, etc.). 
* You **SHOULD** use proper comments and white space including JavaDoc and header comments
* You should commit your work often and use meaningful commit messages 






