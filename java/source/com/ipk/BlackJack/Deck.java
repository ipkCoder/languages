package com.ipk.BlackJack;

import java.util.Random;
 
public class Deck {

	private Card[] card;
	private String[] value = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private int[] number = {2,3,4,5,6,7,8,9,10,10,10,10,11};  
	private char[] suit = {'H','D','C','S'};
	private int deckTop;
	Random r = new Random();
	
	// create new deck
	Deck(){
		
		card = new Card[52];
		deckTop = 51;
		
		// load card info
		int cardNum = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				card[cardNum] = new Card();
				card[cardNum].setCardFace(value[j]);
				card[cardNum].setCardNumber(number[j]);
				card[cardNum].setCardSuit(suit[i]);
				cardNum++;
			}
		}
	}
	
	// shuffle deck
	public void shuffle(){
		
		int x;
		for(int i = 0; i < 52; i++){
			 Card temp = card[i];
			 x = r.nextInt(52); // randomly select card to swap with
			 card[i] = card[x];
			 card[x] = temp;
		}
	}
	
	// get card from top of deck
	public Card getCard(){
		
		// get top card
		Card topCard = card[deckTop];
		
		// decrement top
		deckTop--;
		
		// see if deck is empty, if so, shuffle and reset deckTop
		if(deckTop == -1){
			shuffle();
			deckTop = 51;
		}
		
		return topCard;	
	}
	
}
