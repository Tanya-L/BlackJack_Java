import java.util.List;
import java.util.Scanner;

public class Human extends Player {

    @Override
    public void turn(List<Card> deck) {
        Scanner s = new Scanner(System.in);
        while (true) {
            // Draw a card
            Card c = deck.remove(0);
            cards.add(c);
            System.out.println("You draw card " + c);
            // Maybe we lost already
            if (score() >= 21)
                return;
            // Ask for one more
            System.out.println("Your score is " + score() + ". One more? [y]");
            String input = s.nextLine();
            // Anything that does not start with Y is a no
            if (!input.startsWith("y") && !input.startsWith("Y")) {
                break;
            }
        }
    }
}
