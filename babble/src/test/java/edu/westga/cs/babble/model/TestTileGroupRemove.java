package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.Test;

public class TestTileGroupRemove {

	@Test
	public void shouldNotAllowNull() {
		TileGroup tg = new TileGroup() {
			
		};
		
		assertThrows(IllegalArgumentException.class, ()->tg.remove(null));
		
	}
	
	@Test
	public void canNotRemoveFromEmptyTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		
		Tile t = new Tile('A');
		tg.append(t);
		try {
			tg.remove(t);
		}
		catch(TileNotInGroupException tnige) {
			assert(false);
		}
		
		assertThrows(TileNotInGroupException.class, ()->{
			tg.remove(t);			
		});

		//assertThrows(tg.tiles().isEmpty());
	}
	
	//skipping
	@Test
	public void canNotRemoveTileNotInTileGroup() {
		
	}
	
	@Test
	public void canRemoveOnlyTileInTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		
		Tile t = new Tile('A');
		
		tg.append(t);
		
		try {
			tg.remove(t);
		}
		catch(TileNotInGroupException tnige) {
			assert(false);
		}
		
		assert(tg.tiles().isEmpty());

	}
	
	@Test
	public void canRemoveFirstOfManyTilesFromTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		
		Tile t = new Tile('A');
		Tile b = new Tile('B');
		Tile c = new Tile('C');
		tg.append(t);
		tg.append(b);
		tg.append(c);
		try {
			tg.remove(t);
		}
		catch(TileNotInGroupException tnige) {
			assert(false);
		}
		String h = tg.getHand( );
		Assert.assertEquals(h, "BC");
	}
	
	@Test
	public void canRemoveLastOfManyTilesFromTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		
		Tile t = new Tile('A');
		Tile b = new Tile('B');
		Tile c = new Tile('C');
		tg.append(t);
		tg.append(b);
		tg.append(c);
		try {
			tg.remove(c);
		}
		catch(TileNotInGroupException tnige) {
			assert(false);
		}
		String h = tg.getHand( );
		Assert.assertEquals(h, "AB");
	}
	
	@Test
	public void canRemoveMiddleOfManyTilesFromTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		
		Tile t = new Tile('A');
		Tile b = new Tile('B');
		Tile c = new Tile('C');
		tg.append(t);
		tg.append(b);
		tg.append(c);
		try {
			tg.remove(b);
		}
		catch(TileNotInGroupException tnige) {
			assert(false);
		}
		String h = tg.getHand( );
		Assert.assertEquals(h, "AC");
	}
	
	@Test
	public void canRemoveMultipleTilesFromTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		
		Tile t = new Tile('A');
		Tile b = new Tile('B');
		Tile c = new Tile('C');
		tg.append(t);
		tg.append(b);
		tg.append(c);
		try {
			tg.remove(t);
			tg.remove(b);
		}
		catch(TileNotInGroupException tnige) {
			assert(false);
		}
		String h = tg.getHand( );
		Assert.assertEquals(h, "C");
	}
	
	@Test
	public void doesNotRemoveDuplicateTilesFromTileGroup() {
TileGroup tg = new TileGroup() {
			
		};
		
		Tile t = new Tile('A');
		Tile a = new Tile('A');
		Tile c = new Tile('C');
		tg.append(t);
		tg.append(a);
		tg.append(c);
		try {
			tg.remove(t);
		}
		catch(TileNotInGroupException tnige) {
			assert(false);
		}
		String h = tg.getHand( );
		Assert.assertEquals(h, "AC");
	}
}
