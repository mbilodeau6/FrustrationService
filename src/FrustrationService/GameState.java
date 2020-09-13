package FrustrationService;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameState {
	private List<Card> deck;

	private List<Card> discardPile;
	
	private Integer playerTurn;
	
	private List<PlayerState> players;
	
	public GameState(List<String> names) {
		super();
		
		this.players = new ArrayList<>();
		names.forEach(each -> this.players.add(new PlayerState(each)));
	}
	
	protected GameState() {
		super();
	}
}
