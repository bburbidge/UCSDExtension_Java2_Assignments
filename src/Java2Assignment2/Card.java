
package Java2Assignment2;

public class Card {

    private int _rank;
    private int _suit;

    public int get_rank() {

        return _rank;
    }

    public int get_suit() {

        return _suit;
    }

    public Card(int _rank, int _suit) {

        super();
        this._rank = _rank;
        this._suit = _suit;
    }

    public String faceCard() {

        String _face = "";
        if (_rank == 1)
            _face = "ACE";
        else
            if (_rank == 2)
                _face = "TWO";
            else
                if (_rank == 3)
                    _face = "THREE";
                else
                    if (_rank == 4)
                        _face = "FOUR";
                    else
                        if (_rank == 5)
                            _face = "FIVE";
                        else
                            if (_rank == 6)
                                _face = "SIX";
                            else
                                if (_rank == 7)
                                    _face = "SEVEN";
                                else
                                    if (_rank == 8)
                                        _face = "EIGHT";
                                    else
                                        if (_rank == 9)
                                            _face = "NINE";
                                        else
                                            if (_rank == 10)
                                                _face = "TEN";
                                            else
                                                if (_rank == 11)
                                                    _face = "JACK";
                                                else
                                                    if (_rank == 12)
                                                        _face = "QUEEN";
                                                    else
                                                        if (_rank == 13)
                                                            _face = "KING";

        if (_suit == 1)
            _face = _face + " OF CLUBS";
        else
            if (_suit == 2)
                _face = _face + " OF DIAMONDS";
            else
                if (_suit == 3)
                    _face = _face + " OF HEARTS";
                else
                    if (_suit == 4)
                        _face = _face + " OF SPADES";

        return _face;
    }

}
