package mineSweeper;

import javax.swing.*;
import java.awt.*;

public class MineSweeperGUI extends JPanel {
    private MineGrid grid;
    static MyButton[][] myButtons = new MyButton[20][20]; //Created multi-dimensional array holding myButtons

    //LOWER PANEL (MAIN PANEL)
    public MineSweeperGUI(int numRows, int numCols, int numMines){
        grid = new MineGrid(numRows, numCols, numMines);

        setLayout(new GridLayout(numRows, numCols));
        for(int i=0; i<numRows;i++){
            for(int j=0; j<numCols;j++){
                MyButton button = new MyButton();
                myButtons[i][j] = button; //all buttons assigned to myButtons multi-dimensional array
                myButtons[i][j].setCount(grid.getCellContent(i,j));
                add(myButtons[i][j]);
                myButtons[i][j].addActionListener(new ButtonHandler(i, j, grid, myButtons));
                myButtons[i][j].addMouseListener(new RightClickHandler(i, j, grid, MineSweeper.totalNumberOfMinesMinusFlaggedOnes));
            }
        }
        setBackground(Color.LIGHT_GRAY);
    }

    //METHOD FOR SHOWING ALL THE MINES AND NUMBERS BEHIND THE BUTTONS WHEN THE GAME ENDS
    public static void print(MineGrid grid) {
        for (int row = 0; row < myButtons.length; row++) {
            for (int col = 0; col < myButtons[0].length; col++) {
                if (grid.isMINE(row,col)) {
                    myButtons[row][col].setIcon(new ImageIcon("src/bomb20x20.png"));
                } else {
                    myButtons[row][col].setText(myButtons[row][col].getCount() + "");
                    myButtons[row][col].setEnabled(false);
                }
            }
        }
    }
}
