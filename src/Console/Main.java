package Console;

import Graphics.GraphicsDisplay;
import gameoflife.Board;

import java.util.Scanner;

/**
 * The console version of the program starts here.
 *
 * @author gaurav-dogra
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // Board is a grid where each cell is either true or false
        // probability is how many cells are true initially
        Board grid = new Board(20, 40, 0.5);
        ConsoleDisplay console = new ConsoleDisplay();
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many iterations do you want ");
        int iterations = scanner.nextInt();
        scanner.close();

        for(int i=0; i<iterations; i++) {
            console.display(grid); // print the grid
            grid.update(); // update the cells of the grid as per rules
        }
    }
}