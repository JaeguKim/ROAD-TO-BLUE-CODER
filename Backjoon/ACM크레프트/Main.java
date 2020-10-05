import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
    int nodeNum;
    int sum;

    public Node(int nodeNum, int sum) {
        this.nodeNum = nodeNum;
        this.sum = sum;
    }
}

public class Main {

    static int[] time;
    static int[] maxTime;
    static int target;
    static HashMap<Integer, ArrayList<Integer>> adjList;
    static int[] inDegree;
    static int n, k;

    public static int runSimulation() {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.add(new Node(i,time[i]));
        }
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if (front.nodeNum == target){
                break;
            }
            if (adjList.containsKey(front.nodeNum)) {
                for (int node : adjList.get(front.nodeNum)) {
                    maxTime[node] = Math.max(maxTime[node],front.sum+time[node]);
                    if (--inDegree[node] == 0)
                        queue.add(new Node(node,maxTime[node]));
                }
            }
        }
        return maxTime[target];
    }

    // O(N*K)풀이 : 시작 노드별로 같은 edge를 여러번 방문한다
    // public static void runSimulation(int startNode) {
    //     Stack<Node> stack = new Stack<>();
    //     stack.push(new Node(startNode, time[startNode]));
    //     while (!stack.empty()) {
    //         Node node = stack.pop();
    //         if (maxTime[node.nodeNum] < node.sum) {
    //             maxTime[node.nodeNum] = node.sum;
    //             if (node.nodeNum != target && adjList.containsKey(node.nodeNum)) {
    //                 for (int adjNode : adjList.get(node.nodeNum)) {
    //                     stack.push(new Node(adjNode, node.sum + time[adjNode]));
    //                 }
    //             }
    //         }
    //     }
    // }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String nk = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(nk);
            n = Integer.parseInt(tokenizer.nextToken());
            k = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(br.readLine());
            time = new int[n + 1];
            maxTime = new int[n + 1];
            inDegree = new int[n + 1];
            Arrays.fill(maxTime, -1);
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(tokenizer.nextToken());
                maxTime[i] = time[i];
            }
            adjList = new HashMap<>();
            for (int i = 0; i < k; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(tokenizer.nextToken());
                int e = Integer.parseInt(tokenizer.nextToken());
                inDegree[e] += 1;
                if (!adjList.containsKey(s)) {
                    adjList.put(s, new ArrayList<>());
                }
                adjList.get(s).add(e);
            }
            target = Integer.parseInt(br.readLine());
            int res = runSimulation();
            bw.write(res + "\n");
            bw.flush();
        }

    }
}
