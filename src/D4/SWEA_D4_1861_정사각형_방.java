package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class SWEA_D4_1861_정사각형_방 {
	static int N;
	static int cnt, start, arr[][];
	static boolean[] visited;
	
	public static int dfs(int x, int y) {
		// 상하좌우
		int[] xdir = {-1, 1, 0, 0};
		int[] ydir = {0, 0, -1, 1};
		Stack<Pos> stack = new Stack<>();
		int move = 1;
		
		stack.push(new Pos(x,y));
		while(!stack.isEmpty()) {
			Pos p = stack.pop();
			int a = p.x;
			int b = p.y;
			
			for (int i = 0; i < 4; i++) {
				int dx = a + xdir[i];
				int dy = b + ydir[i];
				
				if(isvalidPosition(dx, dy)) {
					if(arr[dx][dy] - arr[a][b] == 1) {
						visited[arr[dx][dy]] = true;
						stack.push(new Pos(dx, dy));
						move++;
					}
				}
				
			}
		}
		return move;
	}
	public static boolean isvalidPosition(int x, int y) {
		if(x < 0 || x > N-1 || y < 0 || y > N-1)
			return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		
		// 테스트 케이스 수 T
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// NxN개의 방
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			start = 101;
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N*N+1];
					int move = dfs(i,j);
					if(cnt < move) {
						cnt = move;
						start = arr[i][j];
					}else if(move != 0 && cnt == move) {
						if(arr[i][j] < start)
							start = arr[i][j];
					}
				}
			}
			str.append(start + " " + cnt).append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
