package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Bishop;
import pieces.Blank;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class Rank {
	private List<Piece> pieces = new ArrayList<>();

	public List<Piece> getPieces() {
		return this.pieces;
	}

	int getCountsOfPiece(Color color, Type type) {
		int countsOfPiece = 0;
		for (Piece piece : pieces) {
			if (piece.matchPiece(color, type)) {
				countsOfPiece++;
			}
		}
		return countsOfPiece;
	}
	
	static Rank initializeBlackPieces(int column) {
		Rank rank = new Rank();
		rank.pieces.add(Rook.createBlack(new Position("a" + column)));
		rank.pieces.add(Knight.createBlack(new Position("b" + column)));
		rank.pieces.add(Bishop.createBlack(new Position("c" + column)));
		rank.pieces.add(King.createBlack(new Position("d" + column)));
		rank.pieces.add(Queen.createBlack(new Position("e" + column)));
		rank.pieces.add(Bishop.createBlack(new Position("f" + column)));
		rank.pieces.add(Knight.createBlack(new Position("g" + column)));
		rank.pieces.add(Rook.createBlack(new Position("h" + column)));
		return rank;
	}

	static Rank initializeWhitePieces(int column) {
		Rank rank = new Rank();
		rank.pieces.add(Rook.createWhite(new Position("a" + column)));
		rank.pieces.add(Knight.createWhite(new Position("b" + column)));
		rank.pieces.add(Bishop.createWhite(new Position("c" + column)));
		rank.pieces.add(King.createWhite(new Position("d" + column)));
		rank.pieces.add(Queen.createWhite(new Position("e" + column)));
		rank.pieces.add(Bishop.createWhite(new Position("f" + column)));
		rank.pieces.add(Knight.createWhite(new Position("g" + column)));
		rank.pieces.add(Rook.createWhite(new Position("h" + column)));
		return rank;
	}
	
	static Rank initializeBlackPawns(int column) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieces.add(Pawn.createBlack(new Position((char)('a' + i) + "" + column)));
		}
		return rank;
	}
	
	static Rank initializeWhitePawns(int column) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieces.add(Pawn.createWhite(new Position((char)('a' + i) + "" + column)));
		}
		return rank;
	}

	public static Rank initializeBlank(int column) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieces.add(Blank.createBlank(new Position((char)('a' + i) + "" + column)));
		}
		return rank;
	}

	public void setPiece(Position position, Piece piece) {
		pieces.set(position.getX(), piece);
	}

	public double calculatePoint(Color color) {
		double point = 0;
		for (Piece piece : pieces) {
			if (piece.getColor() == color) {
				point += piece.getDefaultPoint();
			}
		}
		return point;
	}
}
