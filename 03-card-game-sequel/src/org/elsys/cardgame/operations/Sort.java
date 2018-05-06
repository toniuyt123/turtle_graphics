package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class Sort extends DeckOperation {
	
	public Sort(Deck deck) {
		super("sort", deck);
	}

	@Override
	public void execute() {
		deck.sort();
	}

}
