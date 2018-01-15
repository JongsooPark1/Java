package pieces;

public class Knight extends Piece {

	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position, Direction.knightDirection());
	}

	public static Knight createBlack(Position position) {
		return new Knight(Color.BLACK, position);
	}

	public static Knight createWhite(Position position) {
		return new Knight(Color.WHITE, position);
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