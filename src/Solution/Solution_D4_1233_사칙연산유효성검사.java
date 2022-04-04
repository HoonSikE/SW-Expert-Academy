package Solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/ws0210_2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, result, i;
        String[] inputs;
        
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());//트리의 총 정점(노드)의 수 
            result = 1;    //기본값 유효
            for (i = 1; i <= N; i++) {
                inputs = br.readLine().split(" ");
                if (inputs[1].equals("+") || inputs[1].equals("-") || inputs[1].equals("*") || inputs[1].equals("/")) {
                    /*
                        <연산자의 경우>
                        1       -       2         3
						2       -       4         5
						3       +       6         7
						4       /       8         9
					   노드번호	   연산자     왼쪽자식노드   오른쪽자식노드						
                     */
                	if (inputs.length != 4) {
                        result = 0;     //비유효
                        for (int j = i + 1; j <= N; j++)
                            br.readLine(); // 남은 입력값 소모
                        break;
                    }
                } else {//피연산자의 경우
                	/*
                        <피연산자의 경우>
                        75       1
						76       1
						77       2
						78       9
						79       5
                                         노드번호	 (피연산)데이터						
                	 */
                    if (inputs.length != 2) {
                        result = 0;     //비유효
                        for (int j = i + 1; j <= N; j++)
                            br.readLine();
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
/*
[입력]
11
1 - 2 3
2 - 4 5
3 + 6 7
4 / 8 9
5 - 10 11
6 7
7 8
8 4
9 3
10 5
11 6

[출력]
#1 1


[입력]
11
1 - 2 3
2 - 4 5
3 + 6 7
4 / 8 9
5 - 10 11
6 7
7 8
8 4
9 3
10 5
11 -

[출력]
#1 0
*/