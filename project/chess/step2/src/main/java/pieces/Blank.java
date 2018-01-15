package pieces;

import java.util.ArrayList;

public class Blank extends Piece {

	public Blank(Color color, Position position) {
		super(color, Type.NO_PIECE, position, new ArrayList<>());
	}

	public static Piece createBlank(Position position) {
		return new Piece(Color.NO_COLOR, Type.NO_PIECE, position, new ArrayList<>());
	}
}