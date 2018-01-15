package pieces;

public class Rook extends Piece {

	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position, Direction.linearDirection());
	}

	public static Rook createBlack(Position position) {
		return new Rook(Color.BLACK, position);
	}

	public static Rook createWhite(Position position) {
		return new Rook(Color.WHITE, position);
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