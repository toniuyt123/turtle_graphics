package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class Shuffle extends DeckOperation {
	
	public Shuffle(Deck deck) {
		super("shuffle", deck);
	}

	@Override
	public void execute() {
		deck.shuffle();
	}

}
