package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1206_View {
	// 좌좌, 좌, 우, 우우
	static int[] dCol = {-2, -1, 1, 2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		// 10개의 테스트 케이스
		int T = 10;
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// 가로 길이 W의 빌딩 맵
			int W = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] building = new int[W];
			// 빌딩 값 입력
			for (int i = 0; i < building.length; i++) {
				building[i] = Integer.parseInt(st.nextToken()); 
			}
			// 조망권이 보장되는 집의 개수 초기값
			int result = 0;
			for (int i = 2; i < building.length-2; i++) {
				int min = Integer.MAX_VALUE;
				// 좌좌, 좌, 우, 우우
				for (int j = 0; j < 4; j++) {
					// 현재 건물 높이 - 다른건물 j 높이 = 조망권 가구 수
					int temp =building[i]-building[i+dCol[j]];  
					// 주변에 높은 건물이 있다고 판단되면 조망권 0으로 초기화
					if(temp < 0) {
						min = 0;
						break;
					}
					// 더 높은 건물이 발견되면 그 건물의 조망권 값으로 저장
					if(temp < min)
						min = temp;
				}
				// 조망권 값이 유효할때마다 조망권이 보장되는 집의 개수 누적
				result += min;
			}
			str.append(result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
