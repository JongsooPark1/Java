package chess;

import java.util.List;

import pieces.Blank;
import pieces.Piece;
import pieces.Position;

public class ChessGame {
	private List<Rank> ranks;
	
	ChessGame(Board board) {
		this.ranks = board.getRanks();
	}

	public Piece findPiece(String spot) {
		Position position = new Position(spot);
		Rank rank = ranks.get(position.getY());
		Piece piece = rank.getPieces().get(position.getX());
		return piece;
	}

	public void move(Position targetP, Piece piece) {
		Position sourceP = piece.getPosition();
		piece.setPosition(targetP);
		ranks.get(targetP.getY()).setPiece(targetP, piece);
		Piece blank = Blank.createBlank(sourceP);
		ranks.get(sourceP.getY()).setPiece(sourceP, blank);
	}
	
	public void move(String sourcePosition, String targetPosition) {
		Position targetP = new Position(targetPosition);
		Piece source = findPiece(sourcePosition);
		Piece target = findPiece(targetPosition);
		source.checkTargetPosition(target);
		move(targetP, source);
	}
}
