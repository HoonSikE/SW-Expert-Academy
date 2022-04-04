package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_7964_부먹왕국의_차원_관문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			boolean[] door = new boolean[N+2];
			door[0] = true;
			door[N+1] = true;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					door[i] = true;
			}
			
			int count = 0;
			int result = 0;
			for (int i = 0; i < door.length; i++) {
				if(count == D) {
					count = 0;
					result++;
				}
				if(door[i] == true)
					count = 0;
				else
					count++;
			}
			str.append(result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
