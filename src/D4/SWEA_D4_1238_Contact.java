package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_1238_Contact {
	static int[][] data;
	static int[] dCol = {0,0,1,-1};
	static int[] dRow = {0,0,1,-1};
	
	static StringBuilder str = new StringBuilder();
	static void bfs(int start) {
		int [] visited = new int[101];
        int maxCnt = 0, ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 1; i< 101; i++) {
                if(data[cur][i] != 1 || visited[i] != 0) continue;

                visited[i] = visited[cur]+1;
                q.offer(i);
            }
            maxCnt = visited[cur];
        }

        for(int i = 1 ; i< 101; i++) {
            if(maxCnt != visited[i]) continue;
            ans = ans > i ? ans : i;
        }
        str.append(ans).append("\n");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = 10;
		
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			// 데이터의 길이
			int N = Integer.parseInt(st.nextToken());
			// 데이터 시작점
			int Start = Integer.parseInt(st.nextToken());
			
			data = new int[101][101];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N/2; i++) {
				data[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			bfs(Start);
		}

		System.out.println(str.toString());
		br.close();
	}
}
