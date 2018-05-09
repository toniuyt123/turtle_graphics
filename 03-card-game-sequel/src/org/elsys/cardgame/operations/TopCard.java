package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class TopCard extends DeckOperation {

	public TopCard(Deck deck) {
		super("top_card", deck);
	}
	
	@Override
	public void execute() {
		deck.topCard().print();
	}

}
