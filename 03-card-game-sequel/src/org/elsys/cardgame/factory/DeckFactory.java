package org.elsys.cardgame.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Deck;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;

public class DeckFactory {

	public static Deck defaultWarDeck() {
		List<Card> cards = new ArrayList<Card>();
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				cards.add(new Card(s, r));
			}
		}
		
		return new Deck(cards);
	}

	public static Deck defaultSantaseDeck() {
		List<Card> result = defaultBeloteDeck().getCards().stream()
				.filter(card -> card.getRank().compareTo(Rank.EIGHT) > 0)
				.collect(Collectors.toList());
		
		return new Deck(result, 6, "Santase");
	}

	public static Deck defaultBeloteDeck() {
		List<Card> cards = new ArrayList<Card>();
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				if(r.compareTo(Rank.SIX) > 0) {
					if(r.compareTo(Rank.TEN) != 0) {
						cards.add(new Card(s, r));
					}
					if(r.compareTo(Rank.KING) == 0) {
						cards.add(new Card(s, Rank.TEN));
					}
				}
			}
		}
		
		return new Deck(cards, 8, "Belote");
	}
}
