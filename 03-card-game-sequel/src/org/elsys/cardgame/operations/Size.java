package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class Size extends DeckOperation {
	
	public Size(Deck deck) {
		super("size", deck);
	}

	@Override
	public void execute() {
		System.out.println(deck.size());
	}

}
