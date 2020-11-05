import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 모든 노드에서 dfs해서 최소가 되는 루트노드를 구한다
// 각 노드에서 dfs를 한 결과를 캐싱한다
// MHT의 갯수는 1 or 2, indegree가 1인것을 제거하면서 나머지 indegree값을 업데이트, 현재 남아있는 노드가 2개이하일때 까지 반복
// indegree 세팅, 초기 set 초기화
// indegree가 1인 것 set에서 제거
// set에 남은 원소갯수가 2개이하일때 까지 반복
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i=0;i<n;i++){
            set.add(i);
        }
        int[] degree = new int[n];
        for (int[] edge:edges){
            int s = edge[0];
            int e = edge[1];
            if (!graph.containsKey(s)) graph.put(s,new ArrayList<>());
            if (!graph.containsKey(e)) graph.put(e,new ArrayList<>());
            graph.get(s).add(e);
            graph.get(e).add(s);
            degree[s]++;
            degree[e]++;
        }
        while (set.size() > 2){
            Iterator<Integer> iter = set.iterator();
            List<Integer> deleteItems = new ArrayList<>();
            while (iter.hasNext()){
                int node = iter.next();
                if (degree[node] == 1){
                    deleteItems.add(node);
                }
            }
            for (int node : deleteItems){
                set.remove(node);
                for (int v : graph.get(node)){
                    degree[v]--;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            res.add(iter.next());
        }
        return res;
    }
}

//Different Implementation
// class Solution {
//     public List<Integer> findMinHeightTrees(int n, int[][] edges){
//         List<Integer> res = new ArrayList<>();
//         if (n<=0) return res;
//         if (n == 1){
//             res.add(0);
//             return res;
//         }

//         int degree[] = new int[n];
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }

//         for (int[] e: edges){
//             degree[e[0]]++;
//             degree[e[1]]++;
//             adj.get(e[0]).add(e[1]);
//             adj.get(e[1]).ad(e[0]);
//         }

//         Queue<Integer> q = new LinkedList<>();
//         for (int i=0;i<n;i++){
//             if (degree[i] == 1) q.add(i);
//         }
//         while (n>2){
//             int size = q.size();
//             n -= size;

//             while (size-->0){
//                 int v = q.poll();
//                 for (int i:adj.get(v)){
//                     degree[i]--;
//                     if (degree[i]==1){
//                         q.add(i);
//                     }
//                 }
//             }
//         }
//         res.addAll(q);
//     }
// }