
public class Card {
    /**
     * The Number.
     */
    public int number ;
    /**
     * The Point.
     */
    public int point ;
    /**
     * The Color.
     */
    public String color ;
    /**
     * The constant ANSI_RESET.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    public Card(){
        number=0;
        point=0;
    }

    /**
     * Print.
     *
     * @param x the number of index in for
     */
    public void print(int... x){

    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets point.
     *
     * @return the point
     */
    public int getPoint() {
        return point;
    }

    /**
     * Action.
     *
     * @param board the board
     */
    public void action(Board board){

    }

}
