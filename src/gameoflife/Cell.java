package gameoflife;

/** Each object of this class represents one cell of game-of-life.
 * This class is common to Console Display and Graphics Display versions.
 *
 * @author gaurav-dogra
 */

public class Cell {
    private boolean state;

    public Cell() {

        this.state = false;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state +" ";
    }
}
