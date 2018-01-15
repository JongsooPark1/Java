package pieces;

import java.util.List;

public class Pawn extends Piece {

	public Pawn(Color color, Position position, List<Direction> directions) {
		super(color, Type.PAWN, position, directions);
	}

	public static Pawn createBlack(Position position) {
		return new Pawn(Color.BLACK, position, Direction.blackPawnDirection());
	}

	public static Pawn createWhite(Position position) {
		return new Pawn(Color.WHITE, position, Direction.whitePawnDirection());
	}
	
	@Override
	public void checkTargetPosition(Piece target) {
		if (isSameColor(target)) {
			throw new InputException("이동이 불가능합니다!#!");
		}
		for (Direction direction : getDirections()) {
			if (getDiffX(target) == direction.getXDegree() &&
					getDiffY(target) * (-1) == direction.getYDegree()) {
				return;
			}
		}
		throw new InputException("이동이 불가능합니다!~!");
	}
}
