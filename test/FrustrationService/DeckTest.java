package FrustrationService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import FrustrationService.Card.Rank;
import FrustrationService.Card.Suit;

public class DeckTest {

	private boolean expectedCards(List<Card> cards, Integer deckCount, boolean includeJokers) {
		Map<Rank, Counter> rankCount = new HashMap<>();
		for(Rank rank:Rank.values()) {
			rankCount.put(rank, new Counter());
		}
		
		Map<Suit, Counter> suitCount = new HashMap<>();
		for(Suit suit:Suit.values()) {
			suitCount.put(suit, new Counter());
		}
		
		for(Card card:cards) {
			rankCount.get(card.getRank()).increment();
			suitCount.get(card.getSuit()).increment();
		}
		
		boolean expected = true;
		
		for(Map.Entry<Rank, Counter> entry: rankCount.entrySet()) {
			if (entry.getKey() == Rank.Joker) {
				expected = entry.getValue().getCounter() == (includeJokers ? 2 * deckCount : 0);
			}
			else {
				expected = entry.getValue().getCounter() == (4 * deckCount);
			}
			
			if (!expected) 
				break;
		}
		
		if (expected) {
			for(Map.Entry<Suit, Counter> entry: suitCount.entrySet()) {
				if (includeJokers && (entry.getKey() == Suit.Heart || entry.getKey() == Suit.Spade)) {
						expected = entry.getValue().getCounter() == 14 * deckCount; 
				}
				else {
						expected = entry.getValue().getCounter() == 13 * deckCount;
				}
				
				if (!expected)
					break;
					
			}
		}
		
		return expected;
	}
	
	private List<Card> getAllCards(Deck deck) {
		List<Card> cards = new ArrayList<>();
		while (deck.getCardCount() > 0) {
			cards.add(deck.getNextCard());
		}
		
		return cards;
	}
	
	@Test
	public void constructor_oneDeckNoJokers() {
		Deck deck = new Deck(1, false);
		
		assertEquals((Integer) 52, deck.getCardCount());
		assertTrue(expectedCards(getAllCards(deck), 1, false));
	}

	@Test
	public void constructor_oneDeckWithJokers() {
		Deck deck = new Deck(1, true);
		
		assertEquals((Integer) 54, deck.getCardCount());
		assertTrue(expectedCards(getAllCards(deck), 1, true));
	}

	@Test
	public void constructor_twoDecksWithJokers() {
		Deck deck = new Deck(2, true);
		
		assertEquals((Integer) 108, deck.getCardCount());
		assertTrue(expectedCards(getAllCards(deck), 2, true));
	}

	private boolean decksSame(List<Card> deck1, List<Card> deck2) {
		Iterator<Card> deck1Iterator = deck1.iterator();
		Iterator<Card> deck2Iterator = deck2.iterator();
		
		while(deck1Iterator.hasNext() && deck2Iterator.hasNext()) {
			Card card1 = deck1Iterator.next();
			Card card2 = deck2Iterator.next();
			
			if (!card1.equals(card2))
				return false;
		}
		
		if (deck1Iterator.hasNext() || deck2Iterator.hasNext()) {
			return false;
		}
		
		return true;
	}
	
	@Test
	public void shuffle_unshuffledSame() {
		Deck deck1 = new Deck(2, true);
		Deck deck2 = new Deck(2, true);
		
		assertTrue(decksSame(getAllCards(deck1), getAllCards(deck2)));
	}
	
	@Test
	public void shuffle() {
		Deck deck1 = new Deck(2, true);
		Deck deck2 = new Deck(2, true);
		
		deck2.shuffleDeck();
		List<Card> deck2Cards = getAllCards(deck2);
		assertTrue(expectedCards(deck2Cards, 2, true));
		
		assertFalse(decksSame(getAllCards(deck1), deck2Cards));
	}
}
