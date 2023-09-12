import java.util.*;

public class Board {
    /**
     * The Storage card.
     */
    public ArrayList<Card> storageCard ;
    /**
     * The Players.
     */
    public ArrayList<Player> players;
    private Random random = new Random();
    /**
     * The Cnt player.
     */
    public int cntPlayer  ;
    /**
     * The Turn.
     */
    public int turn;
    /**
     * The Cur color.
     */
    public String curColor ;
    /**
     * The Aim.
     */
    public int aim ;
    /**
     * The Penalty.
     */
    public int penalty ;
    /**
     * The Cur card.
     */
    public Card curCard ;

    /**
     * Instantiates a new Board.
     *
     * @param cntPlayer the cnt player
     */
    public Board( int cntPlayer ){
        this.cntPlayer = cntPlayer;
        storageCard = new ArrayList<>();
        players = new ArrayList<>();

        aim = 1 ;
        turn = random.nextInt(cntPlayer);
        for (int i = 0 ; i<= 12 ; i++){
            RedCard x = new RedCard(i);
            storageCard.add(x) ;
            if(i > 0 ){
                RedCard y = new RedCard(i);
                storageCard.add(y) ;
            }
        }
        for (int i = 0 ; i<= 12 ; i++){
            BlueCard x = new BlueCard(i);
            storageCard.add(x) ;
            if(i > 0 ){
                BlueCard y = new BlueCard(i);
                storageCard.add(y) ;
            }
        }
        for (int i = 0 ; i<= 12 ; i++){
            GreenCard x = new GreenCard(i);
            storageCard.add(x) ;
            if(i > 0 ){
                GreenCard y = new GreenCard(i);
                storageCard.add(y) ;
            }
        }
        for (int i = 0 ; i<= 12 ; i++){
            YellowCard x = new YellowCard(i);
            storageCard.add(x) ;
            if(i > 0 ){
                YellowCard y = new YellowCard(i);
                storageCard.add(y) ;
            }
        }
        for(int i = 0; i < 4 ; i++){
            WildCard x = new WildCard(13);
            WildCard y = new WildCard(14);
            storageCard.add(x);
            storageCard.add(y);
        }
        for (int i = 0 ; i < cntPlayer ; i++ ){
            Player x = new Player(this, i) ;
            for(int j = 0 ; j < 7 ; j++ )
                x.addCard(getRandomCard());
            players.add(x);
        }
        curCard = getRandomCard();
        while (curCard.getNumber() >12){
            storageCard.add(curCard);
            curCard = getRandomCard();
        }
        curColor = curCard.color;
        if(curCard.number >=10)
            print();
        curCard.action(this);
        print();
    }

    /**
     * Get random card card.
     *
     * @return the card
     */
    public Card getRandomCard(){
        int x = random.nextInt(storageCard.size());
        Card o = storageCard.get(x);
        storageCard.remove(x);
        return o ;
    }

    /**
     * Add card.
     *
     * @param x the x
     */
    public void addCard( Card x){
        storageCard.add(x) ;
    }

    /**
     * Print.
     */
    public void print(){
        System.out.println("Player "+(turn+1) +" turn"  );
        if(aim == 1)
            System.out.println("clockwise");
        else
            System.out.println("counterclockwise");
        for(int i=1 ; i < cntPlayer ; i++)
            System.out.print("Player "+ (i+1) + " has "+ players.get(i).cards.size() + " card     ");
        System.out.println();
        System.out.println("The last card thrown");
        curCard.print();
        System.out.println("color is "+ curColor);
        System.out.println("your card : ");
        players.get(0).printCards();
        System.out.println("******************************************");
    }

    /**
     * Has win boolean.
     *
     * @return the boolean
     */
    public boolean hasWin(){
        for(Player x : players)
            if(x.cards.size() == 0){
                System.out.println("wiiiiin");
                Collections.sort(players, new Comparator<Player>() {
                    @Override
                    public int compare(Player o1, Player o2) {
                        if (o1.getscore() > o2.getscore() )
                            return 1;
                        if(o1.getscore() < o2.getscore())
                            return -1;
                        return 0;
                    }
                });
                for(int i=0 ; i < cntPlayer ; i++)
                    System.out.println((i+1)+" : "+ " Player " + (players.get(i).number+1) + " score : " + players.get(i).getscore());
                return true;
            }

        return false;
    }
}
