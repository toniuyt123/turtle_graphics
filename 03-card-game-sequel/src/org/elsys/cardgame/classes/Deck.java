package org.elsys.cardgame.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Hand;

import org.elsys.cardgame.factory.DeckFactory;

public class Deck implements org.elsys.cardgame.api.Deck {

	private List<Card> cards;
	private Deck defaultDeck;
	private int handSize;
	
	public Deck(List<Card> cards) {
		this.cards = cards;
		this.handSize = 26;
		this.defaultDeck = DeckFactory.defaultWarDeck();
	}
	
	public Deck(List<Card> cards, int handSize, String type) {
		this.cards = cards;
		this.handSize = handSize;
		if(type.equals("War")) {
			this.defaultDeck = DeckFactory.defaultWarDeck();
		} else if(type.equals("Belote")) {
			this.defaultDeck = DeckFactory.defaultBeloteDeck();
		} else if(type.equals("Santase")) {
			this.defaultDeck = DeckFactory.defaultSantaseDeck();
		}
	}
	
	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public int size() {
		return cards.size();
	}

	@Override
	public Card drawTopCard() {
		return cards.remove(0);
	}

	@Override
	public Card topCard() {
		return cards.get(0);
	}

	@Override
	public Card drawBottomCard() {
		return cards.remove(size() - 1);
	}

	@Override
	public Card bottomCard() {
		return cards.get(size() - 1);
	}
	
	@Override
	public Hand deal() {
		List<Card> drawnCards = new ArrayList<Card>();
		for(int i = 0;i < handSize();i++) {
			drawnCards.add(drawTopCard());
		}
		Hand hand = new Hand(drawnCards);
		
		return hand;
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public int handSize() {
		return handSize;
	}

	@Override
	public void sort() {
		List<Card> sorted = defaultDeck.getCards();
		
		for(Card card : sorted) {
			if(!cards.contains(card)) {
				sorted.remove(card);
			}
		}
		
		cards = sorted;
	}

}
