package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Deck;
import org.elsys.cardgame.classes.Game;
import org.elsys.cardgame.classes.Hand;

public class Deal extends DeckOperation {
	
	Game game;
	
	public Deal(Deck deck, Game game) {
		super("deal", deck);
		this.game = game;
	}

	@Override
	public void execute() {
		Hand hand = deck.deal();
		for(Card c: hand.getCards()) {
			c.print();
		}
		game.setDealtHand(hand);
	}

}
