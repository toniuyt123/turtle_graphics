package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.Operation;
import org.elsys.cardgame.classes.Deck;

public class Size implements Operation {

	private String name;
	
	public Size() {
		this.name = "size";
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute(Deck deck) {
		return;
	}

}
