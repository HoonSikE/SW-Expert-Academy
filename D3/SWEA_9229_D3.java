package D3;
/*
input
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder str = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int result = -1;
			st = new StringTokenizer(br.readLine(), " ");
			// 과자 봉지의 개수 (2~1000)
			int N = Integer.parseInt(st.nextToken());
			// 무게 합 제한 (2~2,000,000)
			int M = Integer.parseInt(st.nextToken());
			// 과자 N봉지
			int[] a = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < a.length-1; i++) {
				for (int j = i+1; j < a.length; j++) {
					if((a[i] + a[j]) <= M && (a[i] + a[j]) > result) {
						result = a[i] + a[j];
					}
				}
			}
			str.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(str.toString());
	}
}