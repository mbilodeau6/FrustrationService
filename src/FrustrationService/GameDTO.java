package FrustrationService;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameDTO {
	private Integer deckCardCount;

	private Card discardTopCard;
	
	private Integer playerTurn;
	
	private List<PlayerState> players;
	
	public GameDTO(Integer deckCardCount, Card discardTopCard, Integer playerTurn, List<PlayerState> players) {
		this.deckCardCount = deckCardCount;
		this.discardTopCard = discardTopCard;
		this.playerTurn = playerTurn;
		this.players = players;
	}
	
	public GameDTO() {
		super();
	}
}
