package chess;

import java.util.ArrayList;
import java.util.List;


public class UpperBoard implements Initialize {
	List<Rank> ranks = new ArrayList<>();
	
	public List<Rank> initialize() {
		ranks.add(Rank.initializeBlackPieces(8));
		ranks.add(Rank.initializeBlackPawns(7));
		ranks.add(Rank.initializeBlank(6));
		ranks.add(Rank.initializeBlank(5));
		ranks.add(Rank.initializeBlank(4));
		ranks.add(Rank.initializeBlank(3));
		ranks.add(Rank.initializeWhitePawns(2));
		ranks.add(Rank.initializeWhitePieces(1));
		return ranks;
	}
}
