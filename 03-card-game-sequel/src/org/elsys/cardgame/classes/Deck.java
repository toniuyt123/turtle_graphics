package org.elsys.cardgame.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Hand;

import org.elsys.cardgame.factory.DeckFactory;

public class Deck implements org.elsys.cardgame.api.Deck {

	private List<Card> cards;
	private List<Card> defaultDeck;
	private int handSize;
	
	public Deck(List<Card> cards, int handSize) {
		this.cards = cards;
		this.handSize = handSize;
		this.defaultDeck = new ArrayList<Card>();
		for(Card c: cards) {
			this.defaultDeck.add(c);
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
		checkSize(1);
		return cards.remove(0);
	}

	@Override
	public Card topCard() {
		checkSize(1);
		return cards.get(0);
	}

	@Override
	public Card drawBottomCard() {
		checkSize(1);
		return cards.remove(size() - 1);
	}

	@Override
	public Card bottomCard() {
		checkSize(1);
		return cards.get(size() - 1);
	}
	
	@Override
	public Hand deal() {
		checkSize(handSize());
		List<Card> drawnCards = new ArrayList<Card>();
		for(int i = 0;i < handSize();i++) {
			Card c = drawTopCard();
			System.out.println(c.getSuit().toString() + c.getRank());
			drawnCards.add(c);
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
		List<Card> sorted = defaultDeck;
		
		for(Card card : sorted) {
			if(!cards.contains(card)) {
				sorted.remove(card);
			}
		}
		
		cards = sorted;
	}
	
	private void checkSize(int size) {
		if(size > size()) throw new CardException();
	}

}
