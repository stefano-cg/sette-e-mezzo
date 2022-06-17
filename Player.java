package card.games;

import java.util.*;

public class Player {
	
	ArrayList<Card> hand = new ArrayList<>();
	
	public Player(){
	}
	
	public void draw(Stack<Card> pile){
		hand.add(pile.pop());
	}
	
	public void discard(int pos, Stack<Card> discards){
		discards.push(this.hand.get(pos));
		this.hand.remove(pos);
	}
	
	public void discard(Card card, Stack<Card> discards){
		int pos = hand.indexOf(card);
		discards.push(hand.get(pos));
		hand.remove(pos);
	}
	
	public void discardAll(Stack<Card> discards){
		for(Card discard : this.hand){
			discards.push(discard);
		}
		this.hand.clear();
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

}
