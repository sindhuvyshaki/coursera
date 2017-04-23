import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private int size;
	private int trials;
	private double[] thresholdArray;
	
	public PercolationStats(int n, int trials) {
		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException();
		}
		this.size = n;
		this.trials = trials;
	} // perform trials independent experiments on an n-by-n grid

	public double mean() {
		return StdStats.mean(thresholdArray);
	} // sample mean of percolation threshold

	public double stddev() {
		return StdStats.stddev(thresholdArray);
	} // sample standard deviation of percolation threshold

	public double confidenceLo() {
		return mean() - ((1.96 * stddev()) / Math.sqrt(trials));
	} // low endpoint of 95% confidence interval

	public double confidenceHi() {
		return mean() + ((1.96 * stddev()) / Math.sqrt(trials));
	} // high endpoint of 95% confidence interval

	private void printPermutation() {
		int[] randomizedArray = StdRandom.permutation(size * size);
		int[][] grid = new int[size][size];
		for (int i = 0; i < randomizedArray.length; i ++) {
			grid[randomizedArray[i] / size][randomizedArray[i] % size] = size;
			printGrid(grid, size);
		}
	}
	
	private static void printGrid(int[][] grid, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(grid[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int _size = Integer.parseInt(args[0]);
		int _trials = Integer.parseInt(args[1]);
		
		Percolation percolation = null;
		PercolationStats stats = new PercolationStats(_size, _trials);
//		stats.printPermutation();

		stats.thresholdArray = new double[stats.trials];

		int openCount = 0;
		int thresholdCount = 0;
		while (thresholdCount != stats.trials) {
			percolation = new Percolation(stats.size);
			int[] randomizedArray = StdRandom.permutation(stats.size * stats.size);
			for (int i = 0; i < stats.size * stats.size; i ++) {
				percolation.open(randomizedArray[i] / stats.size, randomizedArray[i] % stats.size);
				openCount ++;
				if (percolation.percolates()) {
					PercolationStats.printGrid(percolation.getGrid(), stats.size);
					System.out.println("Open sites : " + percolation.numberOfOpenSites());
					stats.thresholdArray[thresholdCount] = (double) openCount/ (stats.size * stats.size);
					thresholdCount ++;
					openCount = 0;
					break;
				}
			}
		}
		System.out.println("Mean of threshold : " + stats.mean());
		System.out.println("StdDev of threshold : " + stats.stddev());
		System.out.println("Lower endpoint 95% confidence " + stats.confidenceLo());
		System.out.println("Upper endpoint 95% confidence " + stats.confidenceHi());
	} // test client (described below)
}