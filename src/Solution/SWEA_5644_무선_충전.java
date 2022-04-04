package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5644_무선_충전 {
	
	static class Node {
		int x, y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] BC;
	static int[][] pos;
	static int[][] move;
	static int M, A, T, result;
	static int[][] dir = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; ++t) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			result = 0;
			
			BC = new int[A][4];
			pos = new int[2][2];
			move = new int[2][M + 1];
			
			pos[0][0] = 1;
			pos[0][1] = 1;
			pos[1][0] = 10;
			pos[1][1] = 10;
			
			for(int i = 0 ; i < 2 ; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < M ; ++j) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ; i < A ; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 4 ; ++j) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ; i <= M ; ++i) {
				charge();
				pos[0][0] += dir[move[0][i]][0];
				pos[0][1] += dir[move[0][i]][1];
				pos[1][0] += dir[move[1][i]][0];
				pos[1][1] += dir[move[1][i]][1];
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void charge() {
		ArrayList<Integer> checkA = new ArrayList<>();
		ArrayList<Integer> checkB = new ArrayList<>();
		
		for(int i = 0 ; i < A ; ++i) {
			if(Math.abs(pos[0][0] - BC[i][0]) + Math.abs(pos[0][1] - BC[i][1]) <= BC[i][2]) {
				checkA.add(i);
			}
			if(Math.abs(pos[1][0] - BC[i][0]) + Math.abs(pos[1][1] - BC[i][1]) <= BC[i][2]) {
				checkB.add(i);
			}
		}

		int maxA = 0, maxB = 0;
		int chargeMax = 0;
		int sizeA = checkA.size();
		int sizeB = checkB.size();
		
		if(sizeA == 0 && sizeB == 0) {
			return;
		} else if(sizeA == 0) {
			for(int b : checkB) {
				maxB = BC[b][3] > maxB ? BC[b][3] : maxB;
			}
		} else if(sizeB == 0) {
			for(int a : checkA) {
				maxA = BC[a][3] > maxA ? BC[a][3] : maxA;
			}
		} else {
			for(int a : checkA) {
				for(int b : checkB) {
					
					if(a == b) {
						if(BC[a][3] > chargeMax) {
							maxA = BC[a][3] / 2;
							maxB = BC[a][3] / 2;
							chargeMax = BC[a][3];
						}
					} else {
						if(BC[a][3] + BC[b][3] > chargeMax) {
							maxA = BC[a][3];
							maxB = BC[b][3];
							chargeMax = BC[a][3] + BC[b][3];
						}
					}
				}
			}
		}
		
		result += maxA + maxB;
	}
}