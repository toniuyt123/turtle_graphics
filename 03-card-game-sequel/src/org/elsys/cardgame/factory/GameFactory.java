package org.elsys.cardgame.factory;

import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.classes.Game;
import org.elsys.cardgame.classes.Deck;

public class GameFactory {

	public static Game createWarGame(List<Card> cards) {
		Deck warDeck = DeckFactory.defaultWarDeck();
		return new Game(warDeck);
	}

	public static Game createSantaseGame(List<Card> cards) {
		Deck santaseDeck = DeckFactory.defaultSantaseDeck();
		return new Game(santaseDeck);
	}

	public static Game createBeloteGame(List<Card> cards) {
		Deck beloteDeck = DeckFactory.defaultBeloteDeck();
		return new Game(beloteDeck);
	}
}
