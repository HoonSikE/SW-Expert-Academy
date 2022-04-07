package 모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class SWEA_1953_탈주범_검거 {
	static int N, M, R, C, L, result;
	static int[][] map;
	static boolean[][] isVisited;
	// 상하좌우
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = { 0, 0,-1, 1};
	
	public static boolean possible(int index, int nowState, int nextState) {
		switch(index) {
		// nowState 상
		case 0:
			switch(nowState) {
			// 1: 상하좌우  2: 상하  4: 상우  7: 상좌
			case 1:  case 2:  case 4:  case 7:
				// nextState 하
				switch(nextState) {
				// 1: 상하좌우  2: 상하  5: 하우  6: 하좌
				case 1:  case 2:  case 5:  case 6:
					return true;
				}
			}
			break;
		// nowState 하
		case 1:
			switch(nowState) {
			// 1: 상하좌우  2: 상하  5: 하우  6: 하좌
			case 1:  case 2:  case 5:  case 6:
				// nextState 상
				switch(nextState) {
				// 1: 상하좌우  2: 상하  4: 상우  7: 상좌
				case 1:  case 2:  case 4:  case 7:
					return true;
				}
			}
			break;
		// nowState 좌
		case 2:
			switch(nowState) {
			// 1: 상하좌우  3: 좌우  6:하좌  7: 상좌
			case 1:  case 3:  case 6:  case 7:
				// nextState 우
				switch(nextState) {
				// 1: 상하좌우  3: 좌우  4: 상우  5: 하우
				case 1:  case 3:  case 4:  case 5:
					return true;
				}
			}
			break;
		// nowState 우
		case 3:
			switch(nowState) {
			// 1: 상하좌우  3: 좌우  4: 상우  5: 하우
			case 1:  case 3:  case 4:  case 5:
				// nextState 좌
				switch(nextState) {
				// 1: 상하좌우  3: 좌우  6: 하좌  7: 상좌
				case 1:  case 3:  case 6:  case 7:
					return true;
				}
			}
			break;
		}
		return false;
	}
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(R, C));
		isVisited[R][C] = true;
		result = 1;
		
		int time = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(++time >= L) break;
			
			for (int i = 0; i < size; i++) {
				Pos pos = queue.poll();
				int nowState = map[pos.y][pos.x];
				for (int index = 0; index < 4; index++) {
					int nextY = pos.y + dRow[index];
					int nextX = pos.x + dCol[index];
					// 범위내에 없다면 continue;
					if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= M)  continue;
					int nextState = map[nextY][nextX];
					// 방문한적이 있거나, 갈 수 없다면 continue
					if(isVisited[nextY][nextX] || !possible(index, nowState, nextState))  continue;
					
					queue.offer(new Pos(nextY, nextX));
					result++;
					isVisited[nextY][nextX] = true;
				}
			}
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
			st = new StringTokenizer(br.readLine(), " ");
			// 지도의 세로 크기(N), 가로 크기(M)
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// 맨홀 뚜껑이 위치한장소의 세로 위치(R), 가로 위치(C)
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			// 탈출 후 소요된 시간(L)
			L = Integer.parseInt(st.nextToken());
			
			// 지하 터널 지도 정보
			// 1~7 : 터널 구조물 타입, 0 : 터널이 없는 장소
			// 1: 상하좌우, 2: 상하, 3: 좌우, 4: 상우, 5: 하우, 6:하좌, 7: 상좌
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			result = Integer.MIN_VALUE;
			isVisited = new boolean[N][M];;

			bfs();
			str.append(result).append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
