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
		
		int heightP = size[indexP];
		int heightQ = size[indexQ];

		if (heightP <= heightQ) {
			array[indexP] = rootQ;
			size[indexP] ++;
		} else {
			array[indexQ] = rootP;
			size[indexQ] ++;
		}
	}

}
