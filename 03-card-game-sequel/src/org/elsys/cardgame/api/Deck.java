package org.elsys.cardgame.api;

import java.util.List;
import org.elsys.cardgame.classes.Card;

public interface Deck {

	List<Card> getCards();

	int size();

	int handSize();

	Card drawTopCard();

	Card topCard();

	Card drawBottomCard();

	Card bottomCard();

	Hand deal();

	void sort();
	
	void shuffle();

}
