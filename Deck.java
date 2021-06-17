package com.blackjackproject;

import java.util.*;

public class Deck {
	
	//Create array list
	private ArrayList<Card> cards;
	
	// Constructor
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	//Creates a full deck of cards 
	public void createDeck () {
		for (Suit cardSuit : Suit.values()) {
			for (Value cardValue : Value.values()) {
				this.cards.add(new Card(cardSuit, cardValue));
			}
		}
	}
	
	//Shuffles the Deck
	public void shuffleDeck() {
		//Creates new temporary deck
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		Random random = new Random();
		int randomCardIndex = 0;
		int ogDeckSize = this.cards.size();
		//Matches num of cards in new deck to original deck
		for (int i = 0; i< ogDeckSize; i++) {
			randomCardIndex = random.nextInt ((this.cards.size() - 1) + 1);
			//Adds a card to the temp deck
			tempDeck.add(this.cards.get(randomCardIndex));
			//Removes card from the original deck
			this.cards.remove(randomCardIndex);
		}
		this.cards = tempDeck;
	}
	
	public String toString() {
		String cardsOutput = "";
		for (Card aCard: this.cards){
			cardsOutput += "\n" + aCard.toString();
		}
		return cardsOutput;
	}
	
	// Methods for single card
	public void addCard (Card addCard) {
		this.cards.add(addCard);
	}
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	public void drawCard(Deck drawFrom) {
		this.cards.add(drawFrom.getCard(0));
		drawFrom.removeCard(0);
	}
	
	//Getters
	public Card getCard (int i) {
		return this.cards.get(i);
	}
	
	public int getDeckSize() {
		return this.cards.size();
	}
	public int getHandValue() {
		int totalValue = 0;
		int aces = 0;
		
		for (Card eCard : this.cards) {
			switch(eCard.getCardValue()) {
			case Two: totalValue += 2;break;
			case Three: totalValue += 3;break;
			case Four: totalValue += 4;break;
			case Five: totalValue += 5;break;
			case Six: totalValue += 6;break;
			case Seven: totalValue += 7;break;
			case Eight: totalValue += 8;break;
			case Nine: totalValue += 9;break;
			case Ten: totalValue += 10;break;
			case Jack: totalValue += 10;break;
			case Queen: totalValue += 10;break;
			case King: totalValue += 10;break;
			case Ace: totalValue += 1;break;
			};
		}
		
		for(int i = 0; i < aces; i++) {
			if(totalValue > 10) {
				totalValue += 1;
			} else {
				totalValue += 11;
			}
		}
		
		return totalValue;
	}
	
	public void returnCards (Deck returnTo) {
		int thisDeckSize = this.cards.size();
	
		// adds cards to the return Deck
		for(int i = 0; i< thisDeckSize; i++) {
			returnTo.addCard(this.getCard(i));
		}
		// Removes cards from deck
		for(int i = 0; i < thisDeckSize; i++) {
			this.removeCard(0);
		}
		
	}
	
	
	
	
	

}
	

