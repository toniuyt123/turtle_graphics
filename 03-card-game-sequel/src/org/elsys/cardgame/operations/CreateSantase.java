package org.elsys.cardgame.operations;

import java.util.List;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Deck;
import org.elsys.cardgame.classes.Game;
import org.elsys.cardgame.factory.GameFactory;

public class CreateSantase extends DeckOperation {
	
	Game game;
	List<Card> cards;
	
	public CreateSantase(Deck deck, List<Card> cards, Game game) {
		super("Santase", deck);
		this.game = game;
		this.cards = cards;
	}

	@Override
	public void execute() {
		try {
			game = GameFactory.createSantaseGame(cards);
		} catch(CardException e) {
			System.out.println(e.getError());
		}
	}

}