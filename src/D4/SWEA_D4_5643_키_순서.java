package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_5643_키_순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		// 테스트케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// N: 학생들의 수, M: 두 학생 키를 비교한 횟수
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			// M 개의 줄에 걸쳐 두 학생의 키를 비교
			int[][] arr = new int[M][2];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			str.append(0).append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
