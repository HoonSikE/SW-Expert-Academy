package Solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1233_사칙연산유효성검사2{
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/ws0210_2/input.txt"));
		Scanner sc = new Scanner(System.in);
        for(int tc=1;tc<=10;tc++) {
            int res = 1;
            int n = Integer.parseInt(sc.nextLine());
            for(int i=0;i<n;i++) {
                String[] s = sc.nextLine().split(" ");
                if(s[1].charAt(0)==43 || s[1].charAt(0)==45 || s[1].charAt(0)==42 || s[1].charAt(0)==47 ){
                    if(s.length!=4) {
                    	res = 0;
                    }
                }
            }
            System.out.print("#"+tc+" "+res);
            System.out.println();
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