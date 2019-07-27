package d4_6109;

import java.util.Scanner;

public class Solution {
	
	static int map[][] = new int[20][20];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		scan.nextLine();
		
		for(int test_case=1; test_case<=T; test_case++) {
			String[] input = scan.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			String order = input[1];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			scan.nextLine();
			
			int num1, num2;
			
			switch(order) {
			case "up":
				for(int i=0; i<n; i++) {
					int j=0, k=0;
					for(j=k; j<n; j++) {
						num1 = map[j][i];
						if(num1 == 0) {
							continue;
						}
						for(k=j+1; k<n; k++) {
							num2 = map[k][i];
							if(num2 == 0) {
								continue;
							}else {
								if(num1 == num2) {
									map[j][i] = num1 + num2;
									map[k][i] = 0;
								}
								break;
							}
						}
					}
				}
				
				for(int i=0; i<n; i++) {
					next : for(int a=0; a<n; a++) {
						if(map[a][i] == 0) {
							for(int b=a+1; b<n; b++) {
								if(map[b][i] != 0) {
									map[a][i] = map[b][i];
									map[b][i] = 0;
									continue next;
								}
							}
						}
					}
				}
				break;
			case "down":
				for(int i=0; i<n; i++) {
					int j=n-1, k=n-1;
					for(j=k; j>=0; j--) {
						num1 = map[j][i];
						if(num1 == 0) {
							continue;
						}
						for(k=j-1; k>=0; k--) {
							num2 = map[k][i];
							if(num2 == 0) {
								continue;
							}else {
								if(num1 == num2) {
									map[j][i] = num1 + num2;
									map[k][i] = 0;
								}
								break;
							}
						}
					}
				}
				
				for(int i=0; i<n; i++) {
					next : for(int a=n-1; a>=0; a--) {
						if(map[a][i] == 0) {
							for(int b=a-1; b>=0; b--) {
								if(map[b][i] != 0) {
									map[a][i] = map[b][i];
									map[b][i] = 0;
									continue next;
								}
							}
						}
					}
				}
				break;
			case "left":
				for(int i=0; i<n; i++) {
					int j=0, k=0;
					for(j=k; j<n; j++) {
						num1 = map[i][j];
						if(num1 == 0) {
							continue;
						}
						for(k=j+1; k<n; k++) {
							num2 = map[i][k];
							if(num2 == 0) {
								continue;
							}else {
								if(num1 == num2) {
									map[i][j] = num1 + num2;
									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
				
				for(int i=0; i<n; i++) {
					next : for(int a=0; a<n; a++) {
						if(map[i][a] == 0) {
							for(int b=a+1; b<n; b++) {
								if(map[i][b] != 0) {
									map[i][a] = map[i][b];
									map[i][b] = 0;
									continue next;
								}
							}
						}
					}
				}
				break;
			case "right":
				
				for(int i=0; i<n; i++) {
					int j=n-1, k=n-1;
					for(j=k; j>=0; j--) {
						num1 = map[i][j];
						if(num1 == 0) {
							continue;
						}
						for(k=j-1; k>=0; k--) {
							num2 = map[i][k];
							if(num2 == 0) {
								continue;
							}else {
								if(num1 == num2) {
									map[i][j] = num1 + num2;
									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
				
				for(int i=0; i<n; i++) {
					next : for(int a=n-1; a>=0; a--) {
						if(map[i][a] == 0) {
							for(int b=a-1; b>=0; b--) {
								if(map[i][b] != 0) {
									map[i][a] = map[i][b];
									map[i][b] = 0;
									continue next;
								}
							}
						}
					}
				}
				break;
			}
			
			String result = "#" + test_case + "\n"; 
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					result += map[i][j] + " ";
				}
				result += "\n";
			}
			
			System.out.print(result);
			
			//clear
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = 0;
				}
			}
			
		}
		
		scan.close();
	}
}
