package org.elsys.cardgame.factory;

import java.util.List;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Game;

public class GameFactory {

	public static Game createWarGame(List<Card> cards) {
		List<Card> defaults = DeckFactory.defaultWarDeck().getCards();
		checkCards(cards, defaults, "War");
		return new Game(DeckFactory.defaultWarDeck());
	}

	public static Game createSantaseGame(List<Card> cards) {
		List<Card> defaults = DeckFactory.defaultSantaseDeck().getCards();
		checkCards(cards, defaults, "Santase");
		return new Game(DeckFactory.defaultSantaseDeck());
	}

	public static Game createBeloteGame(List<Card> cards) {
		List<Card> defaults = DeckFactory.defaultBeloteDeck().getCards();
		checkCards(cards, defaults, "Belote");
		return new Game(DeckFactory.defaultBeloteDeck());
	}
	
	private static void checkCards(List<Card> cards, List<Card> defaults, String gameName) {
		if(defaults.size() > cards.size()) throw new CardException("ERROR: Not enough cards for " + gameName);
		
		for(Card c: defaults) {
			if(!cards.contains(c)) {
				throw new CardException("ERROR: Not enough cards for " + gameName);
			}
		}
	}
}
