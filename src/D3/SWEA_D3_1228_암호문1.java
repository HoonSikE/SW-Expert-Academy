package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_D3_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder result = new StringBuilder();
		LinkedList<Integer> ciphertext = new LinkedList<>();
		
		for(int tc = 1; tc <= 10; tc++) {
			int length = Integer.parseInt(br.readLine());
			// 원본 암호문 길이
			st = new StringTokenizer(br.readLine(), " ");
			// 원본 암호문
			for (int i = 0; i < length; i++) {
				ciphertext.add(Integer.parseInt(st.nextToken()));
			}
			// 명령어 개수
			int cipher_cnt = Integer.parseInt(br.readLine());
			// 명령어
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < cipher_cnt; j++) {
				if(st.nextToken().charAt(0) == 'I') {
					//앞에서 X번째 뒤에
					int X = Integer.parseInt(st.nextToken());
					//Y개의 암호문을
					int Y = Integer.parseInt(st.nextToken());
					//추가한다
					for (int m = 0; m < Y; m++) {
						ciphertext.add((X+m), Integer.parseInt(st.nextToken()));
					}
				}
			}
			result.append("#").append(tc).append(" ");
			for (int index = 0; index < 10; index++) {
				result.append(ciphertext.get(index)).append(" ");
			}
			result.append("\n");
			ciphertext.clear();
		}
		System.out.println(result.toString());
	}
}
