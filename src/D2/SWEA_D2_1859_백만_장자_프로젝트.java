package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SWEA_D2_1859_백만_장자_프로젝트 {
	public static void main(String args[]) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
//---------------------------입력-------------------------------
			int max = Integer.MIN_VALUE;
			// 아직 아무것도 사재기하지 않았으므로 수익은 0
			long result = 0;
			// 끝에서부터 생각을 해보자
			for (int i = N-1; i >= 0; i--) {
				// 다음 날 가격 > 전 날 가격 --> 차익만큼 수익
				if(max > arr[i])
					result += max-arr[i];
				// 다음 날 가격 < 전 날 가격 --> 수익은 없고 max값 최신화
				// 결국 첫날까지 가격이 상승한다면 수익은 초기값인 0원이 됨.
				else
					max = arr[i];
			}
			str.append(result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}