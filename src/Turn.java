
import java.util.Scanner;

public class Turn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("select number of players");
        System.out.println("1: 3         2:4        3:5 ");
        int x = input.nextInt();
        while (x < 0 || x > 3) {
            System.out.println("input is not valid");
            System.out.println("select number of players");
            System.out.println("1: 3         2:4        3:5 ");
            x = input.nextInt();
        }
        x += 2;
        Board board = new Board(x);

        while (true) {
            if (board.penalty > 0) {
                if (board.players.get(board.turn).hasValid()) {
                    if (board.turn > 0)
                        for (Card z : board.players.get(board.turn).cards) {
                            if (board.players.get(board.turn).isValid(z)) {
                                board.players.get(board.turn).throwCard(z);
                                break;
                            }
                        }
                    else {
                        System.out.println("select one index of your card");
                        x = input.nextInt();
                        x--;
                        while (x < 0 || x > board.players.get(0).cards.size() || !board.players.get(0).isValid(board.players.get(0).cards.get(x))) {
                            System.out.println("this input is not valid");
                            System.out.println("select one index of your card");
                            x = input.nextInt();
                            x--;
                        }
                        board.players.get(0).throwCard(board.players.get(0).cards.get(x));
                    }
                } else {
                    System.out.println("player: " +(board.turn+1)+ " has not valid card" );
                    if (board.curCard.number == 14)
                        for (int i = 0; i < 4 * board.penalty; i++)
                            board.players.get(board.turn).addCard(board.getRandomCard());
                    else
                        for (int i = 0; i < 2 * board.penalty; i++)
                            board.players.get(board.turn).addCard(board.getRandomCard());
                    board.penalty = 0;
                    board.turn += board.aim;
                    board.turn += board.cntPlayer;
                    board.turn %= board.cntPlayer;

                }
            }
            else {
                if(board.players.get(board.turn).hasValid() == false){
                    board.players.get(board.turn).addCard(board.getRandomCard());
                    System.out.println("player: " +(board.turn+1)+ " has not valid card" );
                    board.print();
                }
                if(board.players.get(board.turn).hasValid()){
                    if (board.turn > 0)
                        for (Card z : board.players.get(board.turn).cards) {
                            if (board.players.get(board.turn).isValid(z)) {
                                board.players.get(board.turn).throwCard(z);
                                break;
                            }
                        }
                    else {
                        System.out.println("select one index of your card");
                        x = input.nextInt();
                        x--;
                        while (x < 0 || x > board.players.get(0).cards.size() || !board.players.get(0).isValid(board.players.get(0).cards.get(x))) {
                            System.out.println("this input is not valid");
                            System.out.println("select one index of your card");
                            x = input.nextInt();
                            x--;
                        }
                        board.players.get(0).throwCard(board.players.get(0).cards.get(x));

                    }
                }
                else{
                    System.out.println("player: " +(board.turn+1)+ "has not valid card" );
                    board.turn += board.aim;
                    board.turn += board.cntPlayer;
                    board.turn %= board.cntPlayer;
                }


            }
            board.print();
            if(board.hasWin())
                break;
        }


    }
}
