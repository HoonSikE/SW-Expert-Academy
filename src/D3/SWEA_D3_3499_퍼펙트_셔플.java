package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_3499_퍼펙트_셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// N개의 카드
			int N = Integer.parseInt(br.readLine());
			String arr_front[], arr_back[];
			if(N%2 == 0) {
				arr_front = new String[N/2];
				arr_back = new String[N/2];
			}else {
				arr_front = new String[N/2+1];
				arr_back = new String[N/2];
			}
			String[] result = new String[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < arr_front.length; i++) {
				arr_front[i] = st.nextToken();
			}
			for (int i = 0; i < arr_back.length; i++) {
				arr_back[i] = st.nextToken();
			}
			
			int cnt_f = 0, cnt_b = 0;
			for (int i = 0; i < result.length; i++) {
				if(i%2 == 0)
					result[i] = arr_front[cnt_f++];
				else
					result[i] = arr_back[cnt_b++];
			}
			
			for (String string : result) {
				str.append(string + " ");
			}
			str.append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
