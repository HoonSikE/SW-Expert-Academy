package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int N, S[][];
	static int result;
	static boolean[] isSelected;
	public static void getMin(int cnt, int start) {
		// 재료의 절만만 고름
		if(cnt == N/2) {
			int[] arrA = new int[cnt];
			int[] arrB = new int[cnt];
			int A = 0, B = 0;
			int cntA = 0, cntB = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i])
					arrA[cntA++] = i;
				else
					arrB[cntB++] = i;
			}
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < cnt; j++) {
					// i == j인 부분 제외
					if(i != j) {
						A += S[arrA[i]][arrA[j]];
						B += S[arrB[i]][arrB[j]];
					}
				}
			}
			result = result > Math.abs(A-B) ? Math.abs(A-B) : result;
		}
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			getMin(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		// T : 총 테스트의 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// 첫번째 테스트 케이스 N개의 재료(단, N은 짝수)
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			isSelected = new boolean[N];
			// NxN개의 시너지배열 S 입력
			for (int i = 0; i < S.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < S[i].length; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = Integer.MAX_VALUE;
			// 맛의 차이가 최소인 음식
			getMin(0,0);
			str.append(result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}