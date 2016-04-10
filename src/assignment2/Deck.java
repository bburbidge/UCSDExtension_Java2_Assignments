
package assignment2;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    public ArrayList<Card> _fullDeck = new ArrayList<Card>();
    private Random shuffle = new Random();

    public Deck() {

        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                _fullDeck.add(new Card(rank, suit));
            }
        }
    }

    // private ArrayList<Card> getFullDeck() {
    // return this._fullDeck;
    // }

    public Card DrawCard() {

        int cardPosition = shuffle.nextInt(this._fullDeck.size() + 1);
        return this._fullDeck.remove(cardPosition);
    }

    // public void printDeck() {
    // for (int i = 0; i < this._fullDeck.size(); i++) {
    // System.out.println(this.getFullDeck().get(i).faceCard());
    // }
    // }
}
