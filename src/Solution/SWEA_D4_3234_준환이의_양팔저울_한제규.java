package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_3234_준환이의_양팔저울_한제규 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tNum = 1; tNum <= t; tNum++) {
            sb.append("#").append(tNum).append(" ");
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalSum = 0;
            // 추들의 무게를 저장할 배열
            int[] weights = new int[N];
            for(int i = 0; i < N; i++) {
                // 무게를 저장하면서 전체의 무게 합계를 받아준다.
                weights[i] = Integer.parseInt(st.nextToken());
                totalSum += weights[i];
            }
            boolean[] isUsed = new boolean[N];
            // 추들의 무게 배열, 어떤 추를 사용했는지, 총 몇 개인지, 지금 몇 개 넣었는지, 왼쪽에 올라간 무게가 얼만지, 오른쪽에 올라간 무게가 얼만지, 남은 추들의 무게가 얼만지
            sb.append(getCase(weights, isUsed, N, 0, 0, 0, totalSum)).append("\n");
        }
        System.out.print(sb.toString());
    }
     
    public static int fact(int num) {
        if (num <= 1) return 1;
        return fact(num - 1) * num;
    }
    public static int getCase(int[] weights, boolean[] isUsed, int N, int nowIdx, int leftSum, int rightSum, int totalSum) {
        if (nowIdx == N) {
            // 끝까지 문제없이 왔다면 1개의 경우가 가능한 것이다.
            return 1;
        }
        if (leftSum - rightSum >= totalSum) {
            // 왼쪽에 올려놓은 무게 - 오른쪽에 올려놓은 무게 남은 추들 무게보다 크거나 같다면 남은 추들은 그냥 막 배치해도 되니 모든 경우를 다 계산해주면 된다.
            return (1 << (N - nowIdx)) * fact(N - nowIdx);
        }
        int count = 0;
        // 남은 무게 조합으로 막 배치하면 안 될 경우, 순열로 만족 여부에 따라 탐색하며 카운트해준다.
        for(int i = 0; i < N; i++) {
            // 이미 사용된 것은 패스
            if (isUsed[i]) continue;
            // 사용 등록
            isUsed[i] = true;
            // 이번 회차에 i번 추를 왼쪽에 넣는 경우
            count += getCase(weights, isUsed, N, nowIdx + 1, leftSum + weights[i], rightSum, totalSum - weights[i]);
            // 이번 회차에 i번 추를 오른쪽에 넣을 수 있는 경우
            if (leftSum >= rightSum + weights[i])
                count += getCase(weights, isUsed, N, nowIdx + 1, leftSum, rightSum + weights[i], totalSum - weights[i]);            
            // 사용 등록 해제
            isUsed[i] = false;
        }
        return count;
    }
}
