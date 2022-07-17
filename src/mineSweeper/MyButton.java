package mineSweeper;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    //ATTRIBUTES
    private int count=0;
    private boolean mine,flag;

    //GETTERS AND SETTERS
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
