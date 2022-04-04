package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229_한빈이와_Spot_Mart {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder str = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 과자 봉지의 개수 (2~1000)
			int N = Integer.parseInt(st.nextToken());
			// 무게 합 제한 (2~2,000,000)
			int M = Integer.parseInt(st.nextToken());
			// 과자 N봉지
			int[] a = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				a[i] = Integer.parseInt(st.nextToken());
			int result = -1;
			for (int i = 0; i < a.length-1; i++)
				for (int j = i+1; j < a.length; j++)
					if((a[i] + a[j]) <= M && (a[i] + a[j]) > result)
						result = a[i] + a[j];
			str.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(str.toString());
	}
}

/*
static int N,M,ans;
    static int[] snack;
    static boolean[] check;
     
    static void backtracking(int cnt,int sum) {
        if(cnt==2) {
            if(sum<=M) ans=Math.max(ans, sum);
            return;
        }
         
        for(int i=0;i<N;i++) {
            if(!check[i]) {
                check[i]=true;
                backtracking(cnt+1,sum+snack[i]);
                check[i]=false;
            }
        }
         
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb;
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            snack = new int[N];
            check = new boolean[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<N;i++) {
                snack[i]=Integer.parseInt(st.nextToken());
            }
            ans=-1;
            backtracking(0,0);
            sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(ans);
            System.out.println(sb.toString());
        }
    }
*/