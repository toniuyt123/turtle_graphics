package org.elsys.cardgame.operations;

import org.elsys.cardgame.classes.Deck;

public class DrawTopCard extends DeckOperation {

	public DrawTopCard(Deck deck) {
		super("draw_top_card", deck);
	}
	
	@Override
	public void execute() {
		System.out.println(deck.drawTopCard());
	}

}
