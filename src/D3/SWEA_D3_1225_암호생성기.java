package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = null;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		String str = null;
		
		while((str = br.readLine()) != null) {
			int T = Integer.parseInt(str);
			st = new StringTokenizer(br.readLine(), " ");
			// queue에 값들을 다 넣음
			while(st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(true) {
				int tmp = 0;
				// 사이클 반복
				for (int cnt = 1; cnt <= 5; cnt++) {
					tmp = queue.poll() - cnt;
					if(tmp <= 0) {
						tmp = 0;
						queue.offer(tmp);
						break;
					}
					queue.offer(tmp);
				}
				if(tmp <= 0) {
					tmp = 0;
					break;
				}
			}
			result.append("#" + T);
			for (int i = 0; i < 8; i++) {
				result.append(" " + queue.poll());
			}
			result.append("\n");
		}
		System.out.println(result.toString());
	}
}
