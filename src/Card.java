public class Card implements Comparable<Card> {

    public static String ranks = "23456789TJQKA";
    public static String suits = "cdhs";

    private char rank;
    private char suit;

    public Card(char rank, char suit) {
        if ((ranks.indexOf(rank) == -1) || (suits.indexOf(suit) == -1))
            // The indexOf() method returns -1 only when the specified character is not in the given string
            throw new RuntimeException("can't construct card with specified rank and/or suit");

        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card other) {

        // This method is required by the Comparable interface.
        // It returns a negative integer when this card's rank is less than the other card's rank
        // It returns a positive integer when this card's rank is greater than the other card's rank
        // It returns zero when this card and the other card have the same rank

        return(Card.ranks.indexOf(this.rank) - Card.ranks.indexOf(other.rank));
    }

    public String toString() {

        return "" + this.rank + this.suit;
    }
}
