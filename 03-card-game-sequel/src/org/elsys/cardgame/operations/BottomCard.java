package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class BottomCard extends DeckOperation {
	
	public BottomCard(Deck deck) {
		super("bottom_card", deck);
	}

	@Override
	public void execute() {
		deck.bottomCard().print();
	}

}
