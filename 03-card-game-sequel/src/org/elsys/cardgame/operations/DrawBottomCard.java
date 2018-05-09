package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class DrawBottomCard extends DeckOperation {
	
	public DrawBottomCard(Deck deck) {
		super("draw_bottom_card", deck);
	}

	@Override
	public void execute() {
		deck.drawBottomCard().print();
	}

}
