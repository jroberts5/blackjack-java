package com.blackjackproject;

public class Card {
	
	//Class fields
	private Suit suit;
	private Value value;
	
	
	//Constructor method - sets value provided by user
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	//getter - returns card value
	public Value getCardValue() {
		return this.value;
	}
	
	//custom toString method - returns name of card
	public String toString() {
		return this.suit.toString() + "-" + this.value.toString();
	}
	


}
