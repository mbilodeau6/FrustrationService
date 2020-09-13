package FrustrationService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
}
