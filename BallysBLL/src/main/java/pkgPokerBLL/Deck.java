package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pkgPokerEnum.eRank;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck()
	{
		for (eRank Rank : eRank.values()) {
			System.out.println(Rank.getiRankNbr());
		}
		Collections.shuffle(DeckCards);
	}
	
	public Card DrawCard()
	{	
		return DeckCards.remove(0);
	}
}
