package GUI;

import javax.swing.*;

import Solver.Solver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuSolver extends JFrame implements ActionListener {

    private JTextField[][] cells = new JTextField[9][9];
    private int[][] board = new int[9][9];
    private JButton solveButton = new JButton("Solve");
    JPanel gridPanel = new JPanel(new GridLayout(9, 9));

    public SudokuSolver() {
        setTitle("Sudoku Solver");
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);

        JLabel titleLabel = new JLabel("Sudoku Solver");
        titleLabel.setFont(new Font("Bell MT", Font.BOLD, 30));
        titleLabel.setBackground(Color.BLUE);
        titleLabel.setHorizontalAlignment(JTextField.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(new Font("Bell MT", Font.BOLD, 20));
                gridPanel.add(cells[i][j], BorderLayout.CENTER);
            }
        }

        add(gridPanel, BorderLayout.CENTER);

        add(solveButton, BorderLayout.SOUTH);
        solveButton.setFont(new Font("Bell MT", Font.BOLD, 20));
        solveButton.addActionListener(this);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == solveButton) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String text = cells[i][j].getText().trim();
                    int num;
                    if (!text.isEmpty()) {
                        try {
                            num = Integer.parseInt(text);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers 1-9 only.");
                            return;
                        }
                        if(num >= 1 && num <= 9)
                            board[i][j] = num;
                        else{
                            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers 1-9 only.");
                            return;
                        }
                        
                    } else
                        board[i][j] = 0;
                }
            }

            if (solveSudoku(board)) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        cells[i][j].setText(String.valueOf(board[i][j]));
                        cells[i][j].setEditable(false);
                    }
                }
            } else{
                JOptionPane.showMessageDialog(this, "No solution found!");
                this.setLocationRelativeTo(null);
            }
        }
    }

    private boolean solveSudoku(int[][] board) {
        Solver solver = new Solver(board);
        boolean solvable = solver.solveSudoku();
        board = solver.getAns();
        return solvable;
    }
}