package sindhu.connectivity.quickfind;

public class WeightedQuickUnionAlgo extends QuickUnionAlgo {

	private int[] size;
	public WeightedQuickUnionAlgo(int inputArraySize) {
		super(inputArraySize);
		size = new int[array.length];
		for (int index = 0; index < array.length; index ++) {
			size[index] = 1;
		}
	}

	@Override
	public void union(int indexP, int indexQ) {
		int rootP = getRoot(indexP);
		int rootQ = getRoot(indexQ);

		if (rootP == rootQ) {
			return;
		}

		if (size[rootP] <= size[rootQ]) {
			array[indexP] = rootQ;
			size[rootQ] += size[rootP];
		} else {
			array[indexQ] = rootP;
			size[rootP] += size[rootQ];
		}
	}

}
