package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SWEA_D2_1954_달팽이_숫자 {
	// Input/Output 예외처리
	public static void main(String args[]) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// test_case
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// num = 배열에 들어갈 값, i = x축, j = y축, v = 방향
			int num = 1, i=0, j=-1, v = 1;
			// 크기 N을 받아온뒤 N*N 크기의 배열 생성
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			// x축 N, y축 N-1만큼 이동 -> 역방향으로 x축 N-1, y축 N-2만큼 이동 반복
			while(true) {
				// x축 N만큼 이동
				for(int x = 0; x < N; x++) {
					j+=v;
					arr[i][j] = num++;
				}
				N -= 1;
				if(N<=0) break;
				// y축 N-1만큼 움직임
				for(int y = 0; y < N; y++) {
					i+=v;
					arr[i][j] = num++;
				}
				// 진행 방향 전환
				v *= -1;
			}
			sb.append("#" + test_case + "\n");
			for(int n = 0; n < arr.length; n++) {
				for(int m = 0; m < arr[n].length; m++) {
					sb.append(arr[n][m] + " ");
				}
				sb.append("\n");
			}
		}
		// StringBuilder에 저장했다가 입력값을 한번에 출력 (문제 요구사항)  
		System.out.println(sb);
	}
}