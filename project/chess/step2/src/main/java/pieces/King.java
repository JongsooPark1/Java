package pieces;

public class King extends Piece {

	public King(Color color, Position position) {
		super(color, Type.KING, position, Direction.everyDirection());
	}

	public static King createBlack(Position position) {
		return new King(Color.BLACK, position);
	}

	public static King createWhite(Position position) {
		return new King(Color.WHITE, position);
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
