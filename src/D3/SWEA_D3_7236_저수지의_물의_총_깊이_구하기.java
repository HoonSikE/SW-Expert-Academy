package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_7236_저수지의_물의_총_깊이_구하기 {
	// 좌상, 좌, 좌하, 하, 우하, 우, 우상, 상
	static int[] dRow = {-1, 0, 1, 1, 1, 0,-1,-1};
	static int[] dCol = {-1,-1,-1, 0, 1, 1, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		// T : 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// N : 저수지 구획의 크기
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = 0;
					// 좌상, 좌, 좌하, 하, 우하, 우, 우상, 상
					for (int m = 0; m < 8; m++) {
						int nowRow = i + dRow[m]; 
						int nowCol = i + dCol[m];
						
						// 범위에서 벗어난다면 continue
						if(nowRow < 0 || N-1 < nowRow || nowCol < 0 || N-1 < nowCol) continue;
						if(map[nowRow][nowCol] == 'W')
							count++;
					}
					if(count == 0) count = 1;
					result = result < count ? count : result; 
				}
			}
			str.append(result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
