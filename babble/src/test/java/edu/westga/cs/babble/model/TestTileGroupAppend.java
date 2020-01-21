package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;


public class TestTileGroupAppend {
	
	
       
           
     
    
	@Test
	public void shouldNotAllowNull() {
		
		TileGroup tg = new TileGroup() {
		
		};
		
		assertThrows(IllegalArgumentException.class, ()->tg.append(null));
		
	}

	@Test
	public void emptyGroupShouldBeEmpty() {
		TileGroup tg = new TileGroup() {
			
		};
		
		assert(tg.tiles().isEmpty());
	}
	
	@Test
	public void shouldHaveOneTileInTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		Tile t = new Tile('A');
		tg.append(t);
		assert(tg.tiles().size() == 1);
	}
	
	@Test
	public void shouldHaveManyTilesInTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		
		for (int i = 0; i<5; i++) {
			tg.append(new Tile((char)('A'+i)));
		}
		
		assert(tg.tiles().size() == 5);
	}
	
	@Test
	public void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		TileGroup tg = new TileGroup() {
			
		};
		Tile a = new Tile('A');
		Tile a1 = new Tile('A');
		Tile a2 = new Tile('A');
		Tile b = new Tile('B');
		tg.append(a);
		tg.append(a1);
		tg.append(a2);
		tg.append(b);
		
		assert(tg.tiles().size() == 4);
	}
	
	@Test
	public void canNotAddSameTileTwice() {
		TileGroup tg = new TileGroup() {
			
		};
		Tile a = new Tile('A');
		
		tg.append(a);
		
		assertThrows(IllegalArgumentException.class, ()->{
			tg.append(a);
		});
	}

}
