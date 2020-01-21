package edu.westga.cs.babble.model;

import org.junit.Test;

public class TestPlayedWordGetScore {
	
	@Test
	public void emptyWordShouldHaveScoreOfZero() {
		PlayedWord pw = new PlayedWord();
		assert(pw.getScore() == 0);
	}
	
	@Test
	public void scoreAOneTileWord() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('a'));
		assert(pw.getScore()==1);
		
	}
	
	@Test
	public void scoreAWordWithMultipleDifferingTiles() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('a'));
		pw.append(new Tile('t'));
		pw.append(new Tile('e'));
		assert(pw.getScore()==3);
	}
	
	@Test
	public void scoreAWordContainingDuplicateTiles() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('s'));
		pw.append(new Tile('e'));
		pw.append(new Tile('e'));
		assert(pw.getScore()==3);
	}
}
