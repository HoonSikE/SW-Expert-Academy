package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_11315_오목_판정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		// 우, 하, 우상, 우하
		int[] dRow = { 0, 1,-1, 1};
		int[] dCol = { 1, 0, 1, 1};
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// 문자열 가로세로 길이 NxN의 TC
			int N = Integer.parseInt(br.readLine());
			char[][] omoc = new char[N][N];
			for (int i = 0; i < N; i++) {
				omoc[i] = br.readLine().toCharArray();
			}
			// 오목 판정
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(omoc[i][j] == 'o') {
						// 우, 하, 우상, 우하
						for (int index = 0; index < 4; index++) {
							// 5번 반복
							for (int count = 1; count < 5; count++) {
								int next_y = i + dRow[index] * count;
								int next_x = j + dCol[index] * count;
								// 범위에서 벗어나거나, o가 아닐때 break;
								if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= N || omoc[next_y][next_x] != 'o')
									break;
								if(count == 4) {
									flag = true;
									break;
								}
							}
							if(flag) break;
						}
					}
					if(flag) break;
				}
				if(flag) break;
			}
			if(flag)
				str.append("YES").append("\n");
			else
				str.append("NO").append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
