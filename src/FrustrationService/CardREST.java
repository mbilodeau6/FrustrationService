package FrustrationService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/games")
public class CardREST {
	private static Map<String, GameState> games;
	
	// TODO: Replace with singleton that has its own rest service to manage 
	// game lifecycle.
	static {
		CardREST.games = new HashMap<>();
		
		List<String> names = Arrays.asList("Michael", "Lisa", "Terry", "Julien");
		CardREST.games.put("A",  new GameState(names));
		
		names = Arrays.asList("Michael", "Lisa");
		CardREST.games.put("B", new GameState(names));
	}
	
	@GET
	@Path("{gameId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGame(@PathParam("gameId") String gameId) {
		// TODO: Add error handling if gameId doesn't exist
		GameState gameState = games.get(gameId);
		
		return Response.ok().entity(gameState.getAsDTO()).build();
	}
}
