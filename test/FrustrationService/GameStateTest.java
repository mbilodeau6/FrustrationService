package FrustrationService;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameStateTest {

	@Test
	public void constructor_empty() {
		List<String> playerNames = new ArrayList<>();
		GameState gameState = new GameState(playerNames);
		
		List<PlayerState> playerStates = TestUtilities.getPrivateFieldValue(gameState, "players");
		assertEquals(0, playerStates.size());
	}

	@Test
	public void constructor() {
		List<String> playerNames = new ArrayList<>();
		playerNames.add("John");
		playerNames.add("Mary");
		GameState gameState = new GameState(playerNames);
		
		List<PlayerState> playerStates = TestUtilities.getPrivateFieldValue(gameState, "players");
		assertEquals(2, playerStates.size());
	}

}
