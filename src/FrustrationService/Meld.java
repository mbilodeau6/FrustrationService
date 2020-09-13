package FrustrationService;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Meld {
	private List<Card> meld;
	
	public Meld(List<Card> meld) {
		super();
		this.meld = meld.stream().collect(Collectors.toList());
	}
	
	protected Meld() {
		super();
	}
}
