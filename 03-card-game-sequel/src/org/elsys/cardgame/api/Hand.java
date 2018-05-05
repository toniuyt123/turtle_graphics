package org.elsys.cardgame.api;

import java.util.List;
import org.elsys.cardgame.classes.Card;

public interface Hand {

	List<Card> getCards();

	int size();
}
