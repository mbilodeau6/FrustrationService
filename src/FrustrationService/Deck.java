package FrustrationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

import FrustrationService.Card.Rank;
import FrustrationService.Card.Suit;

public class Deck {
	private Stack<Card> deck;
	
	// TODO: Add a seed
	private static Random rand = new Random();
	
	private List<Card> createSingleDeck(boolean includeJokers) {
		List<Card> newDeck = new ArrayList<>();
		
		for(Suit suit: Suit.values()) {
			for(Rank rank: Rank.values()) {
				if (rank == Rank.Joker && (!includeJokers || (rank == Rank.Joker && (suit == Suit.Diamond || suit == Suit.Club)))) {
					continue;
				}
				
				newDeck.add(new Card(suit, rank));
			}
		}
		
		return newDeck;
	}
	
	public Deck(Integer deckCount, boolean includeJokers) {
		this.deck = new Stack<>();
		
		for(int i = 0; i < deckCount; i++) {
			this.deck.addAll(createSingleDeck(includeJokers));

		}
	}
	
	public Integer getCardCount() {
		return this.deck.size();
	}
	
	public Card getNextCard() {
		return deck.pop();
	}
	
	public void shuffleDeck() {
		List<Card> cardList = this.deck.stream().collect(Collectors.toList()) ;
		this.deck.clear();
		
		while(cardList.size() > 0) {
			int randValue = rand.nextInt(cardList.size());
			this.deck.push(cardList.get(randValue));
			cardList.remove(randValue);
		}
	}
}
