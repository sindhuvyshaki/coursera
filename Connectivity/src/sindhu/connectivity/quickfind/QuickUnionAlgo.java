package sindhu.connectivity.quickfind;

public class QuickUnionAlgo extends QuickFindAlgo {

	public QuickUnionAlgo(int inputArraySize) {
		super(inputArraySize);
	}

	@Override
	public void union(int indexP, int indexQ) {
		array[indexP] = array[indexQ];
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

	private int getRoot(int index) {
		if (array[index] == index) {
			return index;
		}
		return getRoot(array[index]);
	}
}
