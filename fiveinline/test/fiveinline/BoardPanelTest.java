package fiveinline;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardPanelTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFiveInRowTrue() {
		BoardPanel board = new BoardPanel();
		board.chesses[2][3].color = Chess.WHITE; 
		board.chesses[2][4].color = Chess.WHITE; 
		board.chesses[2][5].color = Chess.WHITE; 
		board.chesses[2][6].color = Chess.WHITE; 
		board.chesses[2][7].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(actual);
	}

	@Test
	void testFiveInRowFalse() {
		BoardPanel board = new BoardPanel();
		board.chesses[2][3].color = Chess.WHITE; 
		board.chesses[2][4].color = Chess.BLACK; 
		board.chesses[2][5].color = Chess.WHITE; 
		board.chesses[2][6].color = Chess.WHITE; 
		board.chesses[2][7].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(!actual);
	}

	@Test
	void testFiveInColumnTrue() {
		BoardPanel board = new BoardPanel();
		board.chesses[3][3].color = Chess.WHITE; 
		board.chesses[4][3].color = Chess.WHITE; 
		board.chesses[5][3].color = Chess.WHITE; 
		board.chesses[6][3].color = Chess.WHITE; 
		board.chesses[7][3].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(actual);
	}

	@Test
	void testFiveInColumnFalse() {
		BoardPanel board = new BoardPanel();
		board.chesses[3][3].color = Chess.BLACK; 
		board.chesses[4][3].color = Chess.WHITE; 
		board.chesses[5][3].color = Chess.WHITE; 
		board.chesses[6][3].color = Chess.WHITE; 
		board.chesses[7][3].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(!actual);
	}

	@Test
	void testFiveInBackslashTrue() {
		BoardPanel board = new BoardPanel();
		board.chesses[3][4].color = Chess.WHITE; 
		board.chesses[4][5].color = Chess.WHITE; 
		board.chesses[5][6].color = Chess.WHITE; 
		board.chesses[6][7].color = Chess.WHITE; 
		board.chesses[7][8].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(actual);
	}

	@Test
	void testFiveInBackslashFalse() {
		BoardPanel board = new BoardPanel();
		board.chesses[3][4].color = Chess.WHITE; 
		board.chesses[4][5].color = Chess.BLACK; 
		board.chesses[5][6].color = Chess.WHITE; 
		board.chesses[6][7].color = Chess.WHITE; 
		board.chesses[7][8].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(!actual);
	}

	@Test
	void testFiveInForwardslashTrue() {
		BoardPanel board = new BoardPanel();
		board.chesses[14][0].color = Chess.WHITE; 
		board.chesses[13][1].color = Chess.WHITE; 
		board.chesses[12][2].color = Chess.WHITE; 
		board.chesses[11][3].color = Chess.WHITE; 
		board.chesses[10][4].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(actual);
	}

	@Test
	void testFiveInForwardslashFalse() {
		BoardPanel board = new BoardPanel();
		board.chesses[14][0].color = Chess.WHITE; 
		board.chesses[13][1].color = Chess.BLACK; 
		board.chesses[12][2].color = Chess.WHITE; 
		board.chesses[11][3].color = Chess.WHITE; 
		board.chesses[10][4].color = Chess.WHITE; 
		boolean actual = board.fiveInLine();
		assertTrue(!actual);
	}


}
