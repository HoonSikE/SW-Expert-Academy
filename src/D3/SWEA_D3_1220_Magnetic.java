package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1220_Magnetic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		// 10개의 테스트 케이스
		int T = 10;
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// NxN 크기의 테이블 (위 N, 아래 S)
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[N][N];
			// 1:N, 2:S
			for (int i = 0; i < table.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < table[i].length; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for (int j = 0; j < N; j++) {
				int cnt1 = 0;
				for (int i = 0; i < N; i++) {
					if(table[i][j] == 1)
						cnt1++;
					if(cnt1 != 0 && table[i][j] == 2) {
						cnt1 = 0;
						result++;
					}
				}
			}

			str.append(result).append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
