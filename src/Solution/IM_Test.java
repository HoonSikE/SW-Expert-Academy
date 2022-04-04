package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IM_Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			
			float a = (float) X1;
			float b = (float) Y2;
			float h = (X2-Y1)/2.0f;
			float result = a*b*h;

			str.append(result).append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
