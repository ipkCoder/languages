package com.ipk.BlackJack;

public class bjGame{
	
	/*
	 *  Ian Kane
	 *  August 6, 2013
	 *  CSCI 110
	 *  Final Project - Blackjack
	 */
	
	public static void main(String[] args) {
		
		// create dealer, player, and deck
		Dealer dealer = new Dealer();
		Player player = new Player();
		Deck deck = new Deck();
		
		// shuffle deck twice
		deck.shuffle();
		deck.shuffle();
		
		boolean play = true; // if player wants to play again
		boolean zeroBalance = false;
		String nextMove; // players next move		
		int playerSum, dealerSum;
	
		dealer.askForStartingBalance(player);
		
		while(play){
		
			player.addGamePlayed();
			
			// deal cards
			dealer.getCard(deck);
			player.getCard(deck);
			dealer.getCard(deck);
			player.getCard(deck);
		
			// ask for bet
			player.displayBalance();
			dealer.askForBet(player);
			
			// show cards
			dealer.displayCards(1);
			player.displayCards();
		
			// get player's sum
			playerSum = player.sumOfCards();
		
			// see if player got 21, in this case, the game is over	
			if(playerSum == 21){
				System.out.println("Winner winner chicken dinner!!!. You got 21. Woohoo!");
				dealer.increaseBalance(player);
				player.addGameWon();
				nextMove = "game over";
			}
			else{
				
				// ask if want to hit or stay
				nextMove = dealer.askPlayerWhatHeWantsToDo();
			
				// while wants to hit
				while(nextMove.equalsIgnoreCase("hit") || nextMove.equalsIgnoreCase("h")){
				
					// give player card
					player.getCard(deck);
				
					// show cards
					dealer.displayCards(1);
					player.displayCards();
				
					// get player's sum
					playerSum = player.sumOfCards();
				
					// find out if player won, lost, or ask for next move
					if(playerSum > 21){
						System.out.println("Your sum is " + playerSum + ". You lost!");
						zeroBalance = dealer.subtractFromBalance(player);
						nextMove = "game over";
					}
					else if(playerSum < 21){
						nextMove = dealer.askPlayerWhatHeWantsToDo();
					}
					else{
						System.out.println("Winner winner chicken dinner!!!. You got 21. Woohoo!");
						dealer.increaseBalance(player);
						player.addGameWon();
						nextMove = "game over";
					}				
				}
			
				if(nextMove.equalsIgnoreCase("stay") || nextMove.equalsIgnoreCase("s")){
				
					// display dealer's cards
					System.out.println("Dealer's card has been flipped over.");
					dealer.displayCards(2);
				
					// get dealer's sum
					dealerSum = dealer.sumOfCards();
				
					// while sum < 16, dealer has to hit
					while(dealerSum <= 16){
						System.out.println("Dealer's sum is " + dealerSum + ". Has to hit.");
						dealer.getCard(deck);
						dealer.displayCards(dealer.getCardCount());
						dealerSum = dealer.sumOfCards();
					}
				
					// display cards
					player.displayCards();
					
					// find out who won
					System.out.print("Your sum is " + playerSum + ". Dealer has " + dealerSum);
					if((playerSum > dealerSum) || (dealerSum > 21)){
						System.out.println(". You won!");					
						dealer.increaseBalance(player);
						player.addGameWon();
					}
					else if(playerSum < dealerSum){
						System.out.println(". You lost!");
						zeroBalance = dealer.subtractFromBalance(player);
					}
					else{
						System.out.println(". Game is a draw!");
					}
				}
			}
			
			// display player's stats and new balance
			player.displayStats();
			player.displayBalance();
		
			// if balance is 0, game is over
			if(zeroBalance){
				System.out.println("Thanks for playing!");
				play = false;
			}
			else{
				// else ask to play again
				play = dealer.askToPlayAgain();
			
				// if yes, reset card counts to 0
				if(play){
					player.resetCardCount();
					dealer.resetCardCount();
				}
				else{
					System.out.println("Thanks for playing!");
				}
			}
		}	
	}
}
