package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1873_상호의_배틀필드 {
	static char[][] map; 
	static int H = 0, W = 0, tank_x = 0, tank_y= 0;
	public static boolean int_range(int from, int num, int to) {
		if(!((from<=num) && (num<=to))) {
			System.out.println("범위 초과!!!");
			System.out.println(from + "~" + to + "의 값을 입력하세요.");
			return false;
		}
		return true;
	}
	public static void move_tank(char[][] map, char state) {
		// 전차가 게임 밖이라면 이동하지 않는다.
		if(tank_x < 0 || tank_x > W || tank_y < 0 || tank_y > H)
			return;
		
		if(state == 'U') {
			map[tank_y][tank_x] = '^';
			if((tank_y > 0) && (map[tank_y-1][tank_x] == '.')) {
				map[tank_y][tank_x] = '.';
				map[--tank_y][tank_x] = '^';
			}
		}else if(state == 'D') {
			map[tank_y][tank_x] = 'v';
			if((tank_y < (H-1)) && (map[tank_y+1][tank_x] == '.')) {
				map[tank_y][tank_x] = '.';
				map[++tank_y][tank_x] = 'v';
			}
		}else if(state == 'L') {
			map[tank_y][tank_x] = '<';
			if((tank_x > 0) && (map[tank_y][tank_x-1] == '.')) {
				map[tank_y][tank_x] = '.';
				map[tank_y][--tank_x] = '<';
			}
		}else if(state == 'R') {
			map[tank_y][tank_x] = '>';
			if((tank_x < (W-1)) && (map[tank_y][tank_x+1] == '.')) {
				map[tank_y][tank_x] = '.';
				map[tank_y][++tank_x] = '>';
			}
		}else if(state == 'S') {
			shoot(map, map[tank_y][tank_x]);
		}
	}
	public static void shoot(char[][] map, char state) {
		int cnt = 0;
		if(state == '^') {
			cnt = tank_y;
			while(cnt > 0) {
				if(map[cnt-1][tank_x] == '*') {
					map[cnt-1][tank_x] = '.';
					break;
				}else if(map[cnt-1][tank_x] == '#') {
					break;
				}
				cnt--;
			}
		}else if(state == 'v') {
			cnt = tank_y;
			while(cnt < (H-1)) {
				if(map[cnt+1][tank_x] == '*') {
					map[cnt+1][tank_x] = '.';
					break;
				}else if(map[cnt+1][tank_x] == '#') {
					break;
				}
				cnt++;
			}
		}else if(state == '<') {
			cnt = tank_x;
			while(cnt > 0) {
				if(map[tank_y][cnt-1] == '*') {
					map[tank_y][cnt-1] = '.';
					break;
				}else if(map[tank_y][cnt-1] == '#') {
					break;
				}
				cnt--;
			}
		}else if(state == '>') {
			cnt = tank_x;
			while(cnt < (W-1)) {
				if(map[tank_y][cnt+1] == '*') {
					map[tank_y][cnt+1] = '.';
					break;
				}else if(map[tank_y][cnt+1] == '#') {
					break;
				}
				cnt++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)	{
			st = new StringTokenizer(br.readLine(), " ");
			// 높이 H, 너비 W 입력 (범위 2~20)
			H = Integer.parseInt(st.nextToken());
			if(!int_range(2, H, 20)) return;
			W = Integer.parseInt(st.nextToken());
			if(!int_range(2, W, 20)) return;
			// H*W 맵 입력
			map = new char[H][W];
			for(int n=0; n<H; n++) {
				map[n] = br.readLine().toCharArray();
			}
			// 사용자 입력 개수 N 입력 (범위 1~100)
			int N = Integer.parseInt(br.readLine());
			if(!int_range(1, N, 100)) return;
			// find tank
			LoopOut:
			for(int n=0; n<H; n++) {
				for(int m=0; m<W; m++) {
					char map_ch = map[n][m];
					if((map_ch == '^')||(map_ch == 'v')||(map_ch == '<')||(map_ch == '>')) {
						tank_y = n;
						tank_x = m;
						break LoopOut;
					}
				}
			}
			// input tank move
			char[] move = new char[N];
			move = br.readLine().toCharArray();
			//tank move
			for(int n=0; n<N; n++) {
				move_tank(map,move[n]);
			}
			// 결과 출력
			System.out.print("#" + test_case + " ");
			for(int n=0; n<H; n++) {
				for(int m=0; m<W; m++) {
					System.out.print(map[n][m]);
				}
				System.out.println();
			}
		}
	}
}
