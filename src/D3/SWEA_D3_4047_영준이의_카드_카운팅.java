package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_4047_영준이의_카드_카운팅 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();

		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			// 카드의 무늬 : S,D,H,C   카드의 숫자 : 01~13
			boolean[][] cnt_arr = new boolean[4][13];
			int cnt = 0;
			
			char[] CARD = br.readLine().toCharArray();
			
			for (int i = 0; i < CARD.length; i+=3) {
				int a = -1; 
				switch(CARD[i]) {
				case 'S':
					a = 0;
					break;
				case 'D':
					a = 1;
					break;
				case 'H':
					a = 2;
					break;
				case 'C':
					a = 3;
					break;
				}
				int b = (CARD[i+1]-'0') *10 + CARD[i+2] - '0';
				if(cnt_arr[a][b-1] == true) {
					cnt = -1;
					break;
				}
				cnt_arr[a][b-1] = true;
			}
			if(cnt == -1) {
				str.append("ERROR").append("\n");
				continue;
			}
			for (int i = 0; i < cnt_arr.length; i++) {
				cnt = 0;
				for (int j = 0; j < cnt_arr[i].length; j++) {
					if(cnt_arr[i][j] == false)
						cnt++;
				}
				str.append(cnt).append(" ");
			}
			str.append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}