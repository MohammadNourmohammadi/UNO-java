import java.util.Scanner;

public class WildCard extends Card {
    /**
     * The constant ANSI_BLACK.
     */
    public static final String ANSI_BLACK = "\u001B[30m";

    /**
     * Instantiates a new Wild card.
     *
     * @param number the number
     */
    public WildCard(int number) {
        this.number = number;
        color = "black";
        point = 50;
    }

    @Override
    public void print(int... x) {
        if (number == 13) {
            System.out.println(ANSI_BLACK + "   $$$$$$$$$$$");
            System.out.println("   $         $");
            if (x.length > 0)
                System.out.println(x[0] + ": $   WILD  $");
            else
                System.out.println(" : $   WILD  $");
            System.out.println("   $         $");
            System.out.println("   $$$$$$$$$$$" + ANSI_RESET);
        }
        if (number == 14) {
            System.out.println(ANSI_BLACK + "   $$$$$$$$$$$");
            System.out.println("   $         $");
            if (x.length > 0)
                System.out.println(x[0] + ": $    +4   $");
            else
                System.out.println(" : $   +4    $");
            System.out.println("   $         $");
            System.out.println("   $$$$$$$$$$$" + ANSI_RESET);
        }
    }

    @Override
    public void action(Board board) {
        board.curCard = this;
        if (number == 14)
            board.penalty++;

        if(board.turn == 0){
            System.out.println("select a color");
            System.out.println(" 1: red  2: blue  3:green  4:yellow");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            while (x < 0 || x > 4) {
                System.out.println("input is not valid");
                System.out.println("select a color");
                System.out.println(" 1: red  2: blue  3:green  4:yellow");
                x = input.nextInt();
            }
            if (x == 1)
                board.curColor = "red";
            if (x == 2)
                board.curColor = "blue";
            if (x == 3)
                board.curColor = "green";
            if (x == 4)
                board.curColor = "yellow";
        }
        else
            board.curColor = board.players.get(board.turn).cards.get(0).color;
        board.turn += board.aim;
        board.turn += board.cntPlayer;
        board.turn %= board.cntPlayer;

    }

}
