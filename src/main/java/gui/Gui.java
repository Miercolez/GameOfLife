package gui;

import gameoflife.GameOfLife;
import gameoflife.Grid;
import gameoflife.builders.GameOfLifeBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Gui extends JFrame {
    JButton nextRoundBtn = new JButton();
    JButton[][] visualCells;
    JPanel gp = new JPanel();
    JPanel jp = new JPanel();

    public static void main(String[] args) {
        new Gui();
    }

    public Gui() {
        GameOfLife gameOfLife = buildGameOfLife();

        Grid grid = gameOfLife.getGrid();

        createVisualGrid(grid);
        layoutSetup(grid);

        nextRoundBtn.addActionListener(e -> {
            gameOfLife.renderNextRound();
            addCellsToVisualCells(grid);
        });
    }

    private GameOfLife buildGameOfLife() {
        return new GameOfLifeBuilder()
                .createGrid(50, 50)
                .addCell(25, 19)
                .addCell(25, 20)
                .addCell(25, 21)
                .addCell(25, 22)
                .addCell(25, 23)
                .addCell(25, 24)
                .addCell(25, 25)
                .addCell(25, 26)
                .addCell(25, 27)
                .addCell(25, 28)
                .addCell(25, 29)
                .addCell(25, 30)
                .addCell(25, 31)
                .createGameOfLife();
    }

    private void layoutSetup(Grid grid) {
        setSize(800, 1000);
        isLightweight();
        setLayout(new GridLayout(2, 1));
        gp.setLayout(new GridLayout(grid.rows(), grid.columns()));
        jp.setLayout(new GridLayout(5, 1));
        jp.setBorder(new EmptyBorder(10, 100, 10, 100));
        nextRoundBtn.setText("Next Round");
        jp.add(nextRoundBtn);
        add(gp);
        add(jp);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createVisualGrid(Grid grid) {
        visualCells = new JButton[grid.rows()][grid.columns()];
        for (int i = 0; i < grid.rows(); i++) {
            for (int j = 0; j < grid.columns(); j++) {
                visualCells[i][j] = new JButton();
                if (grid.getCellFromList(i + 1, j + 1).isAlive()) {
                    visualCells[i][j].setBackground(Color.black);
                } else {
                    visualCells[i][j].setBackground(Color.white);
                }
                gp.add(visualCells[i][j]);
            }
        }
    }


    private void addCellsToVisualCells(Grid grid) {
        for (int i = 0; i < grid.rows(); i++) {
            for (int j = 0; j < grid.columns(); j++) {
                if (grid.getCellFromList(i + 1, j + 1).isAlive()) {
                    visualCells[i][j].setBackground(Color.black);
                } else {
                    visualCells[i][j].setBackground(Color.white);
                }
            }
        }
    }

}