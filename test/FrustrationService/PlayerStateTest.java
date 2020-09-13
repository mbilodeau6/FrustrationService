package FrustrationService;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerStateTest {

	@Test
	public void constructor() {
		PlayerState playerState = new PlayerState("John");
		
		String name = TestUtilities.getPrivateFieldValue(playerState, "name");
		assertEquals("John", name);
	}

}
