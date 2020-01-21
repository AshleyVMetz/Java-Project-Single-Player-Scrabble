package edu.westga.cs.babble.model;

import org.junit.Test;

public class TestPlayedWordClear {
	
	@Test
	public void shouldClearEmptyWord() {
		PlayedWord pw = new PlayedWord();
		pw.clear();
		assert(pw.getHand().isEmpty());
	}
	
	@Test
	public void shouldClearWordWithOneTile() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('A'));
		pw.clear();
		assert(pw.getHand().isEmpty());
		
	}
	
	@Test
	public void shouldClearWordWithManyTiles() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('A'));
		pw.append(new Tile('A'));
		pw.append(new Tile('A'));
		pw.append(new Tile('B'));
		pw.append(new Tile('B'));
		pw.clear();
		assert(pw.getHand().isEmpty());
	}

}
