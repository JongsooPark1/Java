package View;

import static utils.StringUtils.appendNewLine;

import java.util.List;


import chess.Board;
import chess.Rank;
import pieces.Piece;


public class ChessView {
	private List<Rank> ranks;
	
	public ChessView(Board board) {
		this.ranks = board.getRanks();
	}

	private String showEachRank(Rank rank) {
		StringBuilder eachRank = new StringBuilder();
		for (Piece piece : rank.getPieces()) {
			eachRank.append(piece.getRepresentation());
		}
		return appendNewLine(eachRank.toString());
	}

	public String showBoard() {
		StringBuilder board = new StringBuilder();
		for (Rank rank : ranks) {
			board.append(showEachRank(rank));
		}
		return board.toString();
	}
}
