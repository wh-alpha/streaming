package streaming.mosaic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TreeTests {

	private Tree tree;
	@Before
	public void setUp() throws Exception {
		tree = Tree.createTree(5);
		tree.init();
	}
	
	@Test
	public void testConstructorLevel() {
		assertNull(Tree.createTree(0));
	}

	@Test
	public void testConstructor() {
		String values = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]";
		String nodes = tree.toString();
		assertTrue(nodes.contains(values));
	}

	@Test
	public void testIndexWithinBoundary1() {
		assertTrue(tree.index(4, 2) == 7);
	}
	
	@Test
	public void testIndexWithinBoundary2() {
		assertTrue(tree.index(1, 1) == 0);
	}
	
	@Test
	public void testIndexBeyondLevel() {
		assertTrue(tree.index(6, 2) == -1);
	}
	
	@Test
	public void testIndexBeyondNum() {
		assertTrue(tree.index(4, 5) == -1);
	}
}
