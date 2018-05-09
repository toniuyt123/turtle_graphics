package org.elsys.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.elsys.cardgame.classes.Deck;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;
import org.elsys.cardgame.classes.Card;
import org.elsys.cardgame.classes.Game;
import org.elsys.cardgame.factory.DeckFactory;

public class Main {

	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		Scanner in = new Scanner(System.in);
		String rawCards = in.nextLine();
		for(String card: rawCards.trim().split("\\s+")) {
			String cardSuit = card.substring(0, 1);
			String cardRank = card.substring(1);
			for(Suit s : Suit.values()) {
				if(s.toString().equals(cardSuit)) {
					for(Rank r : Rank.values()) {
						if(r.toString().equals(cardRank)) {
							cards.add(new Card(s, r));
						}
					}
				}
			}
		}
		Game game = new Game(new Deck(cards));
		
		
		while(true) {
			String command = in.next();
			if(command.equals("quit")) {
				break;
			}
			
			game.process(command);
		}
	}

}
