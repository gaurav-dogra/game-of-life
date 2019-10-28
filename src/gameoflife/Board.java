package gameoflife;

import java.util.Random;

/** Board class represents two dimensional array of Cell objects
 * This class is common to Console Version and GUI version of the program.
 * @author gaurav-dogra
 */

public class Board {

    private Cell[][] board;

    /**
     * Board constructor creates the each cell of the board. Each cell can be either true or false
     * @param rows rows
     * @param columns columns
     * @param probability This is the probability of a cell to be true
     */
    public Board(int rows, int columns, double probability) {
        board = new Cell[rows][columns];
        //initialize each cells based on probability
        initializeCells(probability);
    }
    // initialise the cells based on probability
    public void initializeCells(double probability) {
        Random r = new Random(100);
        for(int row =0; row<board.length; row++) {
            for(int column=0; column<board[0].length; column++) {
                board[row][column] = new Cell();
                double randomNumber = r.nextDouble();
                //System.out.println(randomNumber+" <= "+probability);
                boolean newState = randomNumber <= probability; //new state based on probability
                board[row][column].setState(newState);
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }


    /**
     * Update applies Conways rules to each and every cell.
     *     Any live cell with fewer than two live neighbours dies, as if by underpopulation.
     *     Any live cell with two or three live neighbours lives on to the next generation.
     *     Any live cell with more than three live neighbours dies, as if by overpopulation.
     *     Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */
    public void update() {
        for(int row=0; row<board.length; row++) {
            for(int column=0; column < board[0].length; column++) {
                int neighboursAlive = checkNeighbours(row, column);
                //System.out.println(row+"."+column+"-"+neighboursAlive+" ");
                switch(neighboursAlive) {
                    case 3:
                        getBoard()[row][column].setState(true); // make alive
                        break;
                    case 2:
                        break; // two neighbours; do nothing

                        default:
                            getBoard()[row][column].setState(false); //kill cell
                }
            }
        }
    }

    // check how many neighbour cells are alive
    private int checkNeighbours(int row, int column) {
        int rows = board.length;
        int columns = board[0].length;
        int checkingRow;
        int checkingColumn;
        int alive=0;

        //suppose it is 3x3 grid and passed row =1 and column=1
        checkingRow = row-1;
        checkingColumn = column-1;
        if(checkingRow>=0 && checkingColumn>=0){ // 0,0 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        checkingRow = row-1;
        checkingColumn = column;
        if(checkingRow>=0){ // 0,1 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        checkingRow = row-1;
        checkingColumn = column+1;
        if(checkingRow>=0 && checkingColumn<columns){ // 0,2 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        checkingRow = row;
        checkingColumn = column-1;
        if(checkingColumn>=0){ // 1,0 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        checkingRow = row;
        checkingColumn = column+1;
        if(checkingColumn<columns){ // 1,2 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        checkingRow = row+1;
        checkingColumn = column-1;
        if(checkingRow<rows && checkingColumn>=0){ // 2,0 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        checkingRow = row+1;
        checkingColumn = column;
        if(checkingRow<rows){ // 2,1 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        checkingRow = row+1;
        checkingColumn = column+1;
        if(checkingRow<rows && checkingColumn<columns){ // 2,2 check
            if(getBoard()[checkingRow][checkingColumn].getState()) {
                alive++;
            }
        }

        return alive;

    }
}
