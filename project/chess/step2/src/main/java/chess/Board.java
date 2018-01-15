package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece.Color;
import pieces.Piece.Type;

public class Board {
	private List<Rank> ranks = new ArrayList<Rank>();
	
	public List<Rank> getRanks() {
		return ranks;
	}

	int getMatchCountsOfPiece(Color color, Type type) {
		int matchCountsOfPiece = 0;
		for (Rank rank : ranks) {
			matchCountsOfPiece += rank.getCountsOfPiece(color, type);
		}
		return matchCountsOfPiece;
	}

	public void initialize(Initialize initialize) {
		this.ranks = initialize.initialize();
	}
	
	public double calculcatePoint(Color color) {
		double point = 0;
		for (Rank rank : ranks) {
			point += rank.calculatePoint(color);
		}
		return point;
	}
}
