import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 다익스트라 알고리즘에서 잘못이해한부분 
newDist = minDist[node.nodeNum]+adjNode.dist;
에서 newDist = node.dist+adjNode.dist; 라고 오해했다.
node.dist라고 하면 다른 노드에서 갱신한 최솟값을 이용하지 못하고 먼저 들어온 큐에 있는 거리의 합 기준으로 계산이 되기 때문에 틀린 답이 나온다.
bw.write(minDist[i]); 라고 출력할때 스트링이 출력되지 않은이유는 파라미터값이 아스키코드 값이기 때문이다.
*/
class Node implements Comparable<Node> {
    int nodeNum;
    int dist;

    public Node(int nodeNum, int dist) {
        this.nodeNum = nodeNum;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return dist - o.dist;
    }
}

public class Main {

    static int startNode;
    static int n;
    static int edgeCnt;
    static int MAX = 200001;
    static HashMap<Integer,List<Node>> adjList;
    static int[] minDist;

    public static int[] getMinDist(){
        int[] minDist = new int[n+1];
        for (int i=1; i<=n; i++){
            if (i == startNode)
                minDist[startNode] = 0;
            else
                minDist[i] = MAX;
        }
        return minDist;
    }

    public static void runDijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode,0));
        HashSet<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if (visited.contains(node.nodeNum)) continue;
            visited.add(node.nodeNum);
            if (adjList.containsKey(node.nodeNum)){
                for (Node adjNode : adjList.get(node.nodeNum)){
                    int newDist = minDist[node.nodeNum]+adjNode.dist;
                    if (newDist < minDist[adjNode.nodeNum]){
                        minDist[adjNode.nodeNum] = newDist;
                        pq.add(new Node(adjNode.nodeNum,minDist[adjNode.nodeNum]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        edgeCnt = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(tokenizer.nextToken());
        adjList = new HashMap<>();
        minDist = getMinDist();

        for (int i=0; i<edgeCnt; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tokenizer.nextToken());
            int e = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());
            if (!adjList.containsKey(s))
                adjList.put(s,new ArrayList<>());
            adjList.get(s).add(new Node(e,dist));
        }

        runDijkstra();

        for (int i=1;i<=n;i++){
            if (minDist[i] == MAX)
                bw.write("INF");
            else
                bw.write(minDist[i]+"");
            bw.newLine();
        }
        bw.flush();
    }
}
