package com.ipk.BlackJack;

public class Card {
	
	private String face;
	private int number;
	private char suit;
	
	public void setCardFace(String f){
		face = f;
	}
	
	public String getCardFace(){
		return face;
	}
	
	public void setCardNumber(int n){
		number = n;
	}
	
	public int getCardNumber(){
		return number;
	}
	
	public void setCardSuit(char s){
		suit = s;
	}
	
	public char getCardSuit(){
		return suit;
	}
	
}
