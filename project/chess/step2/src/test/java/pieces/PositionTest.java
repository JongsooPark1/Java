package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void getXtest() {
		Position position = new Position("c5");
		assertEquals(2, position .getX());
		position = new Position("d6");
		assertEquals(3, position.getX());
	}
	
	@Test
	public void getYtest() {
		Position position = new Position("c5");
		assertEquals(3, position .getY());
		position = new Position("d6");
		assertEquals(2, position.getY());
	}
}
