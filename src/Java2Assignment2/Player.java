
package Java2Assignment2;

import java.util.ArrayList;

public class Player {

    private ArrayList<Card> _hand = new ArrayList<Card>();
    private int _total;
    private Boolean _stay;

    public ArrayList<Card> getHand() {

        return this._hand;
    }

    public void addCard(Card c) {

        this._hand.add(c);
    }

    public int get_total() {

        return _total;
    }

    public void set_total(int _total) {

        if (this._total == 0)
            this._total = _total;
        else
            this._total = this._total + _total;
    }

    public Boolean get_Stay() {

        return _stay;
    }

    public void set_Stay(Boolean hitOrStay) {

        this._stay = hitOrStay;
    }

    // public boolean checkPresence(int rank, int suit) {
    // for (int i = 0; i < this._hand.size(); i++) {
    // if (this._hand.get(i).get_rank() == rank
    // && this._hand.get(i).get_suit() == suit)
    // return true;
    // }
    // return false;
    // }

}
