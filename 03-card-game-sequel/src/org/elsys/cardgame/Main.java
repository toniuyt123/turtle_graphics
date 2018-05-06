package org.elsys.cardgame;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.factory.DeckFactory;

public class Main {

	public static void main(String[] args) {
		Deck wardeck = DeckFactory.defaultWarDeck();
		wardeck.shuffle();
		wardeck.sort();
		wardeck.deal();
		wardeck.deal();
		wardeck.topCard();
	}

}
