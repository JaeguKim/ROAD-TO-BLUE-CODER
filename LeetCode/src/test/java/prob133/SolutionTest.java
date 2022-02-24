package prob133;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.neighbors.add(node2);
        node2.neighbors.add(node);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node.neighbors.add(node3);
        node3.neighbors.add(node);
        Node res = sol.cloneGraph(node);

    }
}
