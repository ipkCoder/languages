package com.ipk.BlackJack;

public class Player {
	
	// instances
	private Card[] card;
	private int cardCount;
	private float balance;
	private float bet;
	private int gamesPlayed,gamesWon;
	
	// methods
	
	// set instance variables
	Player(){
		card = new Card[10];
		cardCount = 0;
		balance = 0;
		bet = 0;
		gamesPlayed = 0;
		gamesWon = 0;
	}
	
	// add card to hand, increment cardCount
	public void getCard(Deck deck){
		card[cardCount] = deck.getCard();
		cardCount++;
	}
	
	// display cards
	public void displayCards(){
		
		System.out.print ("Player: ");
		for(int i = 0; i < cardCount; i++){
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
	
	// set player's balance
	public void setBalance(float b){
		balance = b;
	}
	
	// return player's balance
	public float getBalance(){
		return balance;
	}
	
	// display player's balance
	public void displayBalance(){
		System.out.println("Your balance is $" + balance);
	}
	
	// increase player's balance
	public void increaseBalance(){
		balance += bet;
	}
	
	// decrease player's balance
	public void decreaseBalance(){
		balance -= bet;
	}
	
	// set bet amount
	public void setBet(float b){
		bet = b;
	}
	
	// add to games played
	public void addGamePlayed(){
		gamesPlayed++;
	}
	
	// add to games won
	public void addGameWon(){
		gamesWon++;
	}
	
	// display stats
	public void displayStats(){
		System.out.printf("\nGames played: %d  Games won: %d\n",gamesPlayed,gamesWon);
	}
	
}
