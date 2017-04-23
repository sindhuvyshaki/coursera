import static org.junit.Assert.*;

import org.junit.Test;

public class PercolationTest {

	@Test
	public void testZero() {
		try {
			Percolation percolation = new Percolation(0);
			percolation.open(5, 5);
			fail("Should not have reached this point.");
		} catch (IllegalArgumentException ex) {
			// success
		}
	}

	@Test
	public void testOpen() {
		Percolation percolation = new Percolation(10);
		percolation.open(5, 5);
		assertEquals(55, percolation.getGrid()[5][5]);
		assertTrue(percolation.isOpen(5, 5));
	}

	@Test
	public void testOpen2Nodes() {
		Percolation percolation = new Percolation(10);
		percolation.open(5, 5);
		assertTrue(percolation.isOpen(5, 5));
		assertEquals(55, percolation.getGrid()[5][5]);

		percolation.open(5, 6);
		assertTrue(percolation.isOpen(5, 6));
		assertEquals(55, percolation.getGrid()[5][6]);
		assertEquals(2, percolation.numberOfOpenSites());
	}

	@Test
	public void testOpen5Nodes() {
		Percolation percolation = new Percolation(10);
		percolation.open(5, 5);
		assertTrue(percolation.isOpen(5, 5));
		assertEquals(55, percolation.getGrid()[5][5]);
		assertEquals(1, percolation.getTreeSize()[5][5]);

		percolation.open(5, 6);
		assertTrue(percolation.isOpen(5, 6));
		assertEquals(55, percolation.getGrid()[5][6]);
		assertEquals(2, percolation.numberOfOpenSites());
		assertEquals(2, percolation.getTreeSize()[5][5]);
		assertEquals(1, percolation.getTreeSize()[5][6]);

		percolation.open(6, 7);
		assertTrue(percolation.isOpen(6, 7));
		assertEquals(67, percolation.getGrid()[6][7]);
		assertEquals(3, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[6][7]);

		percolation.open(7, 8);
		assertTrue(percolation.isOpen(7, 8));
		assertEquals(78, percolation.getGrid()[7][8]);
		assertEquals(4, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][8]);

		percolation.open(7, 7);
		assertTrue(percolation.isOpen(7, 7));
		assertEquals(67, percolation.getGrid()[7][7]);
		assertEquals(5, percolation.numberOfOpenSites());
		assertEquals(3, percolation.getTreeSize()[6][7]);

		assertTrue(percolation.isOpen(7, 8));
		assertEquals(67, percolation.getGrid()[7][8]);
		assertEquals(5, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][8]);

		PercolationStats.printGrid(percolation.getGrid(), 10);
	}
	
	@Test
	public void testFull() {
		Percolation percolation = new Percolation(10);
		percolation.open(5, 5);
		assertTrue(percolation.isOpen(5, 5));
		assertEquals(55, percolation.getGrid()[5][5]);
		assertEquals(1, percolation.getTreeSize()[5][5]);

		percolation.open(5, 6);
		assertTrue(percolation.isOpen(5, 6));
		assertEquals(55, percolation.getGrid()[5][6]);
		assertEquals(2, percolation.numberOfOpenSites());
		assertEquals(2, percolation.getTreeSize()[5][5]);
		assertEquals(1, percolation.getTreeSize()[5][6]);

		percolation.open(6, 7);
		assertTrue(percolation.isOpen(6, 7));
		assertEquals(67, percolation.getGrid()[6][7]);
		assertEquals(3, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[6][7]);

		percolation.open(7, 8);
		assertTrue(percolation.isOpen(7, 8));
		assertEquals(78, percolation.getGrid()[7][8]);
		assertEquals(4, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][8]);

		percolation.open(7, 7);
		assertTrue(percolation.isOpen(7, 7));
		assertEquals(67, percolation.getGrid()[7][7]);
		assertEquals(5, percolation.numberOfOpenSites());
		assertEquals(3, percolation.getTreeSize()[6][7]);

		assertTrue(percolation.isOpen(7, 8));
		assertEquals(67, percolation.getGrid()[7][8]);
		assertEquals(5, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][8]);

		percolation.open(4, 5);
		assertTrue(percolation.isOpen(4, 5));
		assertEquals(55, percolation.getGrid()[4][5]);
		assertEquals(3, percolation.getTreeSize()[5][5]);
		
		percolation.open(4, 6);
		assertTrue(percolation.isOpen(4, 6));
		assertEquals(55, percolation.getGrid()[4][6]);
		assertEquals(4, percolation.getTreeSize()[5][5]);
		
		percolation.open(3, 6);
		assertTrue(percolation.isOpen(3, 6));
		assertEquals(55, percolation.getGrid()[3][6]);
		assertEquals(5, percolation.getTreeSize()[5][5]);
		
		percolation.open(2, 6);
		assertTrue(percolation.isOpen(2, 6));
		assertEquals(55, percolation.getGrid()[2][6]);
		assertEquals(6, percolation.getTreeSize()[5][5]);
		
		percolation.open(1, 6);
		assertTrue(percolation.isOpen(1, 6));
		assertEquals(55, percolation.getGrid()[1][6]);
		assertEquals(7, percolation.getTreeSize()[5][5]);
		
		percolation.open(0, 6);
		assertTrue(percolation.isOpen(0, 6));
		assertEquals(55, percolation.getGrid()[0][6]);
		assertEquals(8, percolation.getTreeSize()[5][5]);

		percolation.open(7, 9);
		assertTrue(percolation.isOpen(7, 9));
		assertEquals(67, percolation.getGrid()[7][9]);
		assertEquals(12, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][9]);

		assertFalse(percolation.isFull(7, 9));
		
		percolation.open(6, 6);
		assertTrue(percolation.isOpen(6, 6));
		assertEquals(55, percolation.getGrid()[6][6]);
		assertEquals(13, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[6][6]);
		assertEquals(55, percolation.getGrid()[6][7]);
		assertTrue(percolation.isFull(7, 9));
		PercolationStats.printGrid(percolation.getGrid(), 10);
	}

	@Test
	public void testPercolates() {
		Percolation percolation = new Percolation(10);
		percolation.open(5, 5);
		assertTrue(percolation.isOpen(5, 5));
		assertEquals(55, percolation.getGrid()[5][5]);
		assertEquals(1, percolation.getTreeSize()[5][5]);

		percolation.open(5, 6);
		assertTrue(percolation.isOpen(5, 6));
		assertEquals(55, percolation.getGrid()[5][6]);
		assertEquals(2, percolation.numberOfOpenSites());
		assertEquals(2, percolation.getTreeSize()[5][5]);
		assertEquals(1, percolation.getTreeSize()[5][6]);

		percolation.open(6, 7);
		assertTrue(percolation.isOpen(6, 7));
		assertEquals(67, percolation.getGrid()[6][7]);
		assertEquals(3, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[6][7]);

		percolation.open(7, 8);
		assertTrue(percolation.isOpen(7, 8));
		assertEquals(78, percolation.getGrid()[7][8]);
		assertEquals(4, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][8]);

		percolation.open(7, 7);
		assertTrue(percolation.isOpen(7, 7));
		assertEquals(67, percolation.getGrid()[7][7]);
		assertEquals(5, percolation.numberOfOpenSites());
		assertEquals(3, percolation.getTreeSize()[6][7]);

		assertTrue(percolation.isOpen(7, 8));
		assertEquals(67, percolation.getGrid()[7][8]);
		assertEquals(5, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][8]);

		percolation.open(4, 5);
		assertTrue(percolation.isOpen(4, 5));
		assertEquals(55, percolation.getGrid()[4][5]);
		assertEquals(3, percolation.getTreeSize()[5][5]);
		
		percolation.open(4, 6);
		assertTrue(percolation.isOpen(4, 6));
		assertEquals(55, percolation.getGrid()[4][6]);
		assertEquals(4, percolation.getTreeSize()[5][5]);
		
		percolation.open(3, 6);
		assertTrue(percolation.isOpen(3, 6));
		assertEquals(55, percolation.getGrid()[3][6]);
		assertEquals(5, percolation.getTreeSize()[5][5]);
		
		percolation.open(2, 6);
		assertTrue(percolation.isOpen(2, 6));
		assertEquals(55, percolation.getGrid()[2][6]);
		assertEquals(6, percolation.getTreeSize()[5][5]);
		
		percolation.open(1, 6);
		assertTrue(percolation.isOpen(1, 6));
		assertEquals(55, percolation.getGrid()[1][6]);
		assertEquals(7, percolation.getTreeSize()[5][5]);
		
		percolation.open(0, 6);
		assertTrue(percolation.isOpen(0, 6));
		assertEquals(55, percolation.getGrid()[0][6]);
		assertEquals(8, percolation.getTreeSize()[5][5]);

		percolation.open(7, 9);
		assertTrue(percolation.isOpen(7, 9));
		assertEquals(67, percolation.getGrid()[7][9]);
		assertEquals(12, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[7][9]);

		assertFalse(percolation.isFull(7, 9));
		
		percolation.open(6, 6);
		assertTrue(percolation.isOpen(6, 6));
		assertEquals(55, percolation.getGrid()[6][6]);
		assertEquals(13, percolation.numberOfOpenSites());
		assertEquals(1, percolation.getTreeSize()[6][6]);
		
		assertEquals(55, percolation.getGrid()[6][7]);
		assertEquals(4, percolation.getTreeSize()[6][7]);

		assertTrue(percolation.isFull(7, 9));
		
		percolation.open(8, 9);
		assertTrue(percolation.isOpen(8, 9));
		assertEquals(55, percolation.getGrid()[8][9]);
		assertEquals(14, percolation.numberOfOpenSites());
		assertEquals(4, percolation.getTreeSize()[6][7]);
		assertEquals(14, percolation.getTreeSize()[5][5]);
		
		percolation.open(9, 9);
		assertTrue(percolation.isOpen(9, 9));
		assertEquals(55, percolation.getGrid()[9][9]);
		assertEquals(15, percolation.numberOfOpenSites());
		assertEquals(4, percolation.getTreeSize()[6][7]);
		assertEquals(15, percolation.getTreeSize()[5][5]);
		
		assertTrue(percolation.isFull(7, 9));
		assertTrue(percolation.percolates());
		PercolationStats.printGrid(percolation.getGrid(), 10);
	}
}
