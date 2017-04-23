public class Percolation {
	private final int[][] grid;
	private final int[][] treeSize;
	private final int size;
	private int openSites = 0;

	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		size = n;
		grid = new int[n][n];
		treeSize = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				treeSize[i][j] = 1;
				grid[i][j] = -1;
			}
		}
	}

	private void validate(int row, int col) {
		if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
			throw new IllegalArgumentException();
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) {
		validate(row, col);
		grid[row][col] = row * size + col;

		unionByRows(row, col);
		unionByColumns(row, col);
		openSites++;
	}

	private void unionByRows(int row, int col) {
		if (row > 0 && row < size - 1) {
			union(row, col, row - 1, col);
			union(row, col, row + 1, col);
		} else if (row <= 0) {
			union(row, col, row + 1, col);
		} else if (row >= size - 1) {
			union(row, col, row - 1, col);
		}
	}

	private void unionByColumns(int row, int col) {
		if (col > 0 && col < size - 1) {
			union(row, col, row, col - 1);
			union(row, col, row, col + 1);
		} else if (col <= 0) {
			union(row, col, row, col + 1);
		} else if (col >= size - 1) {
			union(row, col, row, col - 1);
		}
	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		validate(row, col);
		return grid[row][col] == -1 ? false : true;
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		validate(row, col);
		for (int _col = 0; _col < size; _col++) {
			if (!isOpen(0, _col)) {
				continue;
			}
			if (isConnected(row, col, 0, _col)) {
				return true;
			}
		}
		return false;
	}

	// number of open sites
	public int numberOfOpenSites() {
		return openSites;
	}

	// does the system percolate?
	public boolean percolates() {
		for (int col = 0; col < size; col++) {
			if (!isOpen(size - 1, col)) {
				continue;
			}

			if (isFull(size - 1, col)) {
				return true;
			}
		}
		return false;
	}

	// test client (optional)
	public static void main(String[] args) {
	}

	public int[][] getGrid() {
		return grid;
	}

	private boolean isConnected(int x1, int y1, int x2, int y2) {
		return getRoot(x1, y1) == getRoot(x2, y2) ? true : false;
	}

	private void union(int newX, int newY, int x1, int y1) {
		if (!isOpen(x1, y1)) {
			return;
		}

		int rootXY = getRoot(newX, newY); // x * 5 + y
		int rootX1Y1 = getRoot(x1, y1);

		if (rootXY == rootX1Y1) {
			return;
		}

		if (treeSize[rootXY / size][rootXY % size] <= treeSize[rootX1Y1 / size][rootX1Y1 % size]) {
			grid[newX][newY] = grid[rootX1Y1 / size][rootX1Y1 % size];
			treeSize[rootX1Y1 / size][rootX1Y1 % size] += treeSize[rootXY / size][rootXY % size];
		} else {
			grid[rootX1Y1 / size][rootX1Y1 % size] = grid[newX][newY];
			treeSize[rootXY / size][rootXY % size] += treeSize[rootX1Y1 / size][rootX1Y1 % size];
		}
	}

	private int getRoot(int x, int y) {
		if (grid[x][y] == (x * size + y)) {
			return grid[x][y];
		}

		return getRoot(grid[x][y] / size, grid[x][y] % size);
	}

	public int[][] getTreeSize() {
		return treeSize;
	}
}
