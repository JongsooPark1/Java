package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class ChessGameTest {

	@Test
	public void findPieceTest() {
		Position pawnPosition = new Position("a7");
		Pawn blackPawn = Pawn.createBlack(pawnPosition);
		Position rookPosition = new Position("a1");
		Rook whiteRook = Rook.createWhite(rookPosition);
		Board board = new Board();
		board.initialize(new UpperBoard());
		ChessGame game = new ChessGame(board);
		assertEquals(blackPawn, game.findPiece("a7"));
		assertEquals(whiteRook, game.findPiece("a1"));
	}
	
	@Test
	public void movePawnTest() {
		Board board = new Board();
		board.initialize(new UpperBoard());
		ChessGame game = new ChessGame(board);
		Position pawnPosition = new Position("a3");
		Pawn whitePawn = Pawn.createWhite(pawnPosition);
		game.move("a2", "a3");
		assertEquals(whitePawn, game.findPiece("a3"));
	}
	
	@Test
	public void moveKnightTest() {
		Board board = new Board();
		board.initialize(new UpperBoard());
		ChessGame game = new ChessGame(board);
		Position kingPosition = new Position("b1");
		Knight whiteKnight = Knight.createWhite(kingPosition);
		game.move("b1", "c3");
		assertEquals(whiteKnight, game.findPiece("c3"));
	}
	
	@Test
	public void moveQueenTest() {
		Board board = new Board();
		board.initialize(new UpperBoard());
		ChessGame game = new ChessGame(board);
		Position pawnPosition = new Position("e1");
		Queen whiteQueen = Queen.createWhite(pawnPosition);
		game.move("e1", "e4");
		assertEquals(whiteQueen, game.findPiece("e4"));
	}
	
	@Test
	public void moveKingTest() {
		Board board = new Board();
		board.initialize(new UpperBoard());
		ChessGame game = new ChessGame(board);
		Position pawnPosition = new Position("d3");
		Pawn whitePawn = Pawn.createWhite(pawnPosition);
		Position kingPosition = new Position("d2");
		King whiteKing = King.createWhite(kingPosition);
		game.move("d2", "d3");
		game.move("d1", "d2");
		assertEquals(whitePawn, game.findPiece("d3"));
		assertEquals(whiteKing, game.findPiece("d2"));
	}
	
	@Test
	public void killTest() {
		Board board = new Board();
		board.initialize(new UpperBoard());
		ChessGame game = new ChessGame(board);
		Position pawnPosition = new Position("e1");
		Queen whiteQueen = Queen.createWhite(pawnPosition);
		game.move("e1", "e7");
		assertEquals(whiteQueen, game.findPiece("e7"));
	}
}
