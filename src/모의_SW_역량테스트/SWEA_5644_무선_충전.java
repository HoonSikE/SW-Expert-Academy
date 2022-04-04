package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position{
	int x;
	int y;
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class SWEA_5644_무선_충전 {
	// 10x10 크기의 지도
	static int A, BC[][], resultA, resultB;
	static Position	posA, posB;
	// 이동하지 않음, 상, 우, 하, 좌
	static int[] dRow = {0,-1, 0, 1, 0};
	static int[] dCol = {0, 0, 1, 0,-1};
	
	// pos와 BC가 범위내에 있는지? (범위 >= BC좌표-pos좌표)
	public static boolean checkRange(Position pos, int index) {
		if(BC[index][2] >=(Math.abs(BC[index][0] - pos.x) + Math.abs(BC[index][1] - pos.y)))
			return true;
		return false;
	}
	public static void charge() {
		ArrayList<Integer> checkA = new ArrayList<>();
		ArrayList<Integer> checkB = new ArrayList<>();
		
		// 각 송전탑이 범위 내에 있는지 확인, 있다면 해당 index를 check list에 추가
		for (int i = 0; i < A; i++) {
			if(checkRange(posA, i)) {
				checkA.add(i);
			}
			if(checkRange(posB, i)) {
				checkB.add(i);
			}
		}
		// A충전량 + B충전량이 최대가 되는 시점
		int chargeMax = 0;
		// chargeMax가 최대가 되는 시점의 A, B 각 최대 충전 값
		int maxA = 0, maxB = 0;
		
		// 사이즈가 0이라면(겹치는 BC가 없다면) 리턴
		if(checkA.size()==0 && checkB.size() == 0) {
			return;
		// A와 겹치는 BC가 없다면 B중에 가장 높은 충전값 입력
		}else if(checkA.size() == 0) {
			for (int b : checkB) {
				if(maxB < BC[b][3])
					maxB = BC[b][3];
			}
		// B와 겹치는 BC가 없다면 A중에 가장 높은 충전값 입력
		}else if(checkB.size() == 0) {
			for (int a : checkA) {
				if(maxA < BC[a][3])
					maxA = BC[a][3];
			}
		// A와 B 모두 겹치는 BC가 있다면
		}else {
			// A의 경우, B의 경우 for문 돌려줌
			for (int a : checkA) {
				for (int b : checkB) {
					// 그중 a == b일때는 충전값을 반씩 나눠서 쓴다. 따라서 A충전량 + B충전량 = 겹치는 충전소
					// 이전 chargeMax(A충전량 + B충전량)보다 큰 충전량을 가진 BC가 있다면 그것으로 전환
					if(a == b) {
						// BC[a][3] == BC[b][3]
						if(BC[a][3] > chargeMax) {
							maxA = BC[a][3]/2;
							maxB = BC[a][3]/2;
							chargeMax = BC[a][3];
						}
					// a != b 일때는 각자 충전값을 사용한다. 이때 A충전량 + B충전량을 비교한다.
					// 이전 chargeMax(A충전량 + B충전량)보다 현재 A충전량+B충전량이 더 크다면 chargeMax값 최신화
					}else {
						if(BC[a][3] + BC[b][3] > chargeMax) {
							maxA = BC[a][3];
							maxB = BC[b][3];
							chargeMax = BC[a][3] + BC[b][3];
						}
					}
				}
			}
		}
		resultA += maxA;
		resultB += maxB;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			// M : 총 이동시간
			int M = Integer.parseInt(st.nextToken());
			// A : BC 개수
			A = Integer.parseInt(st.nextToken());
			// A이동
			resultA = 0;
			resultB = 0;
			// 어차피 BC에도 +1 된 좌표값과 비교하므로 0,0 9,9로 안바꿔줘도 됨.
			posA = new Position(1, 1);
			posB = new Position(10, 10);
			int[] moveA = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken()); 
			}
			// B이동
			int[] moveB = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken()); 
			}
			// x좌표, y좌표, 충전범위, 성능
			BC = new int[A][4];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			}
// ------------------------------입력-----------------------------------
			// 이동하지 않았을 때 1번 체크
			charge();
			// 이동하지 않음, 상, 우, 하, 좌
			for (int i = 0; i < M; i++) {
				posA.setY(posA.y + dRow[moveA[i]]);
				posA.setX(posA.x + dCol[moveA[i]]);
				posB.setY(posB.y + dRow[moveB[i]]);
				posB.setX(posB.x + dCol[moveB[i]]);
				charge();
			}
			str.append(resultA + resultB).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
