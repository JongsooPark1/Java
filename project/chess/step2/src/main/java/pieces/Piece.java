package pieces;

import java.util.List;

public class Piece {
	public enum Color {
		WHITE, BLACK, NO_COLOR;
	}

	public enum Type {
		PAWN('p', 1.0),
		ROOK('r', 5.0),
		KNIGHT('n', 2.5),
		BISHOP('b', 3.0),
		QUEEN('q', 9.0),
		KING('k', 0.0),
		NO_PIECE('.', 0.0);

		private char representation;
		private double defaultPoint;

		private Type(char representation, double defaultPoint) {
			this.representation = representation;
			this.defaultPoint = defaultPoint;
		}

		public char getWhiteRepresentation() {
			return this.representation;
		}

		public char getBlackRepresentation() {
			return Character.toUpperCase(this.representation);
		}

		public double getDefaultPoint() {
			return defaultPoint;
		}
	}

	private Color color;
	private Type type;
	private Position position;
	private List<Direction> directions;

	public Piece(Color color, Type type, Position position, List<Direction> directions) {
		this.color = color;
		this.type = type;
		this.position = position;
		this.directions = directions;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public List<Direction> getDirections() {
		return directions;
	}
	
	public double getDefaultPoint() {
		return type.defaultPoint;
	}

	public char getRepresentation() {
		if (this.isWhite()) {
			return this.type.getWhiteRepresentation();
		}
		return this.type.getBlackRepresentation();
	}

	private boolean matchColor(Color color) {
		return this.color == color;
	}

	private boolean matchType(Type type) {
		return this.type == type;
	}

	public boolean matchPiece(Color color, Type type) {
		return matchColor(color) && matchType(type);
	}

	public boolean isBlack() {
		return this.color == Color.BLACK;
	}

	public boolean isWhite() {
		return this.color == Color.WHITE;
	}
	
	public void checkTargetPosition(Piece target) {
		if (isSameColor(target)) {
			throw new InputException("이동이 불가능합니다!!!");
		}
	}
	
	public boolean isSameColor(Piece target) {
		if (this.color == target.color) {
			return true;
		}
		return false;
 	}
	
	public void move(Piece target, Piece blank) {
//		Position sourcePosition = getPosition();
		setPosition(target.getPosition());
//		target.setPosition(sourcePosition);
//		blank.setPosition(sourcePosition);
	}
	
	public int getDiffX(Piece target) {
		return target.position.getX() - position.getX();
	}
	
	public int getDiffY(Piece target) {
		return target.position.getY() - position.getY();
	}

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
