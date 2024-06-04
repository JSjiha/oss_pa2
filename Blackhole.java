import java.util.Random;

class Card{
	public int value;
	public int suit;
	
	public Card() {}
	public Card(int Value, int Suit) {
		this.value = Value;
		this.suit = Suit;
	}
	
	public int getGameValue() {
		int result;
		if(this.value == 'A') result = 11;
		else if(this.value == 'J' || this.value == 'Q' || this.value == 'K') result = 10;
		else result= this.value;
		return result;
	}
	
	public String getRealValue() {
		String result;
		if(this.value == 'A') result = 'A'+"";
		else if(this.value == 'J') result = 'J'+"";
		else if(this.value == 'Q') result = 'Q'+"";
		else if(this.value == 'K') result = 'K'+"";
		else if(this.value == 10) result = "10"+"";
		else result = (char)(this.value+48)+"";
		return result;
	}
	
	public char getRealSuit() {
		char result;
		if(this.suit == 'c') result = 'c';
		else if(this.suit == 'h') result = 'h';
		else if(this.suit == 'd') result = 'd';
		else result = 's';
		return result;
	}
}

class Deck{
	private Card[] deck;
	private int cardLeft;
	
	Deck(){
		int index = 0;
		this.deck = new Card[52];
		
		deck[index++] = new Card('A', 'c');
		deck[index++] = new Card('A', 'h');
		deck[index++] = new Card('A', 'd');
		deck[index++] = new Card('A', 's');
		
		for(int i=2; i<=10; i++) {
			deck[index++] = new Card(i, 'c');
			deck[index++] = new Card(i, 'h');
			deck[index++] = new Card(i, 'd');
			deck[index++] = new Card(i, 's');
		}
		
		deck[index++] = new Card('J', 'c');
		deck[index++] = new Card('J', 'h');
		deck[index++] = new Card('J', 'd');
		deck[index++] = new Card('J', 's');
		
		deck[index++] = new Card('Q', 'c');
		deck[index++] = new Card('Q', 'h');
		deck[index++] = new Card('Q', 'd');
		deck[index++] = new Card('Q', 's');
		
		deck[index++] = new Card('K', 'c');
		deck[index++] = new Card('K', 'h');
		deck[index++] = new Card('K', 'd');
		deck[index++] = new Card('K', 's');
	}
	
	public void shuffle(int seed) {
		Random random = new Random(seed);
		for(int i = 0; i < deck.length; i++) {
			int rand = (int)(random.nextInt(i+1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardLeft = 52;
	}
	
	public Card dealCard() {
		if(cardLeft == 0)
			throw new IllegalStateException("There are no cards in the deck!!");
		cardLeft--;
		return deck[cardLeft+1];
	}
	
	public void PrintDeck() {
		for(int i=0; i<52; i++) {
			System.out.print(deck[i].getRealValue() + deck[i].getRealSuit() + " ");
			if(i == 12 || i == 25 || i == 38 || i == 51) System.out.println("");
		}
		System.out.println("");
	}
}


public class Blackhole {

	public static void main(String[] args) {
		int seed = (int) (Math.random()*100);
		Deck myDeck = new Deck();
		myDeck.shuffle(seed);
		myDeck.PrintDeck();
	}

}



