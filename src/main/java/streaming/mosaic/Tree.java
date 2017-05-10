/**
 * 
 */
package streaming.mosaic;

import java.util.Arrays;

public class Tree {

	private int[] nodes;
	
	/**
	 * @param level: the level of the tree 
	 * @return a Tree object, or null if level <= 0
	 */
	public static Tree createTree(int level) {
		return (level > 0) ? new Tree(level) : null;
	}
	
	/**
	 * @param level: the level of the tree 
	 */
	
	private Tree(int level) {
		int totalNodes = (level * (level+1))/2;
		nodes = new int[totalNodes];
	}
	
	/**
	 * init the nodes for testing
	 */
	public void init() {
		for (int i=0; i<nodes.length; i++) {
			nodes[i] = i;
		}
	}
	/**
	 * @param level: the level in the tree
	 * @param n: the nth node in the level
	 * @return the node, or -1 if the level or/and n is out of range
	 */
	public int index(int level, int n) {
		if (n > level) {
			return -1;
		}
		int pos = (level * (level-1))/2 + n;
		return (pos < nodes.length)? nodes[pos-1]: -1;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tree [nodes=" + Arrays.toString(nodes) + "]";
	}

}
