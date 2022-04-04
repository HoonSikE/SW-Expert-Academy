package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자_비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			// 숫자의 개수
			int N = Integer.parseInt(st.nextToken());
			int size = N/4;
			// 크기 순서
			int K = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = new ArrayList<>();
			String num = br.readLine();

			for (int i = 0; i < size; i++)
				num += num.charAt(i);
			
			for (int i = 0; i < N; i++) {
				String hex = "";
				for (int j = 0; j < size; j++)
					hex += num.charAt(i+j);
				list.add(Integer.parseInt(hex, 16));
			}

			// 중복제거, Set : 순서가 유지되지 않으며, 죽복을 허용하지 않음
			HashSet<Integer> hashSet = new HashSet<>(list);
			list = new ArrayList<>(hashSet);
			Collections.sort(list);
			str.append(list.get(list.size()-K)).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
