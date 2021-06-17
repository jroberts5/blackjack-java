package com.blackjackproject;

import java.util.*;

public class BlackJack {
	
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Creates deck
		Deck playingDeck = new Deck();
		playingDeck.createDeck();
		playingDeck.shuffleDeck();
		
		// Blackjack 
		System.out.println("Welcome to Blackjack!");
		
		//Creates decks/hands for player and dealer
		Deck playerHand = new Deck();
		Deck dealerHand = new Deck();
		
		double playerMoney = 100.00;
		
		while(playerMoney > 0) {
			
			boolean endRound = false;
			System.out.print("\nYou have $" + playerMoney + ", how much would you like to bet?   " );
			double playerBet = sc.nextDouble();
			if (playerBet > playerMoney) {
				System.out.println("You cannot bet more money than you have.");
				break;
			}
			
			//Draws two cards for both player and dealer hands
			playerHand.drawCard(playingDeck);
			playerHand.drawCard(playingDeck);
			
			dealerHand.drawCard(playingDeck);
			dealerHand.drawCard(playingDeck);
			
			while(true) {
				System.out.println("Your hand:");
				System.out.println(playerHand.toString());
				System.out.println("Your hand's value is: "+ playerHand.getHandValue());
				
				//The dealers hand
				System.out.println("\nDealer Hand: " + dealerHand.getCard(0).toString() + " and [Hidden Card]");
				
				//Asks if player wants to hit or stand
				System.out.print("\nWould you like to (1) Hit or (2) Stand?  ");
				int answer = sc.nextInt();		      
			      //If player hits
			      if (answer == 1) {
			    	  playerHand.drawCard(playingDeck);
			    	  System.out.println("You drew a: " + playerHand.getCard(playerHand.getDeckSize()-1).toString());
			    	  //If they Bust
			    	  if (playerHand.getHandValue() > 21) {
			    		  System.out.println("\nBust! Your hand is currently valued at: " + playerHand.getHandValue());
			    		  playerMoney -= playerBet;
			    		  endRound = true;
			    		  break;
			    	  }
			      }
			      if (answer == 2) {
			    	  break;
			      }
			}
			//Reveals the dealer's cards
			System.out.println("\nDealer's Cards: " + dealerHand.toString());
			if(dealerHand.getHandValue() > playerHand.getHandValue() && endRound == false) {
				System.out.println("Dealer wins. You lose");
				playerMoney -= playerBet;
				endRound = true;
			}
			while ((dealerHand.getHandValue() < 17 ) && endRound == false) {
				dealerHand.drawCard(playingDeck);
				System.out.println("\nDealer Draws:" + dealerHand.getCard(dealerHand.getDeckSize()-1).toString());
				
			}
			
			// Display dealer's hand value
			System.out.println("Dealer's hand is valued at: " + dealerHand.getHandValue());
			//Check dealers hand
			if ((dealerHand.getHandValue() > 21) && endRound == false) {
				System.out.println("Dealer busts. You win!");
				playerMoney += playerBet;
				endRound = true;
			}
	
			//Determine push
			if((playerHand.getHandValue() == dealerHand.getHandValue()) && endRound == false) {
				System.out.println("Push");
				endRound = true;
			}
			
			//Player won
			if((playerHand.getHandValue() > dealerHand.getHandValue()) && endRound == false) {
				System.out.println("\nYou win the hand!");
				playerMoney += playerBet;
				endRound = true;
			} else if (endRound == false) {
				System.out.println("\nYou lost the hand.");
				playerMoney -= playerBet;
				endRound = true;
			}
			
			//Returns cards
			playerHand.returnCards(playingDeck);
			dealerHand.returnCards(playingDeck);
			
			System.out.println("End of hand.");
			
		}
		
		
		System.out.println("Game Over, You are out of money. :(");
		
	}

}
