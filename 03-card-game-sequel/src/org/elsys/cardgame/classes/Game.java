package org.elsys.cardgame.classes;

import java.util.List;

import org.elsys.cardgame.classes.Deck;
import org.elsys.cardgame.classes.Hand;
import org.elsys.cardgame.operations.Size;
import org.elsys.cardgame.api.Operation;

public class Game implements org.elsys.cardgame.api.Game {

	Deck deck;
	List<Operation> operations;
	Hand dealtHand;
	
	public Game(Deck deck) {
		this.deck = deck;
		addOperation(new Size());
	}
	
	@Override
	public Deck getDeck() {
		return deck;
	}

	@Override
	public Hand getDealtHand() {
		return dealtHand;
	}

	@Override
	public void setDealtHand(Hand hand) {
		this.dealtHand = hand;
	}

	@Override
	public void process(String command) {
		operations.stream()
			.filter(op -> op.getName() == command)
			.findFirst().get().execute(deck);
	}

	@Override
	public void addOperation(Operation operation) {
		operations.add(operation);
	}

}
