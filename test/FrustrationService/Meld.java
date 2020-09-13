package FrustrationService;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "meld")
@XmlAccessorType(XmlAccessType.FIELD)
public class Meld {
	@XmlElementWrapper(name = "meld")
	@XmlElement(name = "card")
	private List<Card> meld;
	
	public Meld(List<Card> meld) {
		super();
		this.meld = meld.stream().collect(Collectors.toList());
	}
	
	protected Meld() {
		super();
	}

}
