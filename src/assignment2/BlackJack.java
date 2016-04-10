
package assignment2;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BlackJack {

    // used to prompt player for a game
    private static String playGamePrompt(Scanner in) {

        System.out.println("");
        System.out.print("Shall we play a game? (yes/no) ");
        return userInput(in);
    }

    // used to notify user of invalid input
    private static void incorrectInput() {

        System.out.println("");
        System.out.println("Sorry, that input was not understood.");
        System.out.println("");
    }

    // used to match given string to two possible strings and return a boolean
    private static Boolean stringMatch(String given, String match1,
            String match2) {

        if (given.equalsIgnoreCase(match1) || given.equalsIgnoreCase(match2))
            return true;
        else
            return false;
    }

    // handles input
    private static String userInput(Scanner in) {

        String result = "";
        in.useDelimiter("\n");
        try {
            result = in.nextLine();
        }
        catch (NoSuchElementException nsee) {
            incorrectInput();
        }
        catch (IllegalStateException ise) {
            System.out.println("");
            System.out
                    .println("Sorry, there was an unforeseen error.  Please restart the game.");
        }
        return result;
    }

    // used to match given string to two possible strings and return the string
    private static String userInput(String expected1, String expected2,
            Scanner in) {

        String result = "";
        try {
            result = in.nextLine();
        }
        catch (NoSuchElementException nsee) {
            System.out.println("");
        }
        catch (IllegalStateException ise) {
            System.out.println("");
            System.out
                    .println("Sorry, there was an unforeseen error.  Please restart the game.");
        }
        if (!result.equalsIgnoreCase(expected1)
                && !result.equalsIgnoreCase(expected2))
            incorrectInput();

        return result;

    }

    // add card to player's hand
    private static Player dealCard(Card c, Player p) {

        p.addCard(c);
        if (c.get_rank() == 1) {
            if (p.get_total() < 11)
                p.set_total(11);
            else
                p.set_total(1);
        } else
            if (c.get_rank() > 9) {
                p.set_total(10);
            } else
                p.set_total(c.get_rank());
        return p;
    }

    // used to determine if player will hit or stay
    private static Player playerMove(Player p, Scanner in) {

        String hitOrStay = "";
        for (int i = 0; i < p.getHand().size(); i++)
            System.out.print(p.getHand().get(i).faceCard() + " ");
        System.out.println("");
        if (p.get_total() >= 21)
            p.set_Stay(true);
        else {
            System.out.println("Total in hand: " + p.get_total());
            while (!stringMatch(hitOrStay, "hit", "stay")) {
                System.out.print("Hit or Stay? ");
                hitOrStay = userInput("hit", "stay", in);
            }
            if (hitOrStay.equalsIgnoreCase("stay"))
                p.set_Stay(true);
        }

        return p;
    }

    // used to determine if dealer will hit or stay
    private static Player dealersMove(Player p) {

        if (p.get_total() >= 17)
            p.set_Stay(true);
        else {
            p.set_Stay(false);
        }

        return p;
    }

    // Determine winner of game
    private static String whoWon(int dealerScore, int playerScore) {

        if (dealerScore > 21 && playerScore <= 21)
            return "Dealer busts, you Win! Final Score:" + playerScore
                    + " to dealer's score:" + dealerScore;
        else
            if (dealerScore < 21 && playerScore < 21
                    && dealerScore < playerScore)
                return "You win! Final Score:" + playerScore
                        + " to dealer's score:" + dealerScore;
            else
                if (dealerScore <= 21 && playerScore > 21)
                    return "You bust, Dealer wins! Final Score:" + playerScore
                            + " to dealer's score:" + dealerScore;
                else
                    if ((dealerScore == playerScore)
                            || (playerScore > 21 && dealerScore > 21))
                        return "Tie/Push! Final Score:" + playerScore
                                + " to dealer's score:" + dealerScore;
                    else
                        return "You lose! Final Score:" + playerScore
                                + " to dealer's score:" + dealerScore;

    }

    /**
     * @param args
     *            Rules: http://en.wikipedia.org/wiki/Blackjack
     */
    public static void main(String[] args) {

        blackJack();
    }

    // Game call
    public static void blackJack() {

        System.out.println("Welcome to the Blackjack game by Brent Burbidge");
        String playGame = "";
        Scanner in = new Scanner(System.in);
        while (!playGame.equalsIgnoreCase("no")) {
            playGame = playGamePrompt(in);
            while (!stringMatch(playGame, "yes", "no")) {
                playGame = playGamePrompt(in);
            }

            if (playGame.toString().equalsIgnoreCase("yes")) {
                blackJackGame(in);
            }

        }
        in.close();
    }

    private static void blackJackGame(Scanner in) {

        Deck deck = new Deck();
        Player dealer = new Player();
        Player player = new Player();

        player.set_Stay(false);
        dealer.set_Stay(false);

        while (!player.get_Stay().equals(true)
                || !dealer.get_Stay().equals(true)) {

            if (player.get_Stay().equals(false) && player.get_total() < 21) {
                if (player.getHand().size() == 0) {
                    player = dealCard(deck.DrawCard(), player);
                    player = dealCard(deck.DrawCard(), player);
                    playerMove(player, in);
                } else {
                    player = dealCard(deck.DrawCard(), player);
                    playerMove(player, in);
                }
            }

            if (dealer.get_Stay().equals(false) && dealer.get_total() < 21) {
                if (dealer.getHand().size() == 0) {
                    dealer = dealCard(deck.DrawCard(), dealer);
                    dealer = dealCard(deck.DrawCard(), dealer);
                    dealer = dealersMove(dealer);
                } else {
                    dealer = dealCard(deck.DrawCard(), dealer);
                    dealer = dealersMove(dealer);
                }

            }

            if (dealer.get_total() > 21 || player.get_total() > 21) {
                dealer.set_Stay(true);
                player.set_Stay(true);
            }

        }

        System.out.println(whoWon(dealer.get_total(), player.get_total()));
        System.out.println("");
    }

}
