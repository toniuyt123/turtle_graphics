package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.Operation;
import org.elsys.cardgame.classes.Deck;

public abstract class DeckOperation implements Operation {

	private String name;
	protected Deck deck;
	
	public DeckOperation(String name, Deck deck) {
		this.name = name;
		this.deck = deck;
	}
	
	@Override
	public String getName() {
		return name;
	}

}
