package sindhu.connectivity.quickfind;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeightedQuickUnionAlgoTest {

	@Test
	public void testUnion() {
		WeightedQuickUnionAlgo algo = new WeightedQuickUnionAlgo(5); // {0 1 2 3 4}
		int[] array = algo.getInput();
		algo.union(0, 1);
		// expected {1 1 2 3 4}  1 > 0
		assertEquals(1, array[0]);
		
		algo.union(0, 2);
		// expected {1 1 1 3 4}
		assertEquals(1, array[2]);
		
		algo.union(3, 4);
		// expected {1 1 1 4 4}
		assertEquals(4, array[3]);
		
		algo.union(4, 0);
		// expected {1 1 1 4 1}
		assertEquals(1, array[1]);
		assertEquals(1, array[4]);
		
		assertTrue(algo.isConnected(0, 4));
	}

}
