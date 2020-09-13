package FrustrationService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Card {
	public enum Suit {
		  Heart,
		  Diamond,
		  Club,
		  Spade
		}

	public enum Rank {
		  Two,
		  Three,
		  Four,
		  Five,
		  Six,
		  Seven,
		  Eight,
		  Nine,
		  Ten,
		  Jack,
		  Queen,
		  King,
		  Ace,
		  Joker
		}
	
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		super();
		
		this.suit = suit;
		this.rank = rank;
	}
	
	protected Card() {
		super();
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Rank getRank() {
		return this.rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
}
