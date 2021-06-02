package prob207;

import java.util.*;

class Solution {

    private Set<Integer> nonCycleSet = new HashSet<>();
    public boolean dfs(int cur, Map<Integer,List<Integer>> graph, Set<Integer> set) {
        if (nonCycleSet.contains(cur)) return true;
        if (set.contains(cur)) return false;
        set.add(cur);
        if (graph.containsKey(cur)) {
            for (int adjNode : graph.get(cur)) {
                boolean res = dfs(adjNode,graph,set);
                if (res == false) return false;
            }
        }
        set.remove(cur);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] arr : prerequisites) {
            if (!graph.containsKey(arr[0])) graph.put(arr[0],new ArrayList<>());
            graph.get(arr[0]).add(arr[1]);
        }
        for (int key : graph.keySet()) {
            if (dfs(key,graph, new HashSet<>()) == false) return false;
            nonCycleSet.add(key);
        }
        return true;
    }
}