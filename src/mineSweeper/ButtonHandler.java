package mineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
    private int row,col;
    private MineGrid grid;
    private MyButton[][] myButtons;

    public ButtonHandler(int x, int y, MineGrid g, MyButton[][] buttons){
        row = x;
        col = y;
        grid = g;
        myButtons = buttons;
    }

    public void actionPerformed(ActionEvent event){
        //Checking the Mines
        if(grid.isMINE(row, col)){
            MyButton button = (MyButton)event.getSource();
            MineSweeper.smileyButton.setIcon(new ImageIcon("src/cry64x64.png"));
            MineSweeperGUI.print(grid);  //All mines and numbers behind the buttons are showed.
            MineSweeper.timer.stop();
            JOptionPane.showMessageDialog(null,"OOOPS!!"); //Game Over
            System.exit(0);
        }else{
            if(event.getSource() instanceof JButton){
                JButton button = (JButton)event.getSource();
                openZeros(row, col);
            }
        }
    }

    //METHOD FOR OPENING THE ALL NEIGHBOUR ZEROS
    private void openZeros(int row, int col) {
        if (row < 0 || row >= myButtons.length || col< 0 || col >= myButtons[0].length || myButtons[row][col].getText().length() > 0
                || !myButtons[row][col].isEnabled()) {
            return;
        } else if (myButtons[row][col].getCount() != 0) {
            myButtons[row][col].setText(myButtons[row][col].getCount() + "");
            myButtons[row][col].setEnabled(false);
        } else {
            myButtons[row][col].setEnabled(false);
            openZeros(row - 1, col);
            openZeros(row + 1, col);
            openZeros(row, col - 1);
            openZeros(row, col + 1);
        }
    }
}
