package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_7465_창용_마을_무리의_개수 {
	static boolean[] visited;
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	public static void bfs(Node[] adjList, int N, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// 추의 개수
			st = new StringTokenizer(br.readLine(), " ");
			// N : 사람의 수, M : 서로 알고 있는 사람의 관계 수
			int N = Integer.parseInt(st.nextToken());	// 정점 수
			int M = Integer.parseInt(st.nextToken());	// 간선 수
			Node[] adjList = new Node[N];
			visited = new boolean[N];
			int result = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				// 무향이므로 간선 하나로 양방향 처리
				adjList[from] = new Node(to, adjList[from]);
				adjList[to] = new Node(from, adjList[to]);
			}
			for (int i = 0; i < adjList.length; i++) {
				// 무리 분류가 되지 않은 경우 bfs 실행
				if(visited[i] == false) {
					bfs(adjList, N, i);
					result++;
				}
			}
			str.append(result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
