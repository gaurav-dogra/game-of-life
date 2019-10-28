package Graphics;

import gameoflife.Board;
import gameoflife.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GraphicDisplay is responsible for displaying the board in a GUI window. This class uses one Swing JButton for each
 * cell of the grid.
 *
 * @author gaurav-dogra
 */

public class GraphicsDisplay {

    private JFrame frame;
    private int rows;
    private int columns;
    private Cell[][] grid;
    private List<JButton> buttons;

    /**
     * GraphicDisplay prepares the JFrame, where the program output is displayed.
     * @param grid is a two dimensional array passed from Main function
     */

    public GraphicsDisplay(Board grid) {
        buttons = new ArrayList<>();
        frame = new JFrame("Conway's Game of Life");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.grid = grid.getBoard();
        this.rows = this.grid.length;
        this.columns = this.grid[0].length;
        frame.setLayout(new GridLayout(rows, columns));
        addButtons();
    }

    private void addButtons() { // adds button to the frame
        for(int row=0; row<rows; row++) {
            for(int column=0; column<columns; column++) {
                JButton button = new JButton();
                frame.add(button);
                buttons.add(button);

            }
        }
    }

    // Display the grid in the frame
    public void display() {
        frame.setVisible(true);
        int buttonCounter=-1;

        for(int row =0; row<rows; row++) {
            for(int column =0; column<columns; column++) {
                buttonCounter++;
                JButton currentButton = buttons.get(buttonCounter);

                if(grid[row][column].getState() && currentButton.getBackground() != Color.GREEN) { // if new state of the button is true and button not active
                    buttons.get(buttonCounter).setBackground(Color.GREEN); // turn it to green
                } else if(!grid[row][column].getState() && currentButton.getBackground()== Color.GREEN) { // if value is false and button is green
                    buttons.get(buttonCounter).setBackground(null); // turn it to no-color
                }
            }
        }
    }
}
