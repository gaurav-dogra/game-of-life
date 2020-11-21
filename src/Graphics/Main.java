package Graphics;


import gameoflife.Board;

/**
 * The swing version of the program starts here. By default this program would do one hundred thousand iterations of the grid.
 *
 * @author gaurav-dogra
 */

public class Main {

    public static void main(String[] args) {
        // Board is a grid where each cell is either true or false
        // probability is how many cells are true initially
        Board grid = new Board(20, 40, 0.5);
        GraphicsDisplay graphics = new GraphicsDisplay(grid);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How many iterations do you want ");
//        int iterations = scanner.nextInt();
//        scanner.close();

        int iterations = 100000;

        for(int i=0; i<iterations; i++) {
            graphics.display(); // print the grid
            grid.update(); // update the cells of the grid as per rules
        }
    }
}