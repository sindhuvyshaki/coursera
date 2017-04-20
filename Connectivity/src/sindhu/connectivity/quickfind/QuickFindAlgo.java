package sindhu.connectivity.quickfind;

public class QuickFindAlgo {

	public QuickFindAlgo(int inputArraySize) {
		array = new int[inputArraySize];
		for (int index = 0; index < inputArraySize; index++) {
			array[index] = index;
		}
	}
	
	protected final int[] array;
	
	/**
	 * 0 1 2 3 4
	 * 
	 * (2,3)
	 * 0 1 3 3 4
	 * 
	 * (3,4)
	 * 0 1 4 4 4
	 * 
	 * Change value in first index wherever it exists.
	 * @param indexP
	 * @param indexQ
	 */
	public void union(int indexP, int indexQ) {
		for (int index = 0; index < array.length; index ++) {
			if (array[index] == array[indexP]) {
				array[index] = array[indexQ];
			}
		}
		return;
	}
	
	public boolean isConnected(int indexP, int indexQ) {
		if (array[indexP] == array[indexQ]) {
			return true;
		}
		return false;
	}

	public int[] getInput() {
		return array;
	}
}
