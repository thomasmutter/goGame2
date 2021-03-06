package goTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import goGame.Board;
import goGame.CapturedRefV2;
import goGame.StoneColor;

class CapturedRefV2Test {
	private CapturedRefV2 ref;
	private Board board;
	private StoneColor b;
	private StoneColor w;
	private int dim;

	@BeforeEach
	void setUp() throws Exception {
		dim = 5;
		board = new Board(dim);
		ref = new CapturedRefV2(board);
		b = StoneColor.BLACK;
		w = StoneColor.WHITE;
	}

	@Test
	void testCaptureScenario1() {
		board.placeStone(1, 2, StoneColor.BLACK);
		board.placeStone(2, 1, StoneColor.BLACK);
		board.placeStone(3, 2, StoneColor.BLACK);
		board.placeStone(2, 3, StoneColor.BLACK);

		board.placeStone(2, 2, StoneColor.WHITE);

		assertEquals(1, ref.getAndSetStoneSet(2 * dim + 2).size());

	}

	@Test
	void testCaptureScenario2() {
		board.placeStone(0, 0, w);
		board.placeStone(1, 0, w);
		board.placeStone(0, 1, w);

		board.placeStone(0, 2, b);
		board.placeStone(2, 0, b);
		board.placeStone(1, 1, b);

		for (Integer i : ref.getAndSetStoneSet(0)) {
			System.out.println(board.getPointFromIndex(i).getColor());
		}
		System.out.println("");

		assertEquals(3, ref.getAndSetStoneSet(0 * dim + 0).size());

	}

	@Test
	void testCaptureScenario3() {
		board.placeStone(2, 2, b);
		board.placeStone(3, 2, b);
		board.placeStone(3, 3, b);
		board.placeStone(2, 3, b);

		board.placeStone(1, 1, w);
		board.placeStone(2, 1, w);
		board.placeStone(1, 2, w);
		board.placeStone(1, 3, w);
		board.placeStone(3, 1, w);
		board.placeStone(1, 4, w);
		board.placeStone(4, 1, w);
		board.placeStone(4, 2, w);
		board.placeStone(2, 4, w);
		board.placeStone(4, 3, w);
		board.placeStone(3, 4, w);
		board.placeStone(4, 4, w);

		assertEquals(4, ref.getAndSetStoneSet(2 * dim + 2).size());

	}

	@Test
	void testCaptureScenario4() {
		board.placeStone(2, 2, w);
		board.placeStone(3, 2, w);
		board.placeStone(3, 3, w);
		board.placeStone(2, 3, w);
		board.placeStone(1, 1, w);
		board.placeStone(2, 1, w);
		board.placeStone(1, 2, w);
		board.placeStone(1, 3, w);
		board.placeStone(3, 1, w);
		board.placeStone(1, 4, w);
		board.placeStone(4, 1, w);
		board.placeStone(4, 2, w);
		board.placeStone(2, 4, w);
		board.placeStone(4, 3, w);
		board.placeStone(3, 4, w);
		board.placeStone(4, 4, w);

		for (Integer i : ref.getAndSetStoneSet(2 * dim + 2)) {
			System.out.println(board.getPointFromIndex(i).getColor());
		}

		assertEquals(0, ref.getAndSetStoneSet(2 * dim + 2).size());
	}

	@Test
	void captureBySuicideScenario1() {
		board.placeStone(1, 2, w);
		board.placeStone(2, 1, w);
		board.placeStone(1, 1, w);
		board.placeStone(1, 3, w);
		board.placeStone(3, 1, w);
		board.placeStone(2, 3, w);
		board.placeStone(3, 2, w);
		board.placeStone(3, 3, w);

		board.placeStone(2, 2, b);

		board.placeStone(0, 0, b);
		board.placeStone(1, 0, b);
		board.placeStone(0, 1, b);
		board.placeStone(2, 0, b);
		board.placeStone(0, 2, b);
		board.placeStone(3, 0, b);
		board.placeStone(0, 3, b);
		board.placeStone(4, 0, b);
		board.placeStone(0, 4, b);
		board.placeStone(1, 4, b);
		board.placeStone(4, 1, b);
		board.placeStone(2, 4, b);
		board.placeStone(4, 2, b);
		board.placeStone(3, 4, b);
		board.placeStone(4, 3, b);
		board.placeStone(4, 4, b);

		for (Integer i : ref.getAndSetStoneSet(2 * dim + 2)) {
			System.out.println(board.getPointFromIndex(i).getColor());
		}
		System.out.println("");

		assertEquals(8, ref.getAndSetStoneSet(2 * dim + 2).size());
	}

	@Test
	void capturedLiberties1() {
		board.placeStone(0, 2, b);
		board.placeStone(2, 0, b);
		board.placeStone(1, 1, b);

		board.placeStone(4, 4, w);

		for (Integer i : ref.getAndSetLibertySet(2)) {
			System.out.println(board.getPointFromIndex(i).getColor());
		}
		System.out.println("");

		assertEquals(3, ref.getAndSetLibertySet(2).size());
	}

	@Test
	void capturedLiberties2() {
		board.placeStoneFromIndex(0, b);
		board.placeStoneFromIndex(1, b);
		board.placeStoneFromIndex(2, b);
		board.placeStoneFromIndex(3, b);
		board.placeStoneFromIndex(5, b);
		board.placeStoneFromIndex(8, b);
		board.placeStoneFromIndex(10, b);
		board.placeStoneFromIndex(11, b);
		board.placeStoneFromIndex(12, b);
		board.placeStoneFromIndex(13, b);

		for (Integer i : ref.getAndSetLibertySet(5)) {
			System.out.println(board.getPointFromIndex(i).getColor());
		}
		System.out.println("");

		assertEquals(2, ref.getAndSetLibertySet(5).size());

		for (Integer i : ref.getAndSetLibertySet(5)) {
			System.out.println(board.getPointFromIndex(i).getColor());
			System.out.println(i);
		}
		System.out.println("");

		assertEquals(0, ref.getAndSetStoneSet(5).size());

		for (Integer i : ref.getAndSetLibertySet(12)) {
			System.out.println(board.getPointFromIndex(i).getColor());
			System.out.println(i);
		}
		System.out.println("");

		assertEquals(15, ref.getAndSetLibertySet(12).size());

		board.placeStoneFromIndex(20, w);

		assertEquals(2, ref.getAndSetLibertySet(12).size());
		assertEquals(0, ref.getAndSetLibertySet(20).size());
	}

	@Test
	void capturedLiberties3() {
		board.placeStoneFromIndex(2, w);
		board.placeStoneFromIndex(6, w);
		board.placeStoneFromIndex(12, w);
		board.placeStoneFromIndex(18, w);
		board.placeStoneFromIndex(14, w);

		board.placeStoneFromIndex(0, b);

		for (Integer i : ref.getAndSetLibertySet(18)) {
			System.out.println(board.getPointFromIndex(i).getColor());
		}
		System.out.println("");

		assertEquals(6, ref.getAndSetLibertySet(18).size());

	}

	@Test
	void captureStoneAndLiberty1() {
		board.placeStoneFromIndex(0, b);
		board.placeStoneFromIndex(1, b);
		board.placeStoneFromIndex(2, b);
		board.placeStoneFromIndex(3, b);
		board.placeStoneFromIndex(5, b);
		board.placeStoneFromIndex(8, b);
		board.placeStoneFromIndex(10, b);
		board.placeStoneFromIndex(11, b);
		board.placeStoneFromIndex(12, b);
		board.placeStoneFromIndex(14, b);
		board.placeStoneFromIndex(18, b);

		board.placeStoneFromIndex(13, w);

//		for (Integer i : ref.getAndSetLibertySet(18)) {
//			System.out.println(board.getPointFromIndex(i).getColor());
//			System.out.println(i);
//		}
//		System.out.println("");
//		System.out.println("");

		assertEquals(9, ref.getAndSetLibertySet(18).size());

//		for (Integer i : ref.getAndSetStoneSet(18)) {
//			System.out.println(board.getPointFromIndex(i).getColor());
//		}
//		System.out.println("");

		assertEquals(1, ref.getAndSetStoneSet(18).size());

	}

}
