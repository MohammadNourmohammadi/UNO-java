import java.util.ArrayList;

public class Player {
    /**
     * The Cards.
     */
    ArrayList<Card>cards = new ArrayList<>();
    /**
     * The Board.
     */
    Board board ;
    /**
     * The Number.
     */
    public int number;

    /**
     * Instantiates a new Player.
     *
     * @param board  the board
     * @param number the number
     */
    public Player(Board board, int number){
        this.board = board;
        this.number = number;
    }

    /**
     * Print cards.
     */
    public void printCards(){
        for(int i = 0 ; i < cards.size(); i++)
            cards.get(i).print(i+1);
    }

    /**
     * Add card.
     *
     * @param x the x
     */
    public void addCard(Card x ){
        cards.add(x);
    }

    /**
     * Is valid boolean.
     *
     * @param x the x
     * @return the boolean
     */
    public boolean isValid( Card x){
        if(x.getNumber() == 13 )
            return true;
        if(x.getNumber() != 14 && (board.curCard.getNumber() == x.getNumber() || board.curColor == x.color) )
            return true;
        if (x.getNumber() != 14)
            return false;
        for(Card z : cards)
            if (z.getNumber() != 14 && isValid(z))
                return false;
        return true;
    }

    /**
     * Has valid boolean.
     *
     * @return the boolean
     */
    public boolean hasValid(){
        if(board.penalty > 0){
            if(board.curCard.number == 12)
                for (int i = 0 ; i < cards.size() ; i++ )
                    if(cards.get(i).number == 12)
                        return true;
            if (board.curCard.number == 14)
                for (int i = 0 ; i < cards.size() ; i++ )
                    if(cards.get(i).number == 14)
                        return true;
            return false;
        }
        for (int i = 0 ; i < cards.size() ; i ++ )
            if(isValid(cards.get(i)) )
                return true;
        return false;

    }

    /**
     * Throw card.
     *
     * @param x the x
     */
    public void throwCard( Card x ){
        for( Card z : cards)
            if(z.equals(x)){
                board.addCard(board.curCard);
                x.action(board);
                break;
            }
        cards.remove(x);

    }

    /**
     * Getscore int.
     *
     * @return the int
     */
    public int getscore(){
        int sum = 0 ;
        for( Card x : cards)
            sum += x.point ;
        return sum;
    }

}
