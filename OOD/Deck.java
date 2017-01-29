package OOD;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cwang on 1/28/2017.
 */

public class Deck {

    private ArrayList<Card> cards;
    private int topPos;

    Deck(boolean jokers) {
        topPos = 0;
        cards = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            for (Suit s : Suit.values()) {
                if (s.ordinal() < 4) {
                    cards.add(new Card(s, i));
                }
            }
        }
        if (jokers) {
            cards.add(new Card(Suit.Joker, 0));
            cards.add(new Card(Suit.Joker, 1));
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.size() - 1; i++) {
            Card temp = cards.get(i);
            int rand = new Random().nextInt(cards.size() - i) + i;
            cards.set(i, cards.get(rand));
            cards.set(rand, temp);
        }
    }

    public int remainingCards() {
        return cards.size() - topPos;
    }

    public boolean isEmpty() {
        return remainingCards() <= 0;
    }

    public Card dealCard() {
        if (!isEmpty()) {
            return cards.get(topPos++);
        }
        return null;
    }

    public static void main(String[] args) {
        Deck deck = new Deck(true);
        System.out.println(deck.remainingCards());
        deck.shuffle();
        while (!deck.isEmpty()) {
            System.out.println(deck.dealCard());
        }
    }
}

class Card {
    private Suit suit;
    private int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

}

enum Suit {
    Spade, Heart, Club, Diamond, Joker
}