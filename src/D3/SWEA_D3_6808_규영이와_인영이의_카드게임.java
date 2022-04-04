package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_6808_규영이와_인영이의_카드게임 {
	static int[] input, numbers;
	static boolean[] isSelected;
	public static void permutation(int cnt, int flag) {
		if(cnt == 9){
			System.out.println(Arrays.toString(numbers));
		}
		for (int i = 0; i < 9; i++) {
			if((flag&1<<i)!=0) continue;
			
			numbers[cnt] = input[i];
			permutation(cnt+1, flag|1<<i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			
			input = new int[9];
			numbers = new int[9];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
//			Arrays.sort(input);

			isSelected = new boolean[18];
			for (int i = 0; i < 9; i++) {
				isSelected[input[i]-1] = true;
			}
			
			
			permutation(0,0);
			
			str.append(0).append("\n");
		}

//		System.out.println(str.toString());
		br.close();
	}
}
/*
1
1 3 5 7 9 11 13 15 17
 * 
4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18
*/