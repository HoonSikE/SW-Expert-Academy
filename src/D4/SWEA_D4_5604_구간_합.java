package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_5604_구간_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());
			
			long tmp = A;
			int sum = 0;
			while(tmp > 0) {
				sum += tmp%10;
				tmp /= 10;
			}
			int result = sum;
			for (long i = A+1; i <= B; i++) {
				tmp = i;
				while(tmp > 0) {
					if(tmp%10 == 0)
						sum -= 9;
					else {
						sum += 1;
						break;
					}
					tmp /= 10;
				}
				result += sum;
			}
			str.append(result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
