package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_2805_농작물_수확하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			// 1~49를 벗어나거나 짝수라면 return
			if(!(1<=N && N<=49) || N%2 == 0) {
				System.out.println("범위(1~49 사이 홀수)를 초과했습니다.");
				return;
			}
			int[][] arr = new int[N][N];
			int sum = 0;
			
			char[][] arrch = new char[N][N];
			for(int i = 0; i < arrch.length; i++) {
				arrch[i] = br.readLine().toCharArray();
			}
			for(int i = 0; i < arrch.length; i++) {
				for(int j = 0; j < arrch[i].length; j++) {
					arr[i][j] = arrch[i][j] - '0';
				}
			}
			
			for(int i = 0; i < arrch.length; i++) {
				if(i < (arrch.length/2)){
					for(int j = (arrch[i].length/2)-i; j <=(arrch[i].length/2)+i ; j++) {
						sum += arr[i][j]; 
					}
				}else {
					for(int j = (i-arrch[i].length/2); j < arrch[i].length-(i-arrch[i].length/2); j++) {
						sum += arr[i][j];
					}
				}
			}
			System.out.println("#" + testcase + " " + sum);
		}
	}
}
