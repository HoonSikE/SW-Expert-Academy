package D1;

import java.util.Scanner;

public class SWEA_D1_0272_홀수만_더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=sc.nextInt();
		sc.nextLine();
		
		int[] sum = new int[cnt];
		for(int i = 0; i < cnt; i++) {
			String[] s=sc.nextLine().split(" ");
			
			for(int j = 0; j<s.length; j++) {
				int n = Integer.parseInt(s[j]);
				if(n%2==1)
					sum[i] += n;
			}
		}
		//출력---------
		for(int i = 0; i <cnt; i++) {
			System.out.println("#" +(i+1)+" "+sum[i]);
		}
	}
}
