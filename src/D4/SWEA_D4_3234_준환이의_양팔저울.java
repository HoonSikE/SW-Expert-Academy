package D4;
/*
 *  풀면서 배운점
 *  static 변수보다 매개변수로 사용하면 속도가 더 빠르다.
 *  지역변수가 더 빠르게 접근하는 특성을 이용
 *  공간효율성을 버리고 시효율성을 얻음. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author HanHoon
 * @category 깊이 우선 탐색(DFS), 백트래킹(Backtracking)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw
 */
public class SWEA_D4_3234_준환이의_양팔저울 {
//	static int N, result;
//	static int weight[];
//	static boolean isSelected[]; 
	static int count;
	public static int fact(int num) {
		if(num <= 1) return 1;
		return fact(num - 1) * num;
	}
	public static void backtracking(int index, int left_sum, int right_sum, int rest_sum, final int[] weight, boolean[] isSelected, int N) {
		if(index == N) {
			if(left_sum >= right_sum)
				count++;
			return;
		}
		/**
		 * 이 if문을 추가함으로써 시간이 크게 차이나게 된다.
		 * 1,790 ms -> 487 ms
		 */
		// 좌측 무게 >= 우측+남은추 라면 모든 경우의수에서 가능하므로 재귀함수를 돌리지 않고 단순 값만 계산해주면 된다.
		if(left_sum >= right_sum + rest_sum) {
			// 각 추를 양팔저울의 좌우에 올리는 경우 = 2^N * N! (문제에 있음)
			count += (1 << (N-index)) * fact(N-index);
			return;
		}
		for (int i = 0; i < N; i++) {
			// 중복값은 허용하지 않음
			if(isSelected[i]) continue;
			isSelected[i] = true;
			// 좌 >= 우 조건이 충족할때만 우측에 올리는 것을 허용
			if(left_sum >= right_sum + weight[i] )
				backtracking(index+1, left_sum, right_sum + weight[i], rest_sum - weight[i], weight, isSelected, N);
			// 좌측은 조건없이 그냥 올림
			backtracking(index+1, left_sum + weight[i], right_sum, rest_sum - weight[i], weight, isSelected, N);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// 추의 개수
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			// N개의 추 무게 입력
			int []weight= new int[N];
			boolean[] isSelected = new boolean[N];
			// 현재 남은 추들의 합
			int rest_sum = 0;
			for (int i = 0; i < weight.length; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				rest_sum += weight[i];
			}
			// 경우의 수
			count = 0;
			backtracking(0, 0, 0, rest_sum, weight, isSelected, N);
			str.append(count).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
