package sindhu.connectivity.quickfind;

public class QuickUnionAlgo extends QuickFindAlgo {

	public QuickUnionAlgo(int inputArraySize) {
		super(inputArraySize);
	}

	@Override
	public void union(int indexP, int indexQ) {
		int rootP = getRoot(indexP);
		int rootQ = getRoot(indexQ);

		if (rootP == rootQ) {
			return;
		}
		array[rootP] = array[rootQ];
	}

	@Override
	public boolean isConnected(int indexP, int indexQ) {
		int pRoot = getRoot(indexP);
		int qRoot = getRoot(indexQ);

		if (pRoot == qRoot) {
			return true;
		}
		return false;
	}

	protected int getRoot(int index) {
		return array[index] == index ? index : getRoot(array[index]);
	}
}
