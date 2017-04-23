package sindhu.connectivity.quickfind;

import static org.junit.Assert.*;

import org.junit.Test;


public class QuickFindAlgoTest {

    @Test
    public void testUnionTwoItems() {
        QuickFindAlgo algo = new QuickFindAlgo(5); // {0 1 2 3 4}
        int[] input = algo.getInput();

        algo.union(0, 1);
        // expected {1 1 2 3 4}
        assertEquals(1, input[0]);

        algo.union(3, 4);
        // expected {1 1 2 4 4}
        assertEquals(4, input[3]);

        algo.union(0, 4);
        // expected {4 4 2 4 4}
        assertEquals(4, input[0]);
    }

    @Test
    public void testIsConnected() {
        QuickFindAlgo algo = new QuickFindAlgo(5); // {0 1 2 3 4}
        int[] array = algo.getInput();
        array[0] = 1;
        assertTrue(algo.isConnected(0, 1));
    }

}
