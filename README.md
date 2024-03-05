# PRODIGY_SD_04
Sudoku Solver using java and java swing

## Sudoku Solver
This project is a graphical Sudoku solver application written in Java. It allows users to input a Sudoku puzzle and then solves it for them.

## Features
1. Solves Sudoku puzzles of any difficulty level.
2. User-friendly interface with a grid for entering the puzzle and a button to solve it.
3. Input validation to ensure that only numbers 1-9 are entered.
4. Displays the solved puzzle in the grid.

## How to Use
1. Double click .jar file.
2. Enter the numbers for the Sudoku puzzle in the grid.
3. Click the "Solve" button.
4. The solved puzzle will be displayed in the grid.

## Dependencies
Java Runtime Environment (JRE)

## Code Structure
The project consists of the following packages:

1. GUI: This package contains the graphical user interface code for the Sudoku solver application.
    SudokuSolver: This class is the main class for the application. It creates the GUI components and handles user interaction.
2. Solver: This package contains the logic for solving Sudoku puzzles.
    Solver: This class implements the backtracking algorithm to solve Sudoku puzzles.

## Failure Detection
If the system is unable to solve the board in 2 minutes, it detects failure.
