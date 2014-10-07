package com.ipk.BlackJack;

import java.util.Scanner;

public class Dealer{
	
	// instances
	private Card[] card;
	private int cardCount;

	// methods
	
	// set instance variables
	Dealer(){
		card = new Card[10];
		cardCount = 0;
	}
	
	// add card to hand, increment cardCount
	public void getCard(Deck deck){
		card[cardCount] = deck.getCard();
		cardCount++;
	}

	// display cards
	public void displayCards(int n){
		
		System.out.print ("Dealer: ");
		for(int i = 0; i < n; i++){
			System.out.print(card[i].getCardFace());
			System.out.print(card[i].getCardSuit() + " ");
		}
		System.out.println();
	}
	
	// return requested card number
	private int getCardNumber(int n){
		return card[n].getCardNumber();
	}
	
	// return sum of cards
	public int sumOfCards(){
		
		int numOfAcesWith11Value = 0;
		int sum = 0;
		int cardValue;
		
		for(int i = 0; i < cardCount; i++){
			cardValue = getCardNumber(i);
			if(cardValue == 11){
				numOfAcesWith11Value++;
			}
			sum += cardValue;
		}
		
		while((numOfAcesWith11Value > 0) && (sum > 21)){
			sum -= 10;
			numOfAcesWith11Value--;
		}

		return sum;	
	}

	// reset card count
	public void resetCardCount(){
		cardCount = 0;
	}
	
	// get dealers card count
	public int getCardCount(){
		return cardCount;
	}
		
	// ask play if hit or stay
	public String askPlayerWhatHeWantsToDo(){
		
		Scanner kb = new Scanner(System.in);
		
		String answer;
		
		System.out.println("Would you like to hit or stay?");
		answer = kb.nextLine();
		
		return answer;
	}

	// ask if wants to play again
	public boolean askToPlayAgain(){
		
		Scanner kb = new Scanner(System.in);
		String answer;
		
		System.out.printf("\nWould you like to play again?\n");
		answer = kb.nextLine();
		
		if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")){
			return true;
		}
		else{
			return false;
		}
	}

	// ask for player's starting balance
	public void askForStartingBalance(Player player){
		
		Scanner kb = new Scanner(System.in);
		float balance;
		
		System.out.printf("Welcome to Blackjack!\nEnter starting balance: ");
		balance = kb.nextFloat();
		
		player.setBalance(balance);
	}

	// ask for bet
	public void askForBet(Player player){
		
		Scanner kb = new Scanner(System.in);
		
		float bet;
		float balance = player.getBalance();
		
		System.out.println("How much would you like to bet?");
		bet = kb.nextFloat();
		
		while(bet > balance){
			System.out.println("You do not have enough money to bet that much.");
			System.out.println("Enter another bet: ");
			bet = kb.nextFloat();
		}
		
		player.setBet(bet);	
	}
	
	// give play his winnings, increase balance
	public void increaseBalance(Player player){
		player.increaseBalance();
	}
	
	// take plays money, subtract his balance, return true if player is out of $
	public boolean subtractFromBalance(Player player){
		player.decreaseBalance();
		return (player.getBalance() == 0);	
	}
	
}
