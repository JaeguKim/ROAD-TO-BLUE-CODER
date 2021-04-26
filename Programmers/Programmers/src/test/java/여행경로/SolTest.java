package 여행경로;

import org.junit.Assert;
import org.junit.Test;

public class SolTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        String[] res = new String[]{"ICN", "JFK", "HND", "IAD"};
        String[] actual = sol.solution(new String[][]{{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}});
        for (int i=0;i<res.length;i++) {
            Assert.assertEquals(res[i],actual[i]);
        }

    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        String[] res = new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
        String[] actual = sol.solution(new String[][]{{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}});
        for (int i=0;i<res.length;i++) {
            Assert.assertEquals(res[i],actual[i]);
        }
    }
}
