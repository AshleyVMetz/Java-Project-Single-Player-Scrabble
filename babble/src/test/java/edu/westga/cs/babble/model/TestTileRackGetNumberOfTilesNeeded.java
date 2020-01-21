package edu.westga.cs.babble.model;

import org.junit.Test;

public class TestTileRackGetNumberOfTilesNeeded {
	@Test
	public void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {
		TileRack tr = new TileRack();
		
		assert(tr.getNumberOfTilesNeeded()==TileRack.MAX_SIZE);
		
	}
	
	@Test
	public void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {
		TileRack tr = new TileRack();
		tr.append(new Tile('A'));
		assert(tr.getNumberOfTilesNeeded()==TileRack.MAX_SIZE - 1);
	}
	
	@Test
	public void tileRackWithSeveralTilesShouldNeedSomeTiles() {
		TileRack tr = new TileRack();
		tr.append(new Tile('A'));
		tr.append(new Tile('B'));
		tr.append(new Tile('A'));
		tr.append(new Tile('D'));
		tr.append(new Tile('A'));
		assert(tr.getNumberOfTilesNeeded()==TileRack.MAX_SIZE - 5);
	}
	
	@Test
	public void fullRackNeedsZeroTiles() {
		TileRack tr = new TileRack();
		tr.append(new Tile('A'));
		tr.append(new Tile('B'));
		tr.append(new Tile('A'));
		tr.append(new Tile('D'));
		tr.append(new Tile('C'));
		tr.append(new Tile('D'));
		tr.append(new Tile('C'));
		assert(tr.getNumberOfTilesNeeded()==0);
	}
}
