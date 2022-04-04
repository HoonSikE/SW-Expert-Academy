package Solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
/*
[입력]
9
3+4+5*6+7

[출력]
#1 44
*/
public class Solution_D4_1223_계산기2 {
    public static void main(String[] args) throws IOException {
//    	System.setIn(new FileInputStream("src/ws0209/input3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 1; tc++) {
 
            int N = Integer.parseInt(br.readLine());
            Stack<Character> s = new Stack<>();
            String line = br.readLine();
            String postFix = "";
 
            //postorder(후위)로 바꾸기------------------------------------------
            for (int i = 0; i < N; i++) {
                if (line.charAt(i) != '+' && line.charAt(i) != '*') {
                    postFix += line.charAt(i);
                } else {
                    if (line.charAt(i) == '*') {
                        s.push(line.charAt(i));
                    } else {
                        do {
                            if (s.isEmpty()) break;
                            postFix += s.pop();
                        } while (!s.isEmpty() && s.peek() != '+');
                        s.push(line.charAt(i));
                    }
                }
            }
 
            //연산하기--------------------------------------------------------
            while (!s.isEmpty()) postFix += s.pop();
            Stack<Integer> op = new Stack<>();
            for (int i =0; i < postFix.length(); i++) {
                if (postFix.charAt(i) != '+' && postFix.charAt(i) != '*') {
                    op.push(postFix.charAt(i) - '0');
                } else {
                    int op1 = op.pop();
                    int op2 = op.pop();
                    char operator = postFix.charAt(i);
                    switch (operator) {
                        case '*':
                            int tmp1 = op1 * op2;
                            op.push(tmp1);
                            break;
                        case '+':
                            int tmp2 = op1 + op2;
                            op.push(tmp2);
                            break;
                    }
                }
            }
            System.out.println("#" + tc + " " + op.peek());
        }
    }
}