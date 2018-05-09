package org.elsys.cardgame.operations;

import java.util.List;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Deck;
import org.elsys.cardgame.classes.Game;
import org.elsys.cardgame.factory.GameFactory;

public class CreateWar extends DeckOperation {
	
	Game game;
	List<Card> cards;
	
	public CreateWar(Deck deck, List<Card> cards, Game game) {
		super("War", deck);
		this.game = game;
		this.cards = cards;
	}

	@Override
	public void execute() {
		try {
			game = GameFactory.createWarGame(cards);
		} catch(CardException e) {
			System.out.println(e.getError());
		}
	}

}
