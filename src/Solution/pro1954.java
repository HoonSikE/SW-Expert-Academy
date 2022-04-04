package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class pro1954 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\SSAFY\\workspace\\02_java\\SW_Expert_Academy\\src\\com\\ssafy\\pro1954\\input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int n = 0; n < 3; n++) {
			int i = 0;
			int j = 0;
			int cnt = 0;
			
			int t = sc.nextInt();		// 테스트 케이스 개수
			int[][]snail = new int[t][t];
			
			int start = 0;
			int end = t;
			
			System.out.println("#" + (n+1));
			
			if(i==start) {
				for(j=0; j<end;j++) {
					snail[i][j] = ++cnt;
					start = j;
				}
			}
			else if(j== start) {
				for(;i<end;j++) {
					snail[i][j] = ++cnt;
					start = j;
				}
			}
				
			
			for(i = 0; i<t; i++) {
				for(j=0; j<t;j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}