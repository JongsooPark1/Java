package pieces;

public class Queen extends Piece {

	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position, Direction.everyDirection());
	}

	public static Queen createBlack(Position position) {
		return new Queen(Color.BLACK, position);
	}

	public static Queen createWhite(Position position) {
		return new Queen(Color.WHITE, position);
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
