package sindhu.connectivity.quickfind;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickUnionAlgoTest {

	@Test
	public void testUnionTwoItems() {
		QuickUnionAlgo algo = new QuickUnionAlgo(5); // {0 1 2 3 4}
		int[] input = algo.getInput();

		algo.union(0, 1);
		// expected {1 1 2 3 4}
		assertEquals(1, input[0]);

		algo.union(3, 4);
		// expected {1 1 2 4 4}
		assertEquals(4, input[3]);

		algo.union(0, 4);
		// expected {4 1 2 4 4}
		assertEquals(4, input[0]);

		algo.union(1, 2);
		// expected {4 2 2 4 4}
		assertEquals(2, input[1]);
		
		algo.union(4, 1);
		// expected {4 2 2 4 2}
		assertEquals(2, input[4]);
	}

	@Test
	public void testIsConnected() {
		QuickUnionAlgo algo = new QuickUnionAlgo(5); // {0 1 2 3 4}
		int[] array = algo.getInput();
		
		// union of (0,1), (0,4), (1,2), (4,1)) ==> {4 2 2 3 2}
		array[0] = 4;
		array[1] = 2;
		array[2] = 2;
		array[3] = 3;
		array[4] = 2;
		
		// Connected components {0, 1, 2, 4} {3}}
		assertTrue(algo.isConnected(0, 1));
		assertTrue(algo.isConnected(4, 0));
		assertTrue(algo.isConnected(2, 4));
		assertTrue(algo.isConnected(1, 4));
		assertFalse(algo.isConnected(3, 4));

	}
}
