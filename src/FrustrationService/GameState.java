package FrustrationService;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import FrustrationService.Card.Rank;
import FrustrationService.Card.Suit;

@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameState {
	private List<Card> deck;

	private List<Card> discardPile;
	
	private Integer playerTurn;
	
	private List<PlayerState> players;
	
	public GameState(List<String> names) {
		super();
		
		this.playerTurn = 0;
		this.discardPile = new ArrayList<>();
		this.discardPile.add(new Card(Suit.Heart, Rank.Ten));
		
		this.players = new ArrayList<>();
		for (String name:names) {
			PlayerState newPlayer = new PlayerState(name);
			
			for(int i=0; i < 3; i++) {
				List<Card> meldCards = new ArrayList<>();
				meldCards.add(new Card(Suit.Diamond, Rank.Seven));
				Meld meld = new Meld(meldCards);
				newPlayer.addMeld(meld);
			}
			
			this.players.add(newPlayer);
		}
		
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(Suit.Diamond, Rank.Ace));
		hand.add(new Card(Suit.Diamond, Rank.Two));
		hand.add(new Card(Suit.Heart, Rank.Three));
		hand.add(new Card(Suit.Heart, Rank.Four));
		hand.add(new Card(Suit.Spade, Rank.Five));
		hand.add(new Card(Suit.Spade, Rank.Six));
		hand.add(new Card(Suit.Club, Rank.Seven));
		hand.add(new Card(Suit.Club, Rank.Eight));
		hand.add(new Card(Suit.Diamond, Rank.Nine));
		hand.add(new Card(Suit.Diamond, Rank.Ten));
		hand.add(new Card(Suit.Heart, Rank.Jack));
		hand.add(new Card(Suit.Heart, Rank.Queen));
		hand.add(new Card(Suit.Spade, Rank.King));
		hand.add(new Card(Suit.Spade, Rank.Joker));

		this.players.get(0).setHand(hand);;
	}
	
	protected GameState() {
		super();
	}
}
