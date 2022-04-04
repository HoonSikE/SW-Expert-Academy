package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			char[] bit_num = br.readLine().toCharArray();
			char nowbit = '0';
			int cnt = 0;
			
			for(int j = 0; j<bit_num.length; j++) {
				if(nowbit != bit_num[j]) {
					nowbit = bit_num[j];
					cnt++;
				}
			}
			System.out.println("#" + (i+1) + " " + cnt);
		}
		br.close();
	}
}