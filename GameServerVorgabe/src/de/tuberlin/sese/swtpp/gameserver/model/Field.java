package de.tuberlin.sese.swtpp.gameserver.model;

import java.util.LinkedList;
import java.util.function.BiPredicate;

public class Field extends LinkedList<Figure> {
	// topLeft
	public static BiPredicate<Figure, Figure> topLeft = (a, b) -> a.column == b.column && a.row == b.row + 1;
	// top
	public static BiPredicate<Figure, Figure> top = (a, b) -> a.column == b.column && a.row == b.row + 1;
	// topRight
	public static BiPredicate<Figure, Figure> topRight = (a, b) -> a.column == b.column + 1 && a.row == b.row + 1;
	// left
	public static BiPredicate<Figure, Figure> left = (a, b) -> a.column == b.column - 1 && a.row == b.row;
	// right
	public static BiPredicate<Figure, Figure> right = (a, b) -> a.column == b.column + 1 && a.row == b.row;
	// bottomLeft
	public static BiPredicate<Figure, Figure> bottomLeft = (a, b) -> a.column == b.column - 1 && a.row == b.row - 1;
	// bottom
	public static BiPredicate<Figure, Figure> bottom = (a, b) -> a.column == b.column && a.row == b.row - 1;
	// bottomRight
	public static BiPredicate<Figure, Figure> bottomRight = (a, b) -> a.column == b.column + 1 && a.row == b.row - 1;

	public boolean inDanger(String moveBeginning, boolean requestingPlayer) {

		char column = moveBeginning.charAt(0);
		int row = (int) moveBeginning.charAt(1);

		Figure f = new Figure(requestingPlayer, column, row);

		return this.stream().anyMatch(a -> top.test(a, f) || topRight.test(a, f) || topLeft.test(a, f)
				|| left.test(a, f) || right.test(a, f) && !requestingPlayer);
	}

	public void isCannon(String unit) {

	}

	//public boolean normalMove(String moveTarget ,String moveBeginning, boolean requestingPlayer) {
		


	}

	public void leftOrRight(String unit) {
		// ist auf linker oder rechten Seite ein Gegner
	}

}
