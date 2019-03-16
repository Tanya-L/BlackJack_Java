/**
 * Created by tanya on 21/06/17.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



// 4 possible card suits
enum Suit {
    Clubs, Diamonds, Hearts, Spades,
}

// card values 2 to 10, Ace, Jack, Queen, and King
enum CardValue {
    Ace(14), V2(2), V3(3), V4(4), V5(5), V6(6), V7(7), V8(8), V9(9), V10(10),
    Jack(11), Queen(12), King(13);
    public int as_int;

    private CardValue(int v) {
        as_int = v;
    }
}

// one playing card vith suit and value
class Card {
    public Suit suit;
    public CardValue value;

    // create a card
    Card(Suit s, CardValue v) {
        suit = s;
        value = v;
    }

    // print self with out a new line
    @Override
    public String toString() {
        return suit_as_string() + value_as_string();
    }

    private String value_as_string() {
        switch (value) {
            case Ace:
                return "A";
            case Jack:
                return "J";
            case Queen:
                return "Q";
            case King:
                return "K";
            default:
                return "" + value.as_int;
        }
    }

    private String suit_as_string() {
        switch (suit) {
            case Clubs:
                return "♣";
            case Diamonds:
                return "♦";
            case Hearts:
                return "♥";
            case Spades:
                return "♠";
        }
        return "?";
    }
}

abstract class Player {
    List<Card> cards;

    public abstract void turn(List<Card> deck);

    Player() {
        cards = new ArrayList<>();
    }

    public int score() {
        int result = 0;
        // count all card values first
        for (Card c : cards) {
            result += c.value.as_int;
        }
        // all aces that bring us over 21 become 1
        for (Card c : cards) {
            if (c.value == CardValue.Ace && result > 21) {
                result -= 13;
            }
        }
        return result;
    }
}

public class CardGame {
    List<Card> deck;
    Player first;
    Player second;

    // construktor
    CardGame(Player a, Player b) {
        deck = new ArrayList<>();
        first = a;
        second = b;
        // fill the deck with every card possible
        for (Suit s : Suit.values()) {
            for (CardValue v : CardValue.values()) {
                deck.add(new Card(s, v));
            }
        }
        // shuffle the game deck
        Collections.shuffle(deck);
    }

    public void start() {
        // first player has his turn
        first.turn(deck);
        int first_score = first.score();
        // check victory and loss
        if (first_score > 21) {
            System.out.println("Player 1 lost");
            return;
        }
        if (first_score == 21) {
            System.out.println("Player 1 won");
            return;
        }
        // second player has his turn
        System.out.println("Player 2 turn");
        second.turn(deck);
        int second_score = second.score();
        // check victory and loss
        if (second_score > 21) {
            System.out.println("Player 2 lost");
            return;
        }
        if (second_score == 21 || second_score == first_score) {
            System.out.println("Player 2 won");
            return;
        }
        if (first_score > second_score) {
            System.out.println("Player 1 won");
            return;
        }
        System.out.println("Player 2 won");

    }
}



