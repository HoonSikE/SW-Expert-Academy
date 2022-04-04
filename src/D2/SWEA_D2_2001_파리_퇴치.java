package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_2001_파리_퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			// N(5~15), M(2~N)
			int N = Integer.parseInt(st.nextToken());
			if(!(5<=N && N <=15)) {
				System.out.println("5~15의 범위를 벗어났습니다.");
				return;
			}
			int M = Integer.parseInt(st.nextToken());
			if(!(2<=M && M <=N)) {
				System.out.println("2~" + N + "의 범위를 벗어났습니다.");
				return;
			}
			int[][] fly = new int[N][N];
			// NxN 배열 생성 및 값 할당
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
					// 파리(1~30)
					if(!(0<=fly[i][j] && fly[i][j] <=30)) {
						System.out.println("1~30의 범위를 벗어났습니다.");
						return;
					}
				}
			}
			
			for(int i = 0; i < N-M+1; i++) {
				for(int j = 0; j < N-M+1; j++) {
					int temp = 0;
					// MxM 크기의 파리채
					for(int n = 0; n < M; n++) {
						for(int m = 0; m < M; m++) {
							temp += fly[i+n][j+m];
						}
					}
					if(result < temp)
						result = temp;
				}
			}
			
			System.out.println("#" + testcase + " " + result);
		}
	}
}
