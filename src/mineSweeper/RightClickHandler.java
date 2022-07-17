package mineSweeper;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightClickHandler extends MouseAdapter{
    //ATTRIBUTES
    private int row,col;
    private MineGrid grid;
    private JTextField textFieldforCounter;
    public static int redFlagCount=0;
    public static int MineCounter = 100;

    //CONSTRUCTOR
    public RightClickHandler(int x, int y, MineGrid g, JTextField textField){
        row = x;
        col = y;
        grid = g;
        textFieldforCounter = textField;
    }

    //MOUSE CLICKED METHOD FOR REDFLAGS
    public void mouseClicked(MouseEvent e){
        Icon redFlag = new ImageIcon("src/flagged60x40.png");
        MyButton button = (MyButton)e.getComponent();

        //Right clicking the mouse
        if(e.getButton() == MouseEvent.BUTTON3){
            //Showing the red flag
            if(!button.isFlag()){
                button.setIcon(redFlag);
                button.setFlag(true);
                if(grid.isMINE(row, col)){
                    System.out.println("Mine and flag +1");
                    redFlagCount++;
                    MineCounter = 100-redFlagCount;
                    textFieldforCounter.setText(Integer.toString(MineCounter));
                    System.out.println(redFlagCount);
                }
                if(MineCounter == 0){
                    MineSweeper.timer.stop();
                    JOptionPane.showMessageDialog(null,"You're genius."); //Winning the game
                    System.exit(0);
                }
            }else{
                button.setIcon(null);
                button.setFlag(false);
                if(grid.isMINE(row,col)){
                    System.out.println("Mine and flag -1");
                    redFlagCount--;
                    MineCounter++;
                    textFieldforCounter.setText(Integer.toString(MineCounter));
                    System.out.println(redFlagCount);
                }
            }
        }else if(e.getButton() == MouseEvent.BUTTON1){
            button.setIcon(null);
        }
    }
}
