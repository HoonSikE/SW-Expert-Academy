package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author HanHoon
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXxNn6GaPW4DFASZ&categoryId=AXxNn6GaPW4DFASZ&categoryType=CODE&problemTitle=%EA%B5%90%ED%99%98%ED%95%99&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 */
public class SWEA_D3_13038_교환학생 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= TC; testcase++) {
			str.append("#").append(testcase).append(" ");
			// N일동안 수업을 들을 예정
			int N = Integer.parseInt(br.readLine());
			// 수업하는 날짜 데이터 입력 
			int[] week = new int[7];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 7; i++) {
				week[i] = Integer.parseInt(st.nextToken());
			}
			int min = Integer.MAX_VALUE;
			for (int start = 0; start < 7; start++) {
				// 수업이 시작하는 모든 요일 처리
				if(week[start] == 0) continue;	// 수업이 열리지 않는 날은 continue;

				int day = start, cnt=0;
				while(true) {
					if(week[day%7]==1) cnt++; //수업이 열리면 카운팅
					
					++day; // 하루 지남
					if(cnt == N) {	// 머무른 최소일수
						min = Math.min(min, day-start);
						break;
					}
				}
			}
			str.append(min).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}
