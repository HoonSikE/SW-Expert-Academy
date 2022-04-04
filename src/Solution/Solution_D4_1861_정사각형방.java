package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {
	static int N;
	static int arr[][], visit[][];
	static int idx, max;
	// 델타
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void dfs(int start, int depth, int x, int y) {
		visit[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (arr[nx][ny] == (arr[x][y] + 1) && visit[nx][ny] == 0)
					dfs(start, depth + 1, nx, ny);
			}
		}
		if (depth > max) {
			max = depth;
			idx = start;
		}
		if (depth == max) {
			idx = Math.min(idx, start);  //동일한 방문길이를 갖는다면 적은 숫자를 선택
		}
		visit[x][y] = 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new int[N][N];
			idx = 0;
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(arr[i][j], 1, i, j);
				}
			}
			str.append(idx + " " + max).append("\n");

		}
		System.out.println(str.toString());
		br.close();
	}
}
