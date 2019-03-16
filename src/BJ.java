/**
 * Created by tanya-L on 27/06/17.
 */
public class BJ {

    public static void main(String args[]) {
        Player p1 = new Human();
        Player p2 = new Bot();

        // create the game (and shuffle)
        CardGame game = new CardGame(p1, p2);
        game.start ();
    }

}
