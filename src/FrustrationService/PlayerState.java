package FrustrationService;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerState {
	private String name;
	
	private List<Card> hand;
	private List<Meld> melds;
	private Integer level;
	private Integer score;
	
	public PlayerState(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
		this.melds = new ArrayList<>();
		this.level = 1;
		this.score = 0;
	}
	
	protected PlayerState() {
		super();
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
}
