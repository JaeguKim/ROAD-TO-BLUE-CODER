package prob871;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        sol.minRefuelStops(100,50,new int[][]{{25,50},{50,25}});
    }
}
