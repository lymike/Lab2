package pkgPokerBLL;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {

	@Test
	public void TestFullHouse1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());
			
	}
	
	@Test
	public void TestFullHouse2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());
			
	}
	
	@Test
	public void TestThreeOfAKind1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has two kickers
		assertEquals(2,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.FOUR, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestThreeOfAKind2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Five'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has two kickers
		assertEquals(2,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.FOUR, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestThreeOfAKind3() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be three of a kind
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has two kickers
		assertEquals(2,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.SIX, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestFourOfAKind1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be four of a kind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has one kickers
		assertEquals(1,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.THREE, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestFourOfAKind2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be four of a kind
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has one kickers
		assertEquals(1,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.FOUR, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestHandPair1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be one pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Six'
		assertEquals(eRank.SIX.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has three kickers
		assertEquals(3,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.FIVE, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestHandPair2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be one pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Five'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has three kickers
		assertEquals(3,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.SIX, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestHandPair3() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be one pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has three kickers
		assertEquals(3,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.SIX, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestHandPair4() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be one pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has three kickers
		assertEquals(3,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.SIX, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestTwoPair1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//  LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Has one kickers
		assertEquals(1,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.TWO, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestTwoPair2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Five'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//  LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Has one kickers
		assertEquals(1,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.FOUR, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestTwoPair3() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//  LO hand better be 'Two'
		assertEquals(eRank.TWO.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Has one kickers
		assertEquals(1,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.FOUR, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestHandFlush() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));		
		h.EvaluateHand();
		
		//	Hand better be Flush
		assertEquals(eHandStrength.Flush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Jack'
		assertEquals(eRank.JACK.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has four kickers
		assertEquals(4,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.TEN, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestRoyalFlush() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));		
		h.EvaluateHand();
		
		//	Hand better be Royal Flush
		assertEquals(eHandStrength.RoyalFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Royal Flush has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());

	}
	
	@Test
	public void TestAcesAndEights1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be Aces and Eights
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//  LO hand better be 'Eight'
		assertEquals(eRank.EIGHT.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Has one kickers
		assertEquals(1,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.FOUR, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestAcesAndEights2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be Aces and Eights
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Ace'
		assertEquals(eRank.ACE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//  LO hand better be 'Eight'
		assertEquals(eRank.EIGHT.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Has one kickers
		assertEquals(1,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.NINE, 
				h.getHandScore().getKickers().get(0).geteRank());
	
	}
	
	@Test
	public void TestHandStraight1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be Straight
		assertEquals(eHandStrength.Straight.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Five'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has no kickers
		assertEquals(0,h.getHandScore().getKickers().size());
		
	}
	
	@Test
	public void TestHandStraight2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be Straight
		assertEquals(eHandStrength.Straight.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'King'
		assertEquals(eRank.KING.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has no kickers
		assertEquals(0,h.getHandScore().getKickers().size());
		
	}

	@Test
	public void TestStraightFlush1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));		
		h.EvaluateHand();
		
		//	Hand better be Straight Flush
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'King'
		assertEquals(eRank.KING.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has no kickers
		assertEquals(0,h.getHandScore().getKickers().size());
		
	}
	
	@Test
	public void TestStraightFlush2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));		
		h.EvaluateHand();
		
		//	Hand better be Straight Flush
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Five'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Has no kickers
		assertEquals(0,h.getHandScore().getKickers().size());
		
	}
	
	@Test
	public void TestHandHigh() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));		
		h.EvaluateHand();
		
		//  Hand better be High
		assertEquals(eHandStrength.HighCard.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'King'
		assertEquals(eRank.KING.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());

		//	Has four kickers
		assertEquals(4,h.getHandScore().getKickers().size());
		
		//  Highest kicker
		assertEquals(eRank.TEN, 
				h.getHandScore().getKickers().get(0).geteRank());
		
	}
	
}
