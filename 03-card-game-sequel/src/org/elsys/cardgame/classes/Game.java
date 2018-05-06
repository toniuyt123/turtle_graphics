package org.elsys.cardgame.classes;

import java.util.List;

import org.elsys.cardgame.classes.Deck;
import org.elsys.cardgame.classes.Hand;
import org.elsys.cardgame.operations.BottomCard;
import org.elsys.cardgame.operations.Deal;
import org.elsys.cardgame.operations.DrawBottomCard;
import org.elsys.cardgame.operations.DrawTopCard;
import org.elsys.cardgame.operations.Shuffle;
import org.elsys.cardgame.operations.Size;
import org.elsys.cardgame.operations.Sort;
import org.elsys.cardgame.operations.TopCard;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Operation;

public class Game implements org.elsys.cardgame.api.Game {

	Deck deck;
	List<Operation> operations;
	Hand dealtHand;
	
	public Game(Deck deck) {
		this.deck = deck;
		addOperation(new Size(this.deck));
		addOperation(new DrawTopCard(this.deck));
		addOperation(new DrawBottomCard(this.deck));
		addOperation(new TopCard(this.deck));
		addOperation(new BottomCard(this.deck));
		addOperation(new Shuffle(this.deck));
		addOperation(new Sort(this.deck));
		addOperation(new Deal(this.deck));
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
		try {
			operations.stream()
			.filter(op -> op.getName() == command)
			.findFirst().get().execute();
		} catch (CardException e) {
			System.out.println("ERROR: Not enough cards in deck");
		}
	}

	@Override
	public void addOperation(Operation operation) {
		operations.add(operation);
	}

}
