package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1218_괄호_짝짓기 {
	static int N, L, result;
	
	public static void make(int[][] TK, int index, int score_T, int score_L) {
		if(score_L > L) return;
		if(result < score_T) result = score_T;
		if(index == N) return;
		// 넣은 경우
		make(TK, index+1, score_T+TK[index][0], score_L+TK[index][1]);
		// 안넣은 경우
		make(TK, index+1, score_T, score_L);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 재료의 수 
//			if(!(1<=N&&N<=20)) {System.out.println("재료수 1~20 범위 초과"); return;}
			L = Integer.parseInt(st.nextToken());	// 제한 칼로리
//			if(!(1<=N&&N<=10000)) {System.out.println("제한칼로리 1~10,000 범위 초과"); return;}
			
			int[][] TK = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				TK[i][0] = Integer.parseInt(st.nextToken());
//				if(!(1<=TK[i][0]&&TK[i][0]<=1000)) {System.out.println("맛점수 1~1,000 범위 초과"); return;}
				TK[i][1] = Integer.parseInt(st.nextToken());
//				if(!(1<=TK[i][1]&&TK[i][1]<=1000)) {System.out.println("칼로리 1~1,000 범위 초과"); return;}
			}
			make(TK, 0, 0, 0);
			System.out.println("#" + testcase + " " + result);
		}
	}
}
