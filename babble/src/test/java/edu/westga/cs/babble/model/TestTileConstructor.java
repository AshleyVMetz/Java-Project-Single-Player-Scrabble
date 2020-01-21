package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestTileConstructor {

	@Test
	public void shouldNotAllowNonLetters() {
	
		assertThrows(IllegalArgumentException.class,  () -> {
			new Tile('?');
		});
		
	}
	
	//(checks that all the 1-point tiles can be made from the appropriate upper- and 
	//lower-case letters and that they have the appropriate point value) EAIONRTLSU
	@Test
	public void shouldCreateOnePointTiles() { 
		assertTrue(1 == new Tile('e').getPointValue());
		assertTrue(1 == new Tile('E').getPointValue());
		assertTrue(1 == new Tile('a').getPointValue());
		assertTrue(1 == new Tile('A').getPointValue());
		assertTrue(1 == new Tile('i').getPointValue());
		assertTrue(1 == new Tile('I').getPointValue());
		assertTrue(1 == new Tile('o').getPointValue());
		assertTrue(1 == new Tile('O').getPointValue());
		assertTrue(1 == new Tile('n').getPointValue());
		assertTrue(1 == new Tile('N').getPointValue());
		assertTrue(1 == new Tile('r').getPointValue());
		assertTrue(1 == new Tile('R').getPointValue());
		assertTrue(1 == new Tile('t').getPointValue());
		assertTrue(1 == new Tile('T').getPointValue());
		assertTrue(1 == new Tile('l').getPointValue());
		assertTrue(1 == new Tile('L').getPointValue());
		assertTrue(1 == new Tile('s').getPointValue());
		assertTrue(1 == new Tile('S').getPointValue());
		assertTrue(1 == new Tile('u').getPointValue());
		assertTrue(1 == new Tile('U').getPointValue());
		
		
	}
	
	//(similar to above)
	@Test
	public void shouldCreateTwoPointTiles() {
		assertTrue(2 == new Tile('d').getPointValue());
		assertTrue(2 == new Tile('D').getPointValue());
		assertTrue(2 == new Tile('g').getPointValue());
		assertTrue(2 == new Tile('G').getPointValue());
		
	}
	
	@Test
	public void shouldCreateThreePointTiles() {
		assertTrue(3 == new Tile('b').getPointValue());
		assertTrue(3 == new Tile('B').getPointValue());
		assertTrue(3 == new Tile('c').getPointValue());
		assertTrue(3 == new Tile('C').getPointValue());
		assertTrue(3 == new Tile('m').getPointValue());
		assertTrue(3 == new Tile('M').getPointValue());
		assertTrue(3 == new Tile('p').getPointValue());
		assertTrue(3 == new Tile('P').getPointValue());
		
	}
	
	@Test
	public void shouldCreateFourPointTiles() {
		assertTrue(4 == new Tile('f').getPointValue());
		assertTrue(4 == new Tile('F').getPointValue());
		assertTrue(4 == new Tile('h').getPointValue());
		assertTrue(4 == new Tile('H').getPointValue());
		assertTrue(4 == new Tile('v').getPointValue());
		assertTrue(4 == new Tile('V').getPointValue());
		assertTrue(4 == new Tile('w').getPointValue());
		assertTrue(4 == new Tile('W').getPointValue());
		assertTrue(4 == new Tile('y').getPointValue());
		assertTrue(4 == new Tile('Y').getPointValue());
		
	}
	
	@Test
	public void shouldCreateFivePointTiles() {
		assertTrue(5 == new Tile('k').getPointValue());
		assertTrue(5 == new Tile('K').getPointValue());
	}
	
	@Test
	public void shouldCreateEightPointTiles() {
		assertTrue(8 == new Tile('j').getPointValue());
		assertTrue(8 == new Tile('J').getPointValue());
		assertTrue(8 == new Tile('x').getPointValue());
		assertTrue(8 == new Tile('X').getPointValue());
	}
	
	@Test
	public void shouldCreateTenPointTiles() {
		assertTrue(10 == new Tile('q').getPointValue());
		assertTrue(10 == new Tile('Q').getPointValue());
		assertTrue(10 == new Tile('z').getPointValue());
		assertTrue(10 == new Tile('Z').getPointValue());
		
	}
}
