import java.util.List;

public class Bot extends Player {

    @Override
    public void turn(List<Card> deck) {
        // black jack casino robots stop automatically at 16
        while (score() < 16) {
            // Draw a card
            Card c = deck.remove(0);
            cards.add(c);
            System.out.println("Bot draws card " + c);
        }
    }
}
