package eu.veldsoft.politrics.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Board {
	public static final int PIECES = 17;

	public static final int SIZE = 9;

	/**
	 * Initial container for all figures in the object model.
	 */
	private final Figure pile[][] = new Figure[2][PIECES];

	/**
	 * Two dimensional array with all figures on the board.
	 */
	private final Figure figures[][] = new Figure[SIZE][SIZE];

	/**
	 * Two dimensional array with fixed properties of the the board cells.
	 */
	private final Cell cells[][] = new Cell[SIZE][SIZE];

	/**
	 * Two dimensional array with civil servants aura.
	 */
	private final boolean aura[][] = new boolean[SIZE][SIZE];

	/**
	 * Container with figures placed in the line-ups.
	 */
	private final Map<Enemy, Vector<Figure>> lineups = new HashMap<Enemy, Vector<Figure>>();

	/**
	 * Board state as finite autmate.
	 */
	private State state = State.PLACING;

	/**
	 * Turn counter.
	 */
	private int turn = 0;

	/* Initialize object fields. */{
		pile[Enemy.DARK.index()][0] = new President(Enemy.DARK);
		pile[Enemy.DARK.index()][1] = new Voter(Enemy.DARK);
		pile[Enemy.DARK.index()][2] = new Voter(Enemy.DARK);
		pile[Enemy.DARK.index()][3] = new Voter(Enemy.DARK);
		pile[Enemy.DARK.index()][4] = new Voter(Enemy.DARK);
		pile[Enemy.DARK.index()][5] = new Minister(Enemy.DARK);
		pile[Enemy.DARK.index()][6] = new Minister(Enemy.DARK);
		pile[Enemy.DARK.index()][7] = new Minister(Enemy.DARK);
		pile[Enemy.DARK.index()][8] = new Minister(Enemy.DARK);
		pile[Enemy.DARK.index()][9] = new Delegate(Enemy.DARK);
		pile[Enemy.DARK.index()][10] = new Delegate(Enemy.DARK);
		pile[Enemy.DARK.index()][11] = new Delegate(Enemy.DARK);
		pile[Enemy.DARK.index()][12] = new Delegate(Enemy.DARK);
		pile[Enemy.DARK.index()][13] = new Servant(Enemy.DARK);
		pile[Enemy.DARK.index()][14] = new Servant(Enemy.DARK);
		pile[Enemy.DARK.index()][15] = new Servant(Enemy.DARK);
		pile[Enemy.DARK.index()][16] = new Servant(Enemy.DARK);

		pile[Enemy.LIGHT.index()][0] = new President(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][1] = new Voter(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][2] = new Voter(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][3] = new Voter(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][4] = new Voter(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][5] = new Minister(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][6] = new Minister(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][7] = new Minister(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][8] = new Minister(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][9] = new Delegate(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][10] = new Delegate(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][11] = new Delegate(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][12] = new Delegate(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][13] = new Servant(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][14] = new Servant(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][15] = new Servant(Enemy.LIGHT);
		pile[Enemy.LIGHT.index()][16] = new Servant(Enemy.LIGHT);

		lineups.put(Enemy.DARK, new Vector<Figure>());
		for (Figure figure : pile[Enemy.DARK.index()]) {
			lineups.get(Enemy.DARK).add(figure);
		}
		lineups.put(Enemy.LIGHT, new Vector<Figure>());
		for (Figure figure : pile[Enemy.LIGHT.index()]) {
			lineups.get(Enemy.LIGHT).add(figure);
		}

		cells[0][0] = new Cell(0xcc0000, 0, 11);
		cells[0][1] = new Cell(0xff99ff, 0, 12);
		cells[0][2] = new Cell(0xcc0000, 0, 13);
		cells[0][3] = new Cell(0xff99ff, 0, 14);
		cells[0][4] = new Cell(0xcc0000, 0, 15);
		cells[0][5] = new Cell(0xff99ff, 0, 16);
		cells[0][6] = new Cell(0xcc0000, 0, 17);
		cells[0][7] = new Cell(0xff99ff, 0, 18);
		cells[0][8] = new Cell(0xcc0000, 0, 19);

		cells[1][0] = new Cell(0xff99ff, 0, 21);
		cells[1][1] = new Cell(0x6699ff, 1, 22);
		cells[1][2] = new Cell(0xffffff, 0, 23);
		cells[1][3] = new Cell(0xffffff, 0, 24);
		cells[1][4] = new Cell(0x000099, 2, 25);
		cells[1][5] = new Cell(0xffffff, 0, 26);
		cells[1][6] = new Cell(0xffffff, 0, 27);
		cells[1][7] = new Cell(0x6699ff, 1, 28);
		cells[1][8] = new Cell(0xff99ff, 0, 29);

		cells[2][0] = new Cell(0xcc0000, 0, 31);
		cells[2][1] = new Cell(0xffffff, 0, 32);
		cells[2][2] = new Cell(0x6699ff, 3, 33);
		cells[2][3] = new Cell(0xffffff, 0, 34);
		cells[2][4] = new Cell(0x000099, 4, 35);
		cells[2][5] = new Cell(0xffffff, 0, 36);
		cells[2][6] = new Cell(0x6699ff, 3, 37);
		cells[2][7] = new Cell(0xffffff, 0, 38);
		cells[2][8] = new Cell(0xcc0000, 0, 39);

		cells[3][0] = new Cell(0xff99ff, 0, 41);
		cells[3][1] = new Cell(0xffffff, 0, 42);
		cells[3][2] = new Cell(0xffffff, 0, 43);
		cells[3][3] = new Cell(0x6699ff, 5, 44);
		cells[3][4] = new Cell(0x000099, 6, 45);
		cells[3][5] = new Cell(0x6699ff, 5, 46);
		cells[3][6] = new Cell(0xffffff, 0, 47);
		cells[3][7] = new Cell(0xffffff, 0, 48);
		cells[3][8] = new Cell(0xff99ff, 0, 49);

		cells[4][0] = new Cell(0xcc0000, 0, 51);
		cells[4][1] = new Cell(0x000099, 2, 52);
		cells[4][2] = new Cell(0x000099, 4, 53);
		cells[4][3] = new Cell(0x000099, 6, 54);
		cells[4][4] = new Cell(0x000000, 0, 55);
		cells[4][5] = new Cell(0x000099, 6, 56);
		cells[4][6] = new Cell(0x000099, 4, 57);
		cells[4][7] = new Cell(0x000099, 2, 58);
		cells[4][8] = new Cell(0xcc0000, 0, 59);

		cells[5][0] = new Cell(0xff99ff, 0, 61);
		cells[5][1] = new Cell(0xffffff, 0, 62);
		cells[5][2] = new Cell(0xffffff, 0, 63);
		cells[5][3] = new Cell(0x6699ff, 5, 64);
		cells[5][4] = new Cell(0x000099, 6, 65);
		cells[5][5] = new Cell(0x6699ff, 5, 66);
		cells[5][6] = new Cell(0xffffff, 0, 67);
		cells[5][7] = new Cell(0xffffff, 0, 68);
		cells[5][8] = new Cell(0xff99ff, 0, 69);

		cells[6][0] = new Cell(0xcc0000, 0, 71);
		cells[6][1] = new Cell(0xffffff, 0, 72);
		cells[6][2] = new Cell(0x6699ff, 3, 73);
		cells[6][3] = new Cell(0xffffff, 0, 74);
		cells[6][4] = new Cell(0x000099, 4, 75);
		cells[6][5] = new Cell(0xffffff, 0, 76);
		cells[6][6] = new Cell(0x6699ff, 3, 77);
		cells[6][7] = new Cell(0xffffff, 0, 78);
		cells[6][8] = new Cell(0xcc0000, 0, 79);

		cells[7][0] = new Cell(0xff99ff, 0, 81);
		cells[7][1] = new Cell(0x6699ff, 1, 82);
		cells[7][2] = new Cell(0xffffff, 0, 83);
		cells[7][3] = new Cell(0xffffff, 0, 84);
		cells[7][4] = new Cell(0x000099, 2, 85);
		cells[7][5] = new Cell(0xffffff, 0, 86);
		cells[7][6] = new Cell(0xffffff, 0, 87);
		cells[7][7] = new Cell(0x6699ff, 1, 88);
		cells[7][8] = new Cell(0xff99ff, 0, 89);

		cells[8][0] = new Cell(0xcc0000, 0, 91);
		cells[8][1] = new Cell(0xff99ff, 0, 92);
		cells[8][2] = new Cell(0xcc0000, 0, 93);
		cells[8][3] = new Cell(0xff99ff, 0, 94);
		cells[8][4] = new Cell(0xcc0000, 0, 95);
		cells[8][5] = new Cell(0xff99ff, 0, 96);
		cells[8][6] = new Cell(0xcc0000, 0, 97);
		cells[8][7] = new Cell(0xff99ff, 0, 98);
		cells[8][8] = new Cell(0xcc0000, 0, 99);

		for (int i = 0; i < figures.length; i++) {
			for (int j = 0; j < figures[i].length; j++) {
				figures[i][j] = null;
			}
		}

		for (int i = 0; i < aura.length; i++) {
			for (int j = 0; j < aura[i].length; j++) {
				aura[i][j] = false;
			}
		}
	}

	private void clearAura() {
		for (int i = 0; i < aura.length; i++) {
			for (int j = 0; j < aura[i].length; j++) {
				aura[i][j] = false;
			}
		}
	}

	private Figure lineUpSelection() {
		for (Enemy key : lineups.keySet()) {
			for (Figure figure : lineups.get(key)) {
				if (figure != null && figure.isSelected() == true) {
					return figure;
				}
			}
		}

		return null;
	}

	private void unselectAll() {
		for (Figure figure : pile[Enemy.DARK.index()]) {
			figure.unselect();
		}
		for (Figure figure : pile[Enemy.LIGHT.index()]) {
			figure.unselect();
		}
	}

	/**
	 * Cells where the figure can be placed.
	 */
	private boolean[][] placement(Figure figure) {
		boolean places[][] = new boolean[SIZE][SIZE];
		return places;
	}

	/**
	 * Evaluate line in particular direction given by dx and dy.
	 * 
	 * @param i
	 * @param j
	 * @param dx
	 * @param dy
	 * @param five
	 * @return
	 */
	private int evaluate(int i, int j, int dx, int dy, boolean five) {
		int result = 0;
		int score = 0;
		int count = 0;
		boolean central = false;
		boolean president = false;
		int counters[] = { 0, 0, 0, 0, 0 };
		for (int k = i, l = j; k < figures.length && l < figures[i].length
				&& k >= 0 && l >= 0; k += dx, l += dy, count++) {
			/*
			 * General: in a row of 6 or more figures only 5 count.
			 */
			if (count >= 5) {
				break;
			}

			/*
			 * No more figures in the line.
			 */
			if (figures[k][l] == null) {
				break;
			}

			/*
			 * End of the line, because next figure is not of the same player.
			 */
			if (figures[k][l].getEnemy() != figures[i][j].getEnemy()) {
				break;
			}

			/*
			 * Count figure from the same kind.
			 */
			counters[figures[k][l].index()]++;

			/*
			 * Pass through central cell.
			 */
			if (cells[k][l].getCoordinates() == 55) {
				central = true;
			}

			/*
			 * Check for president in the line.
			 */
			if (figures[k][l] instanceof President) {
				president = true;
			}

			score += cells[k][l].getPoints();
		}

		/*
		 * Apply multiplier rule.
		 */
		if (central == true || president == true) {
			int multiplier = 0;

			/*
			 * Estimate multiplier.
			 */
			Arrays.sort(counters);
			multiplier = counters[counters.length - 1];

			/*
			 * If there is a president in the combination then increase
			 * multiplier by one.
			 */
			if (president == true) {
				multiplier++;
			}

			score *= multiplier;
		}

		/*
		 * Report only lines with 5+ figures in them.
		 */
		if (score > result && five == false) {
			result = score;
		}
		if (score > result && count >= 5 && five == true) {
			result = score;
		}

		return result;
	}

	private int score(Enemy enemy, boolean five) {
		int result = 0;

		for (int i = 0, score; i < figures.length; i++) {
			for (int j = 0; j < figures[i].length; j++) {
				/*
				 * Do not search if there is no figure in the cell.
				 */
				if (figures[i][j] == null) {
					continue;
				}

				if (figures[i][j].getEnemy() != enemy) {
					continue;
				}

				/*
				 * Check for horizontal line.
				 */
				score = evaluate(i, j, 1, 0, five);
				if (score > result) {
					result = score;
				}

				/*
				 * Check for vertical line.
				 */
				score = evaluate(i, j, 0, 1, five);
				if (score > result) {
					result = score;
				}

				/*
				 * Check for primary diagonal line.
				 */
				score = evaluate(i, j, 1, 1, five);
				if (score > result) {
					result = score;
				}

				/*
				 * Check for secondary diagonal line.
				 */
				score = evaluate(i, j, 1, -1, five);
				if (score > result) {
					result = score;
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @param enemy
	 * @return
	 */
	private int maxScoreWhithoutFiveInRow(Enemy enemy) {
		return score(enemy, false);
	}

	/**
	 * Search for win combination according player color. The function to return
	 * score or zero if there is no line of 5+.
	 * 
	 * @param enemy
	 * @return
	 */
	private int maxScoreWithFiveInRow(Enemy enemy) {
		return score(enemy, true);
	}

	/**
	 * Check for win combination possibility.
	 * 
	 * @param enemy
	 * @return
	 */
	private boolean hasMoreThanFour(Enemy enemy) {
		int count = 0;

		/*
		 * Line-up check.
		 */
		for (Figure figure : lineups.get(enemy)) {
			if (figure != null) {
				count++;
			}
		}

		/*
		 * Playing field check.
		 */
		for (int i = 0; i < figures.length; i++) {
			for (int j = 0; j < figures[i].length; j++) {
				if (figures[i][j] == null) {
					continue;
				}

				if (figures[i][j].getEnemy() == enemy) {
					count++;
				}
			}
		}

		/*
		 * 
		 */
		if (count >= 5) {
			return true;
		}

		return false;
	}

	/**
	 * Check for president in the line-up or on the playing field.
	 * 
	 * @param enemy
	 * @return
	 */
	private boolean hasAlivePresident(Enemy enemy) {
		/*
		 * Line-up check.
		 */
		for (Figure figure : lineups.get(enemy)) {
			if (figure == null) {
				continue;
			}

			if (figure instanceof President) {
				return true;
			}
		}

		/*
		 * Playing field check.
		 */
		for (int i = 0; i < figures.length; i++) {
			for (int j = 0; j < figures[i].length; j++) {
				if (figures[i][j] == null) {
					continue;
				}

				if (figures[i][j] instanceof President) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Check line-up empty and playing filed retirement cells.
	 * 
	 * @param enemy
	 * @return
	 */
	private boolean allFiguresBlocked(Enemy enemy) {
		/*
		 * Line-up check.
		 */
		for (Figure figure : lineups.get(enemy)) {
			if (figure != null && figure instanceof President == false) {
				return false;
			}
		}

		/*
		 * Part of playing field check.
		 */
		for (int i = 1; i < figures.length - 1; i++) {
			for (int j = 1; j < figures[i].length - 1; j++) {
				if (figures[i][j] == null) {
					continue;
				}

				/*
				 * President does not count for blocking.
				 */
				if (figures[i][j] instanceof President) {
					continue;
				}

				/*
				 * Civil servants are always blocked on the playing filed.
				 */
				if (figures[i][j] instanceof Servant) {
					continue;
				}

				if (figures[i][j].getEnemy() == enemy) {
					return false;
				}
			}
		}

		return true;
	}

	private void spreadAura() {
		clearAura();

		for (int i = 0; i < aura.length; i++) {
			for (int j = 0; j < aura[i].length; j++) {
				if (figures[i][j] == null) {
					continue;
				}

				if (figures[i][j] instanceof Servant == false) {
					continue;
				}

				for (int k = i - 1; k <= i + 1; k++) {
					for (int l = j - 1; l <= j + 1; l++) {
						if (k < 0) {
							continue;
						}
						if (l < 0) {
							continue;
						}
						if (k >= aura.length) {
							continue;
						}
						if (l >= aura[k].length) {
							continue;
						}

						aura[k][l] = true;
					}
				}
			}
		}
	}

	public Figure[][] getFigures() {
		return figures;
	}

	public Map<Enemy, Vector<Figure>> getLineups() {
		return lineups;
	}

	public State getState() {
		return state;
	}

	public boolean lineUpClick(int index, Enemy enemy) {
		Figure figure = lineups.get(enemy).elementAt(index);

		if (figure == null) {
			return false;
		}
		
		/*
		 * Block all players except the player who turn is.
		 */
		if (turn % Enemy.values().length != figure.getEnemy().index()) {
			return false;
		}

		if (figure.isSelected() == true) {
			figure.unselect();
		} else if (figure.isUnselected() == true) {
			unselectAll();
			figure.select();
		}
		
		return true;
	}

	public boolean fieldClick(int i, int j) {
		Figure figure = figures[i][j];

		if (figure == null) {
			// TODO If selected in line-up then place it in the playing field
			// (check is it possible to be placed).
			Figure selected = lineUpSelection();
			if (selected == null) {
				return false;
			} else {
				// TODO Check for possible placement.

				/*
				 * Place it in the playing field.
				 */
				figures[i][j] = selected;
				spreadAura();

				/*
				 * Remove from line-up.
				 */
				for (Enemy key : lineups.keySet()) {
					if (lineups.get(key).contains(selected) == true) {
						int index = lineups.get(key).indexOf(selected);
						lineups.get(key).set(index, null);
						selected.unselect();

						// TODO Handle aura if needed.

						return true;
					}
				}

				return false;
			}

			// TODO If selected in the playing field then move it (take enemy's
			// figure).
		}

		/*
		 * Block all players except the player who turn is.
		 */
		if (turn % Enemy.values().length != figure.getEnemy().index()) {
			return false;
		}

		/*
		 * Select figure in the playing field.
		 */
		unselectAll();
		figure.select();
		
		return false;
	}

	public void nextTurn() {
		turn++;
	}
	
	/**
	 * Check for win situation.
	 * 
	 * @param enemy
	 * @return Zero if player is not a winner. Wining score if the player is a
	 *         winner.
	 */
	public Object[] winner() {
		/*
		 * Check for the previous player.
		 */
		Enemy enemy = Enemy.value(turn % Enemy.values().length);

		int score = 0;

		/*
		 * Win by line of five.
		 */
		score = maxScoreWithFiveInRow(enemy);
		if (score > 0) {
			state = State.FINISHED;
			return new Object[] { enemy, score };
		}

		/*
		 * Beat opponent's president.
		 */
		if (hasAlivePresident(enemy.opponent()) == false) {
			state = State.FINISHED;
			score = maxScoreWhithoutFiveInRow(enemy);
			return new Object[] { enemy, score };
		}

		/*
		 * Opponent is out of available figures.
		 */
		if (hasMoreThanFour(enemy.opponent()) == false) {
			state = State.FINISHED;
			score = maxScoreWhithoutFiveInRow(enemy);
			return new Object[] { enemy, score };
		}

		/*
		 * Opponent is blocked.
		 */
		if (allFiguresBlocked(enemy.opponent()) == true) {
			state = State.FINISHED;
			score = maxScoreWhithoutFiveInRow(enemy);
			return new Object[] { enemy, score };
		}

		return new Object[] { enemy, 0 };
	}
}
