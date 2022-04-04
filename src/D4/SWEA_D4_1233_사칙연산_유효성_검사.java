package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_D4_1233_사칙연산_유효성_검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= 10; tc++) {
			str.append("#").append(tc).append(" ");
			int result = 1;
			// 노드 개수
			int NUM = Integer.parseInt(br.readLine());
			
			while(NUM-->0) {
				st = new StringTokenizer(br.readLine(), " ");
				int node_num = Integer.parseInt(st.nextToken());
				
				char data = st.nextToken().charAt(0);
				if(data =='+'||data =='-'||data =='*'||data =='/') {
					int left = 0, right = 0;
					if(st.hasMoreElements())
						left= Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens())
						right = Integer.parseInt(st.nextToken());
					System.out.println(node_num + " " + data + " " + left + " " + right);
				} else {
					int data_int = Integer.parseInt(data + "");
					System.out.println(node_num + " " + data_int);
				}
			}
			
			str.append(result).append("\n");
		}

		System.out.println(str.toString());
		br.close();
	}
}
