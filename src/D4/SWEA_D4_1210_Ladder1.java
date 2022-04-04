package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1210_Ladder1 {
	static int X, Y;
	static int result = -1, map[][];
	public static void search() {
		int state = -1;
		if(map[Y][X] == 0) return;
		if(Y == 0 && map[Y][X] == 1) { result = X; return;}
		// left
		if(X > 1) {
			if(map[Y][X-1] == 1) {
				left();
				state = 1;
			}
		}
		// right
		if(X < (100-1)) {
			if(map[Y][X+1] == 1) {
				right();
				state = 1;
			}
		}
		// up
		if(Y==0) search();
		else if(Y > 0) {
			if(state == 1)
				search();
			else if(map[Y-1][X] == 1) {
				Y--;
				search();
			}
		}
	}
	public static void left() {
		if(X > 1) {
			if(map[Y][X-1] == 1) {
				X--;
				left();
			}else if(map[Y][X-1] == 0) {
				Y--;
				return;
			}
		} else if(X == 0) {
			Y--;
			return;
		}
	}
	public static void right() {
		if(X < (100-1)) {
			if(map[Y][X+1] == 1) {
				X++;
				right();
			}else if(map[Y][X+1] == 0) {
				Y--;
				return;
			}
		}else if (X == 99) {
			Y--;
			return;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		
		// 10개 테스트케이스
		for(int testcase = 1; testcase <= 10; testcase++) {
			int T = Integer.parseInt(br.readLine());
			// 100x100 크기의 map
			map = new int[100][100];
			// 사다리 입력
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				if(map[99][i] == 2) {
					// X, Y 종착점 입력
					X = i;
					Y = 99;
					// 역으로 찾음
					search();
				}
				if(result != -1) break;
			}
			str.append("#").append(T).append(" ").append(result).append("\n");
			result = -1;
		}
		System.out.println(str.toString());
	}
}
