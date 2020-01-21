package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestTileBagDrawTile {
	
	// (checks that 98 tiles -- the total number of Scrabble tiles -- can be drawn)
	@Test
	public void canDrawAllTiles() {
		TileBag tileBag = new TileBag();
		try {
			for (int i=0; i<98; i++) {
				tileBag.drawTile();
			}
		}
		catch (EmptyTileBagException e){
			assert(false);
		}
		
		assert(true);
	}
	
	
	//(checks that attempting to draw a 99th tile throws the appropriate exception)
	@Test
	public void canNotDrawTooManyTiles() {
		TileBag tileBag = new TileBag();
		try {
			for (int i=0; i<98; i++) {
				tileBag.drawTile();
			}
		}
		catch (EmptyTileBagException e){
			assert(false);
		}
		
		assertThrows(EmptyTileBagException.class, ()->{
		 
			tileBag.drawTile();
			
		});		
	}
	
	//(checks that the tiles in the tile bag are distributed according to the standard Scrabble distribution)
	@Test
	public void hasProperTileDistribution() {
		int[] counts = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
		TileBag tileBag = new TileBag();
		try {
			for (int i=0; i<98; i++) {
				Tile t = tileBag.drawTile();
				int val = (int)t.getLetter() - 'A';
				counts[val]--;
			}
		}
		catch (EmptyTileBagException e){
			assert(false);
		}
		
		for(int i=0;i<26;i++) {
			assert(counts[i] == 0);
		}
	}
}
