package mineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeper {
    //ATTRIBUTES
    private static final int NUM_MINES = 100;
    private static final int SIZE = 20;
    private static JTextField timerTextField = new JTextField(); //TextField for timer
    static JTextField totalNumberOfMinesMinusFlaggedOnes = new JTextField(); //TextField for counter
    static JButton smileyButton = new JButton();
    private static Dimension dimension;

    //ATTRIBUTES FOR THE TIMER
    private final static int delay = 1000;
    private static int seconds = 0;
    private static int minutes = 0;
    static Timer timer;

    //ACTION LISTENER FOR THE TIMER
    final static private ActionListener listenerForTimer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if(seconds < 59) {
                seconds++;
            }
            else {
                minutes++;
                seconds = 0;
            }
            timerTextField.setText(minutes + " : " + seconds);
        }
    };

    public static void main(String[] args) {
        //MAIN FRAME
        JFrame frame = new JFrame("Mine Sweeper | # of mines: "+ NUM_MINES);

        //UPPER PANEL
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());

        //BUTTON FOR SMILEY ICON
        smileyButton.setBackground(Color.LIGHT_GRAY);
        smileyButton.setIcon(new ImageIcon("src/glad64x64.png"));
        upperPanel.add(smileyButton);

        //TIMER TEXT FIELD'S SETTINGS
        timerTextField.setEditable(false);
        timerTextField.setText("Counter");
        timerTextField.setFont(new Font("SansSerif", Font.BOLD, 30));
        timerTextField.setBackground(Color.black);
        timerTextField.setForeground(Color.RED);
        upperPanel.add(timerTextField, BorderLayout.EAST);

        //COUNTER TEXT FIELD'S SETTINGS TO CALCULATE totalNumberOfMinesMinusFlaggedOnes.
        totalNumberOfMinesMinusFlaggedOnes.setEditable(false);
        totalNumberOfMinesMinusFlaggedOnes.setText("100");
        totalNumberOfMinesMinusFlaggedOnes.setFont(new Font("SansSerif", Font.BOLD, 30));
        totalNumberOfMinesMinusFlaggedOnes.setBackground(Color.black);
        totalNumberOfMinesMinusFlaggedOnes.setForeground(Color.RED);
        upperPanel.add(totalNumberOfMinesMinusFlaggedOnes, BorderLayout.WEST);

        //TIMER
        timer = new Timer(delay, listenerForTimer);
        timer.start();

        //FRAME'S SETTINGS
        frame.setLayout(new BorderLayout());
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(new MineSweeperGUI(SIZE, SIZE, NUM_MINES), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dimension.width/2-frame.getSize().width/2, dimension.height/2-frame.getSize().height/2);

        frame.setVisible(true);
    }
}
