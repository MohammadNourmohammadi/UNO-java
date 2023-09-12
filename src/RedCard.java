
public class RedCard extends Card {
    /**
     * The constant ANSI_RED.
     */
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Instantiates a new Red card.
     *
     * @param number the number
     */
    public RedCard(int number){
        this.number = number;
        color = "red";
        if(number <= 9 )
            point = number;
        else
            point = 20;
    }
    @Override
    public void print(int... x){
        if( number <= 9){
            System.out.println(ANSI_RED+ "   $$$$$$$$$$$");
            System.out.println("   $         $");
            if( x.length> 0 )
                System.out.println(x[0]+": $    "+number+"    $");
            else
                System.out.println(" : $    "+number+"    $");
            System.out.println("   $         $");
            System.out.println("   $$$$$$$$$$$"+ANSI_RESET);
        }
        if( number == 10){
            System.out.println(ANSI_RED+ "   $$$$$$$$$$$");
            System.out.println("   $         $");
            if(x.length > 0 )
                System.out.println(x[0]+": $   SKIP  $");
            else
                System.out.println(" : $   SKIP  $");
            System.out.println("   $         $");
            System.out.println("   $$$$$$$$$$$"+ANSI_RESET);
        }
        if (number == 11){
            System.out.println(ANSI_RED+ "   $$$$$$$$$$$");
            System.out.println("   $         $");
            if (x.length > 0 )
                System.out.println(x[0]+": $ reverse $");
            else
                System.out.println(" : $ reverse $");
            System.out.println("   $         $");
            System.out.println("   $$$$$$$$$$$"+ANSI_RESET);
        }
        if (number == 12){
            System.out.println(ANSI_RED+ "   $$$$$$$$$$$");
            System.out.println("   $         $");
            if(x.length > 0 )
                System.out.println(x[0]+": $    +2   $");
            else
                System.out.println(" : $    +2   $");
            System.out.println("   $         $");
            System.out.println("   $$$$$$$$$$$"+ANSI_RESET);
        }
    }

    @Override
    public void action(Board board) {
        board.curCard = this;
        board.curColor = "red";
        if(number <= 9 )
            board.turn += board.aim ;
        if(number == 10 )
            board.turn+= (2*board.aim);
        if(number == 11){
            board.aim *= -1;
            board.turn += board.aim ;
        }
        if (number == 12){
            board.penalty ++;
            board.turn += board.aim ;
        }
        board.turn += board.cntPlayer;
        board.turn %= board.cntPlayer;
    }
}
