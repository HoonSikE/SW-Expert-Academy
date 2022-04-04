package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D5_1247_최적_경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			int N = Integer.parseInt(st.nextToken());
			
			str.append(0).append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
