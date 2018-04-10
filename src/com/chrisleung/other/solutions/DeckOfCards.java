/*
 * ServiceNow technical screen interview question
 */

package com.chrisleung.other.solutions;

import java.util.*;

/*
  Deck of playing Cards:

  Your goal is to build a deck of playing cards that meets the following requirements
  1) Cards are made up of 4 suits - Diamond, Spade, Club, and Heart
  2) Each suit has 13 Values (2,3,4,5,6,7,8,9,10, Jack, Queen, King, Ace)
  3) Each deck has 52 cards

  Example picture of a deck: http://4.bp.blogspot.com/--SaBPmsVeTk/URZtoFRMFUI/AAAAAAAAF8o/yRDV9mL0i2M/s1600/Deck+of+cards+1.jpg

  hint: Consider a couple useful methods you would need to interact with the deck.

  // Prove that the deck of cards has been constructed
  // Print out the deck of cards + total size of the deck
 */


public class DeckOfCards {

    static class Deck<T extends Card> {
        ArrayList<Card> cards;

        Deck() {
            cards = new ArrayList<Card>();
            for(Card.Suit suit : Card.Suit.values()) {
                for(Card.Face face : Card.Face.values()) {
                    cards.add(new Card(suit,face));
                }
            }
        }

        void shuffle() {
            Random r = new Random();
            int deckSize = cards.size();
            for(int i=0; i<deckSize; i++) {
                int newPosition = r.nextInt(deckSize); // 0 - 51
                Collections.swap(cards,i,newPosition);
            }
        }

        // Shuffle
        // Collect all cards
        // Deal a Card
        // Deal a hand (specify # cards we need)
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(Card card : cards) {
                sb.append(card.toString() + '\n');
            }
            return sb.toString();
        }
    }

    static class Card {
        enum Suit { DIAMONDS, SPADES, CLUBS, HEARTS };
        enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE };
        final Suit suit;
        final Face face;

        Card(Suit s, Face f) {
            suit = s;
            face = f;
        }

        // markAvailable()
        // markUnavailabe()
        // value
        @Override
        public String toString() {
            return face.toString() + " of " + suit.toString();
        }
    }

    public static void main(String[] args) {
        Deck<Card> deck = new Deck<>();
        deck.shuffle();
        System.out.println(deck.toString());
    }

}
