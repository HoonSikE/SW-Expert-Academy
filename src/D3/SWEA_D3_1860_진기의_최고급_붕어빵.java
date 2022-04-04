package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_1860_진기의_최고급_붕어빵 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		// T : 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			// N : 붕어빵을 먹을 수 있는 사람의 수
			int N = Integer.parseInt(st.nextToken());
			// M : 붕어빵 만드는데 걸리는 시간
			int M = Integer.parseInt(st.nextToken());
			// K : 단위시간(M)당 만들 수 있는 붕어빵의 개수
			int K = Integer.parseInt(st.nextToken());
			
			// N명의 손님이 언제 도착하는지??
			int[] people = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(people);
			boolean flag = true;
			
			for (int i = 0; i < N; i++) {
				if(K * (people[i] / M) < i+1)
					flag = false;
			}
			
			if(flag)
				str.append("Possible").append("\n");
			else
				str.append("Impossible").append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
