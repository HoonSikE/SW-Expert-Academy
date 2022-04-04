package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_1208_Flatten {
	public static int size = 100;
	public static int[]arr = new int[size];
	public static int dump() {
		if(!((arr[size-1] - arr[0]) <= 1)) {
			arr[0]++;
			arr[size-1]--;
		} 
		return arr[size-1] - arr[0];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = 10;
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int dump_num = Integer.parseInt(br.readLine());
			if(!(1<=dump_num && dump_num <=1000)) {
				System.out.println("1~1000의 범위를 벗어났습니다.");
				return;
			}
			int result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<size; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for(int i=0; i<dump_num; i++) {
				result = dump();
				Arrays.sort(arr);
			//	if(result <= 1) break;
			}
			System.out.println("#" + testcase + " " + (arr[size-1] - arr[0]));
		}
	}
}
