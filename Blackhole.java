import java.util.Random;
import java.util.Scanner;

class Card{
	public int value;
	public int suit;
	
	public Card() {}
	public Card(int Value, int Suit) {
		this.value = Value;
		this.suit = Suit;
	}
	
	//카드의 Value값을 숫자로 변환
	public int getGameValue() {
		int result;
		if(this.value == 'A') result = 1;
		else if(this.value == 'J') result = 11;
		else if(this.value == 'Q') result = 12;
		else if(this.value == 'K') result = 13;
		else result= this.value;
		return result;
	}
	
	//카드의 Value값을 문자로 변환
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
	
	//카드의 Suit값을 문자로 변환
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
	private int cardsLeft;
	
	//Constructor를 이용해서 덱에 카드 52장을 넣음
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
	
	//Random object를 이용해서 덱에 있는 카드를 섞음
	public void shuffle(int seed) {
		Random random = new Random(seed);
		for(int i = deck.length-1; i > 0; i--) {
			int rand = (int)(random.nextInt(i+1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardsLeft = 52;
	}
	
	//카드를 나눠줌 (카드가 없을 경우 Exception발생)
	public Card dealCard() {
		if(cardsLeft == 0)
			throw new IllegalStateException("There are no cards in the deck!!");
		cardsLeft--;
		return deck[cardsLeft];
	}
	
	//덱의 카드를 출력함 (Debug용도)
	public void PrintDeck() {
		for(int i=0; i<52; i++) {
			System.out.print(deck[i].getRealValue() + deck[i].getRealSuit() + " ");
			if(i == 12 || i == 25 || i == 38 || i == 51) System.out.println("");
		}
		System.out.println("");
	}
}

class NotBlackholeCards {
	public Card[] Cards;
	public int numOFCards;
	
	//BlackHole이 아닌 일반 카드 더미(총 3개의 카드로 구성됨)
	NotBlackholeCards(){
		Cards = new Card[3];
		for(int i=0; i<3; i++)
			Cards[i] = new Card();
		numOFCards = 0;
	}
	
	//카드의 개수를 파악하여 모든 카드를 출력
	public void printAllCards() {
		if(numOFCards == 0) System.out.println("No card");
		else if(numOFCards == 1) System.out.println("Top: " + Cards[numOFCards-1].getRealValue() + Cards[numOFCards-1].getRealSuit());
		else {
			
			System.out.print("Top: " + Cards[numOFCards-1].getRealValue() + Cards[numOFCards-1].getRealSuit());
			if(Cards[numOFCards-1].getGameValue() == 10) System.out.print(", Under: ");
			else System.out.print(",  Under: ");
			
			for(int i=numOFCards-2; i>=0; i--) {
				System.out.print(Cards[i].getRealValue() + Cards[i].getRealSuit());
				if(i != 0) {
					if(Cards[i].getGameValue() == 10) System.out.print(", ");
					else System.out.print(",  ");
				}
				else System.out.println("");

			}
		}
	}
}

class BlackholeAndCards{
	public Card[] Cards;
	public int numOFCards;
	
	//게임 중 점점 BlackHole에 카드가 쌓이게 됨
	BlackholeAndCards() {
		Cards = new Card[52];
		for(int i=0; i<52; i++)
			Cards[i] = new Card();
		numOFCards = 0;
	}
	
	public void printAllCards() {
		System.out.println("Blackhole: ");
		for(int i=0; i<numOFCards; i++) {
			System.out.print(Cards[i].getRealValue() + Cards[i].getRealSuit());
			if(i != numOFCards-1) System.out.print(", ");
			else System.out.println("");	
		}
		System.out.println("");
	}
}

public class Blackhole {

	public static void main(String[] args) {
		
		int seed = (int) (Math.random()*100);
		int AllCards = 51;
		int CanConnect = 0;
		
		Deck myDeck = new Deck();
		myDeck.shuffle(seed);
		//myDeck.PrintDeck();

		//Setting the Game(dummy와 BlackHole 생성)
		NotBlackholeCards[] NotBlackhole = new NotBlackholeCards[17];
		BlackholeAndCards Blackhole = new BlackholeAndCards();
		
		for(int i=0; i<17; i++){
			NotBlackhole[i] = new NotBlackholeCards();
			for(int k=0; k<3; k++){
				NotBlackhole[i].Cards[k] = myDeck.dealCard();
				NotBlackhole[i].numOFCards++;
			}
		}
		for(int i=0; i<52; i++)
			Blackhole.Cards[i] = new Card();
		Blackhole.Cards[0] = myDeck.dealCard();
		Blackhole.numOFCards++;
		
		System.out.println("Game Setting");
		System.out.println("");
		System.out.println("--------------------------------");
		Blackhole.printAllCards();
		
		System.out.println("[Dummy]"); 
		for(int i=0; i<17; i++) {
			if(i<9) System.out.print((i+1) + ":  ");
			else System.out.print((i+1) + ": ");
			NotBlackhole[i].printAllCards();
		}
		System.out.println("--------------------------------");
		System.out.println("");
		
		
		//Starting the game
		System.out.println("Game Start!!");
		System.out.println("--------------------------------");
		
		
		Blackhole bh = new Blackhole();
		
		//Game logic(블랙홀에 가장 위에 있는 카드와 숫자가 하나 차이나면 연결 가능, 카드의 문자는 고려 X)
		while(AllCards > 0) {
			
			//블랙홀에 연결 가능한 카드가 존재하는지 확인
			for(int i=0; i<17; i++) {
				if(NotBlackhole[i].numOFCards != 0) {
					if(Math.abs(NotBlackhole[i].Cards[NotBlackhole[i].numOFCards-1].getGameValue() - Blackhole.Cards[Blackhole.numOFCards-1].getGameValue()) == 1)
						CanConnect = 1;
				}
			}
			//블랙홀에 연결 가능한 카드가 단 한 개도 없는 경우 -> 게임 패배
			if(CanConnect == 0) { 
				System.out.println("[You Lose]: No cards in the dummys can be connected to BlackHole!!");
				break;
			}
			CanConnect = 0;
			
			//incorrect input에 대해 예외 처리 + 블랙홀에 연결 가능한 카드가 특정 더미 안에 있을 경우, 그 카드를 블랙홀에 연결
			try {
				System.out.print("Choose a number of dummy(1~17) for connecting: ");
				Scanner scn = new Scanner(System.in);
				int input = scn.nextInt();
				bh.InputExeptionCheck(Blackhole, NotBlackhole, input);
				
				System.out.print("Connecting ");
				System.out.print(NotBlackhole[input-1].Cards[NotBlackhole[input-1].numOFCards-1].getRealValue() + NotBlackhole[input-1].Cards[NotBlackhole[input-1].numOFCards-1].getRealSuit());
				System.out.println(" to BlackHole...");
				System.out.println("");
				
				Blackhole.Cards[Blackhole.numOFCards] = NotBlackhole[input-1].Cards[NotBlackhole[input-1].numOFCards-1];
				Blackhole.numOFCards++;
				NotBlackhole[input-1].numOFCards--;
				AllCards--;
				
				System.out.println("--------------------------------");
				Blackhole.printAllCards();
				System.out.println("Cards Left: " + AllCards);
				
				System.out.println("[Dummy]"); 
				for(int i=0; i<17; i++) {
					if(i<9) System.out.print((i+1) + ":  ");
					else System.out.print((i+1) + ": ");
					NotBlackhole[i].printAllCards();
				}
				System.out.println("--------------------------------");
				System.out.println("");
			}
			catch(NoCardException e) {
				System.err.println("[Try again]: There are no card in the dummy!");
				System.err.println("");
			}
			catch(InputRangeException e) {
				System.err.println("[Try again]: Your Input is not in the range!");
				System.err.println("");
			}
			catch(InputRuleException e) {
				System.err.println("[Try again]: You cannot connect the card to BlackHole!");
				System.err.println("");
			}
			
			if(AllCards == 0)
				System.out.println("[You Win]: All cards are connected to BlackHole!!");
		}
		
	}
	
	//incorrect input에 대해서 예외 처리 조건을 확인
	void InputExeptionCheck(BlackholeAndCards BC, NotBlackholeCards[] NBC, int input) throws NoCardException, InputRangeException, InputRuleException{
		int flag = 0;
		if(input < 1 || input > 17) throw new InputRangeException();
		if(NBC[input-1].numOFCards == 0) throw new NoCardException();
		else if(Math.abs(NBC[input-1].Cards[NBC[input-1].numOFCards-1].getGameValue() - BC.Cards[BC.numOFCards-1].getGameValue()) == 1)
			flag = 1;
		if(flag == 0) throw new InputRuleException();
		return;
	}
}

class InputRangeException extends Exception{};
class InputRuleException extends Exception{};
class NoCardException extends Exception{};

