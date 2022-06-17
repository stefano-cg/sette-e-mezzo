import java.util.*;

public class Deck {
	
	Stack<Card> stack = new Stack<>();
	
	Stack<Card> discards = new Stack<>();

	
	public Deck(){
		Stack<Card> deck = new Stack<>();
		for(Card c: Card.values()){
			deck.push(c);
		}
		Collections.shuffle(deck);
		this.stack = deck;
	}
	
	public void deal(int cards, ArrayList<Player> players){
		for(Player p: players){
			for(int i = 0; i < cards; i++){
				p.draw(this.stack);
			}
		}
	}
	
	public void deal(int cards, Player... players){
		for(Player p: players){
			for(int i = 0; i < cards; i++){
				p.draw(this.stack);
			}
		}
	}
	
	
	public Stack<Card> getStack() {
		return this.stack;
	}

	public Stack<Card> getDiscards() {
		return this.discards;
	}


	public void shuffle(){
		this.stack.addAll(discards);
		this.discards.clear();
		Collections.shuffle(this.stack);
	}
		
}
