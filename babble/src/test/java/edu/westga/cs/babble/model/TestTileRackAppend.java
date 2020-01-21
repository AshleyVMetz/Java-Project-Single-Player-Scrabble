package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestTileRackAppend {
	
	@Test
	public void shouldNotAppendToFullRack() {
		TileRack tr = new TileRack() {
			
		};
		
		Tile a = new Tile('A');
		Tile a1 = new Tile('A');
		Tile a2 = new Tile('A');
		Tile a3 = new Tile('A');
		Tile b = new Tile('B');
		Tile b1 = new Tile('B');
		Tile b2 = new Tile('B');
		Tile r = new Tile('R');
		
		tr.append(a);
		tr.append(a1);
		tr.append(a2);
		tr.append(a3);
		tr.append(b);
		tr.append(b1);
		tr.append(b2);
		
		assertThrows(TileRackFullException.class, ()->{
			tr.append(r);
		});
		
	}
		
	}

