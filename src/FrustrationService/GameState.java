package FrustrationService;

import java.util.ArrayList;
import java.util.List;

import FrustrationService.Card.Rank;
import FrustrationService.Card.Suit;

public class GameState {
	private Deck deck;

	private List<Card> discardPile;
	
	private Integer playerTurn;
	
	private List<PlayerState> players;
	
	public GameState(List<String> names) {
		super();
		
		// TODO: Move game set up to separate method
		this.deck = new Deck(2, true);
		this.deck.shuffleDeck();
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

		for(int i = 0; i < 13; i++) {
			for (PlayerState player:this.players) {
				player.addToHand(deck.getNextCard());
			}
		}
	}
	
	protected GameState() {
		super();
	}
	
	public GameDTO getAsDTO() {
		return new GameDTO(this.deck.getCardCount(), null, this.playerTurn, this.players);
	}
}
