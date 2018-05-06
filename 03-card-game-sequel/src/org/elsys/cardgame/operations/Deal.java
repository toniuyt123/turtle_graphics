package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class Deal extends DeckOperation {
	
	public Deal(Deck deck) {
		super("deal", deck);
	}

	@Override
	public void execute() {
		deck.deal();
	}

}
