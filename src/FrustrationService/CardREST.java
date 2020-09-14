package FrustrationService;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cards")
public class CardREST {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTest() {
//		List<String> names = Arrays.asList("Michael", "Lisa", "Terry", "Julien");
		List<String> names = Arrays.asList("Michael", "Lisa");
		GameState gameState = new GameState(names);
		
		return Response.ok().entity(gameState.getAsDTO()).build();
	}
}
