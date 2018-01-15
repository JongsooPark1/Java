package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

import pieces.Piece.Color;
import pieces.Piece.Type;

public class PieceTest {
	
	@Test
	public void getRepresentationTest() {
		Pawn whitePawn = new Pawn(Color.WHITE, null, null);
		assertEquals('p', whitePawn.getRepresentation());
		Pawn blackPawn = new Pawn(Color.BLACK, null, null);
		assertEquals('P', blackPawn.getRepresentation());
	}
	
	@Test
	public void matchColorTest() {
		Piece whitePawn = new Pawn(Color.WHITE, null, null);
		Piece blackKnight = new Knight(Color.BLACK, null);
		assertEquals(true, whitePawn.matchPiece(Color.WHITE, Type.PAWN));
		assertEquals(true, blackKnight.matchPiece(Color.BLACK, Type.KNIGHT));
	}

	@Test
	public void isSameColorTest() {
		Pawn white = new Pawn(Color.WHITE, null, null);
		Pawn black = new Pawn(Color.BLACK, null, null);
		assertEquals(false, white.isSameColor(black));
		black = new Pawn(Color.WHITE, null, null);
		assertEquals(true, white.isSameColor(black));
	}
}
