package org.elsys.cardgame.classes;

import java.util.List;

public class Hand implements org.elsys.cardgame.api.Hand{
	private List<Card> cards;
	
	public Hand(List<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public int size() {
		return cards.size();
	}
}
