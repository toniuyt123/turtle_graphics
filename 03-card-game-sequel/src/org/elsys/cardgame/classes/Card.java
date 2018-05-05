package org.elsys.cardgame.classes;

import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;

public class Card implements org.elsys.cardgame.api.Card {

	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit,Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public Suit getSuit() {
		return suit;
	}

	@Override
	public Rank getRank() {
		return rank;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!Card.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		final Card other = (Card) obj;
		if(getRank() != other.getRank() || getSuit() != other.getSuit()) {
			return false;
		}
		return true;
	}

}
