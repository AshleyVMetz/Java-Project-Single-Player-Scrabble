package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestPlayedWordMatches {
	
	@Test
	public void hasTilesForAMultipleLetterWord() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('B'));
		pw.append(new Tile('A'));
		pw.append(new Tile('K'));
		pw.append(new Tile('E'));
		assert(pw.matches(pw.getHand()));
	}
	
	@Test
	public void hasTilesForASingleLetterWord() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('A'));
		assert(pw.matches(pw.getHand()));
	}
	
	@Test
	public void cannotMatchWordWhenTilesAreScrambled() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('B'));
		pw.append(new Tile('K'));
		pw.append(new Tile('A'));
		pw.append(new Tile('E'));
		
		PlayedWord pw2 = new PlayedWord();
		pw2.append(new Tile('B'));
		pw2.append(new Tile('A'));
		pw2.append(new Tile('K'));
		pw2.append(new Tile('E'));

		assert(pw.matches(pw2.getHand()) == false);
	}
	
	@Test
	public void cannotMatchWordIfInsufficientTiles() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('B'));
		pw.append(new Tile('A'));
		pw.append(new Tile('K'));
		
		
		PlayedWord pw2 = new PlayedWord();
		pw2.append(new Tile('B'));
		pw2.append(new Tile('A'));
		pw2.append(new Tile('K'));
		pw2.append(new Tile('E'));

		assert(pw.matches(pw2.getHand()) == false);
	}
	
	@Test
	public void canMatchWordWithDuplicateLetters() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('S'));
		pw.append(new Tile('E'));
		pw.append(new Tile('E'));
		

		assert(pw.matches(pw.getHand()));
		
	}
	
	@Test
	public void nonEmptyWordShouldNotMatchEmptyText() {
		PlayedWord pw = new PlayedWord();
		pw.append(new Tile('S'));
		pw.append(new Tile('E'));
		pw.append(new Tile('E'));
		
		PlayedWord pw2 = new PlayedWord();
		assert(pw.matches(pw2.getHand()) == false);
	}
	
	@Test
	public void emptyWordShouldNotMatchEmptyText() {
		PlayedWord pw = new PlayedWord();
		PlayedWord pw2 = new PlayedWord();
		assert(pw.matches(pw2.getHand()) == false);
		
	}
	
	@Test
	public void shouldNotAllowNull() {
		PlayedWord pw = new PlayedWord();
		assertThrows(IllegalArgumentException.class, ()->pw.matches(null));
		
	}
}
