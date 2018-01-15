package pieces;

public class Bishop extends Piece {

	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position, Direction.diagonalDirection());
	}

	public static Bishop createBlack(Position position) {
		return new Bishop(Color.BLACK, position);
	}

	public static Bishop createWhite(Position position) {
		return new Bishop(Color.WHITE, position);
	}
	
	@Override
	public void checkTargetPosition(Piece target) {
		if (isSameColor(target)) {
			throw new InputException("이동이 불가능합니다!#!");
		}
		for (Direction direction : getDirections()) {
			if (direction.getXDegree() != 0 && getDiffX(target) % direction.getXDegree() == 0) {
				return;
			}
			if (direction.getYDegree() != 0 && getDiffY(target) * (-1) % direction.getYDegree() == 0) {
				return;
			}
		}
		throw new InputException("이동이 불가능합니다!~!");
	}
}