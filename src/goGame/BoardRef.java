package goGame;

import java.util.List;

import goExceptions.FormerBoardException;

public class BoardRef extends Referee {
	private List<String> playedBoards;

	public BoardRef(Board boardArg) {
		super(boardArg);
	}

	private boolean isNewBoard(String boardString) {
		return playedBoards.contains(boardString);
	}

	public void processBoard() throws FormerBoardException {
		String boardString = board.toString();
		if (isNewBoard(boardString)) {
			throw new FormerBoardException("This board configuration has already occured in the game.");
		} else {
			playedBoards.add(boardString);
		}
	}

}
