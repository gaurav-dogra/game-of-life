package Console;

import gameoflife.Board;
import gameoflife.Cell;

/**
 * ConsoleDisplay is responsible for printing the board on to the java console. It also calls printBorder to print
 * a border around the board
 *
 * @author gaurav-dogra
 */
public class ConsoleDisplay {

    /**
     * display method prints the grid and it also gives calls to printBorder
     * @param board is the instance of grid passed for printing
     */

    public void display(Board board) {
        Cell[][] tempBoard = board.getBoard();
        printBorder(tempBoard[0].length); // top border

        for(int row=0; row<tempBoard.length; row++) {
            System.out.print("|");
            for(int column=0; column<tempBoard[0].length; column++) {
                if(tempBoard[row][column].getState()) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        printBorder(tempBoard[0].length); // bottom border
    }

    private void printBorder(int borderWidth) {
        String border = "+";

        for(int i=0; i<borderWidth; i++) {
            border += "-";
        }
        border += "+";
        System.out.println(border);
    }
}
