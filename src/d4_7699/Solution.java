package d4_7699;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static char[][] map = new char[21][21];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int R, C;
	static int max_length = -1;

	static List<Character> visitedStack = new Stack<>();
	static List<Point> visitedList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			R = scan.nextInt();
			C = scan.nextInt();
			scan.nextLine();
			
			//input
			String input;
			for(int i=1; i<=R; i++) {
				input = scan.nextLine();
				for(int j=1; j<=C; j++) {
					map[i][j] = input.charAt(j-1);
				}
			}
			
			visitedList.add(new Point(1, 1));
			visitedStack.add(map[1][1]);
			
			searchDFS(1, 1);

			
			System.out.println("#" + test_case + " " + max_length);
			
			max_length = -1;
			visitedList.clear();
			visitedStack.clear();
		}
		
		scan.close();
	}
	
	static void searchDFS (int y, int x) {
		int temp_x, temp_y;
		
		if(max_length == 26) {
			return;
		}
		
		for(int i=0; i<4; i++) {
			temp_x = x + dx[i];
			temp_y = y + dy[i];
			
			if(temp_x <= C && temp_x >= 1 && temp_y <= R && temp_y >= 1) { //범위 확인.
				//방문여부 확인.
				if(confirmVisitSite(temp_y, temp_x)) {
					continue;
				}
				
				//이미 방문해서 알파벳이 있는지 확인.
				if(visitedStack.contains(map[temp_y][temp_x])) {
					continue;
				}else {
					visitedList.add(new Point(temp_y, temp_x));
					visitedStack.add(map[temp_y][temp_x]);
					searchDFS(temp_y, temp_x);
				}
			}
		}
		//다 돌았는데 이제 없어서 빠져나올 때 length를 체크한다.
		if(visitedStack.size() > max_length) {
			max_length = visitedStack.size();
		}
		
		visitedList.remove(visitedList.size()-1);
		visitedStack.remove(visitedStack.size()-1);
		
	}
	
	static boolean confirmVisitSite (int y, int x) {
		
		for(Point p : visitedList) {
			if(p.x == x && p.y == y) {
				return true;
			}
		}
		return false;
	}
}

class Point {
	int x, y;
	
	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
