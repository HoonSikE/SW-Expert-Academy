package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_D4_1223_계산기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		Queue<Character> stack = new LinkedList<>();

		// 10개의 테스트 케이스
		int T = 10;
//		int T = 1;
/*
9
3+4+5*6+7
*/
		for (int testcase = 1; testcase <= T; testcase++) {
			str.append("#").append(testcase).append(" ");
			int N = Integer.parseInt(br.readLine());

			char[] arr = new char[N];
			arr = br.readLine().toCharArray(); 

			int numcnt = 0;
			// tmp1 : 곱셈,나눗셈   tmp2 : 덧셈,뺄셈
			char tmp1 = '0', tmp2 = '0';
			for (int i = 0; i < arr.length; i++) {
				switch(arr[i]) {
				case '*':// case '/':
					tmp1 = arr[i];
					break;
				case '+':// case '-':
					tmp2 = arr[i];
					break;
				default:
					if(numcnt == 0 && i < arr.length-1) {
						stack.offer(arr[i]);
						numcnt++;
					}else {
						stack.offer(arr[i]);
						numcnt++;
						if(tmp1 != '0') {
							stack.offer(tmp1);
							tmp1 = '0';
							numcnt = 0;
						}
						if(tmp2 != '0') {
							stack.offer(tmp2);
							tmp1 = '0';
							numcnt = 0;
						}
					}
					break;
				}
			}
			double result = 0;
			while(!stack.isEmpty()) {
				char st = stack.poll();
				switch(st) {
				case '*':
					break;
//				case '/':
//					break;
				case '+':
					break;	
//				case '-':
//					break;
				default:
					break;
				}
//				str.append(stack.poll());
			}
			str.append((int)result).append("\n");
		}
		System.out.println(str.toString());
		br.close();
	}
}