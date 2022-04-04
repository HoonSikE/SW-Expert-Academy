package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro1210 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //상,좌,우
        int[] dy = {-1,0,0};
        int[] dx = {0,-1,1};
        for(int t = 1; t<=10 ; t++ ) {
            br.readLine();
            int[][] arr = new int[100][100];
            int y = 0;
            int x = 0;
            int idx = 0;
             
            for(int i = 0; i<100; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j<100 ; j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(arr[i][j]==2) {
                        y = i;
                        x = j;
                    }
                }
            }
            // y = 0 일때 멈춤
            while(y!=0) {
            	// idx 상태에 따라 상, 좌, 우 이동(초기값은 상)
                y+=dy[idx];
                x+=dx[idx];
                // 범위 내에 있고 && arr값이 유효할때
                if(y<100 && y>=0 && x<100 && x>=0 && arr[y][x]==1) {
                	// 1칸 위로 갔다면
                    if(idx==0) {
                    	// 좌로 이동했을 때 범위가 유효하고 && 그 값이 1이라면 
                        if(y+dy[1]>=0 && y+dy[1]<100 && x+dx[1]>=0 && x+dx[1]<100 && arr[y+dy[1]][x+dx[1]]==1)
                        	// idx 상태를 좌 이동으로 변경
                        	idx = 1;
                    	// 우로 이동했을 때 범위가 유효하고 && 그 값이 1이라면
                        else if(y+dy[2]>=0 && y+dy[2]<100 && x+dx[2]>=0 && x+dx[2]<100 && arr[y+dy[2]][x+dx[2]]==1)
                        	// idx 상태를 우 이동으로 변경
                        	idx=2;
                    }
                    // 좌 혹은 우로 이동했고 && 상으로 이동했을 때 범위가 유효하고 && 그 값이 1이라면
                    else if(y+dy[0]>=0 && y+dy[0]<100 && x+dx[0]>=0 && x+dx[0]<100 && arr[y+dy[0]][x+dx[0]]==1)
                    	// idx 상태를 상 이동으로 변경
                    	idx= 0;
                // (같음방향으로 계속 이동하다가) 범위에 있지 않다면 이전 값으로 돌림
                } else {
                    y-=dy[idx];
                    x-=dx[idx];
                }
            }
            System.out.println("#"+t+" "+x);
        }
    }
}
