package chess;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class BoardTest {
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void getMatchCountOfPieceTest() throws Exception {
		board.initialize(new UpperBoard());
		assertEquals(8, board.getMatchCountsOfPiece(Color.WHITE, Type.PAWN));
		assertEquals(2, board.getMatchCountsOfPiece(Color.BLACK, Type.BISHOP));
		assertEquals(2, board.getMatchCountsOfPiece(Color.WHITE, Type.KNIGHT));
		assertEquals(2, board.getMatchCountsOfPiece(Color.BLACK, Type.ROOK));
		assertEquals(1, board.getMatchCountsOfPiece(Color.WHITE, Type.KING));
		assertEquals(32, board.getMatchCountsOfPiece(Color.NO_COLOR, Type.NO_PIECE));
	}

	@Test
	public void calculcatePoint() throws Exception {
		Initialize init = new Initialize() {
			@Override
			public List<Rank> initialize() {
				List<Rank> ranks = new ArrayList<>();
				for (int i = 0; i < 8; i++) {
					ranks.add(Rank.initializeBlank(8 - i));
				}
				return ranks;
			}
		};
		Board board = new Board();
		board.initialize(init);

		addPiece("b6", Pawn.createBlack(null));
		addPiece("e6", Queen.createBlack(null));
		addPiece("b8", King.createBlack(null));
		addPiece("c8", Rook.createBlack(null));

		addPiece("f2", Pawn.createWhite(null));
		addPiece("g2", Pawn.createWhite(null));
		addPiece("e1", Rook.createWhite(null));
		addPiece("f1", King.createWhite(null));

		assertEquals(15.0, board.calculcatePoint(Color.BLACK), 0.01);
		assertEquals(7.0, board.calculcatePoint(Color.WHITE), 0.01);
	}

	private void addPiece(String position, Piece piece) {
		ChessGame game = new ChessGame(board);
		game.move(new Position(position), piece);
	}
}
