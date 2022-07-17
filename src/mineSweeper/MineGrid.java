package mineSweeper;

import java.lang.reflect.Array;
import java.util.Random;

public class MineGrid {
    private static final int MINE = -1;
    private int[][] mineInformation;

    public MineGrid(int numRows, int numCols, int numMines){
        mineInformation = new int[numRows][numCols];
        initializeCells();
        placeMines(numMines);
        setMineInformation();
    }

    private void initializeCells(){
        for(int i=0;i< mineInformation.length;i++){
            for(int j=0;j< mineInformation[0].length;j++){
                mineInformation[i][j] = 0;
            }
        }
    }

    private void placeMines(int numMines){
        Random random = new Random();
        for(int i=0;i<numMines;i++){
            int r = random.nextInt(mineInformation.length);
            int c = random.nextInt(mineInformation[0].length);
            if(mineInformation[r][c] != MINE){
                mineInformation[r][c] = MINE;
            }else{
                i--;
            }
        }
    }

    private void incrementMineCountAt(int i, int j){
        if(isInsideGrid(i, j) && !isMINE(i, j)){
            mineInformation[i][j]++;
        }
    }

    private void setMineInformation() {
        for(int i=0;i< mineInformation.length;i++){
            for(int j=0;j< mineInformation[0].length;j++){
                if(mineInformation[i][j] == MINE){
                    //previous row
                    incrementMineCountAt(i-1,j-1);
                    incrementMineCountAt(i-1,j);
                    incrementMineCountAt(i-1,j+1);

                    //left and right cells
                    incrementMineCountAt(i,j-1);
                    incrementMineCountAt(i,j+1);

                    //next row
                    incrementMineCountAt(i+1,j-1);
                    incrementMineCountAt(i+1,j);
                    incrementMineCountAt(i+1,j+1);
                }
            }
        }
    }

    private boolean isInsideGrid(int i, int j){
        return (i>=0 && i<mineInformation.length) &&
                (j>=0 && j< mineInformation[0].length);
    }

    public boolean isMINE(int i, int j){
        return mineInformation[i][j] == MINE;
    }

    public int getCellContent(int i, int j){
        return mineInformation[i][j];
    }
}
