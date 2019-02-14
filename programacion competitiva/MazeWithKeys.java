import java.util.*;
//Ejercicio hecho con Jeymar vega aka stilink
public class MazeWithKeys {
	public char[][] matriz;
	private boolean[][] vi;
	private int[] posicionesX = {-1, 0, 1, 0};
	private int[] posicionesY = {0, 1, 0, -1};
	private Map<Character,Integer> walls;
	private Set<Character> solveDelSolve;
	class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "Coordenada en x: "+x+" Coordenada en y: "+y;
		}
	}
	
	private boolean solve(int x, int y) {
		boolean abripuertasjajasalu2 = false;
		Map<Character, Pair> keys = new HashMap<Character, Pair>();
		Map<Character, Pair> doors = new HashMap<Character,Pair>();
		Deque<Pair> s = new LinkedList<Pair>();
		s.push(new Pair(x,y));
		while(!s.isEmpty()) {
			Pair top = s.removeFirst();
			vi[top.x][top.y]=true;
			if(matriz[top.x][top.y]=='*') {
				return true&&abripuertasjajasalu2;
			}
			for(int i = 0; i<4; i++) {
				if((top.x+posicionesX[i]>=0 && top.x+posicionesX[i]<matriz.length) && (top.y+posicionesY[i]>=0 && top.y+posicionesY[i]<matriz[0].length)) {
					if(!vi[top.x+posicionesX[i]][top.y+posicionesY[i]]) {
						if(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]>='a' && matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]<='z') {
							if(doors.containsKey((char)(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]-32))) {
								abripuertasjajasalu2 = true;
								Pair temp = doors.get((char)(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]-32));
								s.push(temp);
								s.push(new Pair(top.x+posicionesX[i],top.y+posicionesY[i]));
							}else {
								keys.put(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]], new Pair(top.x+posicionesX[i], top.y+posicionesY[i]));
								s.push(new Pair(top.x+posicionesX[i], top.y+posicionesY[i]));
							}
						}
						else if(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]>='A' && matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]<='Z') {
							if(keys.containsKey((char)(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]+32))) {
								abripuertasjajasalu2 = true;
								Pair temp = new Pair(top.x+posicionesX[i],top.y+posicionesY[i]);
								s.push(temp);
							}else {
								doors.put(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]], new Pair(top.x+posicionesX[i], top.y+posicionesY[i]));
							}
						}else if(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]!='#') {
							s.push(new Pair(top.x+posicionesX[i], top.y+posicionesY[i]));
						}
					}
					
				}
			}
		}
		
		return false;
	}
	private void marcarCorredor(int x, int y, int c) {
		Deque<Pair> s = new LinkedList<Pair>();
		walls.put((char)(c+'0'), 1);
		s.push(new Pair(x,y));
		while(!s.isEmpty()) {
			Pair top = s.removeFirst();
			vi[top.x][top.y]=true;
			matriz[top.x][top.y]=((matriz[top.x][top.y]>='a' && matriz[top.x][top.y]<='z') )?matriz[top.x][top.y]:(char)(c+'0');
			for(int i = 0; i<4; i++) {
				if((top.x+posicionesX[i]>=0 && top.x+posicionesX[i]<matriz.length) && (top.y+posicionesY[i]>=0 && top.y+posicionesY[i]<matriz[0].length)) {
					if(!vi[top.x+posicionesX[i]][top.y+posicionesY[i]] && (matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]=='.' || (matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]>='a' && matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]<='z') || (matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]=='*'))) {
						if(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]=='*') {
							solveDelSolve.add((char)(c+'0'));
							continue;
						}
						s.push(new Pair(top.x+posicionesX[i], top.y+posicionesY[i]));
						vi[top.x+posicionesX[i]][top.y+posicionesY[i]]=true;
						if(!(matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]>='a' && matriz[top.x+posicionesX[i]][top.y+posicionesY[i]]<='z')) {
							walls.put((char)(c+'0'), walls.get((char)(c+'0'))+1);
						}
					}
					
				}
			}
			
		}
			
			
			
	}
		
	
	
	
	public int startingPoints(String[] a) {
		solveDelSolve  = new HashSet<Character>();
		matriz = new char[a.length][a[0].length()];
		walls = new HashMap<Character,Integer>();
		for(int i = 0; i< a.length;i++) {
			matriz[i] = a[i].toCharArray();
		}
		vi = new boolean[a.length][a[0].length()];
		int c = 0;
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j<matriz[0].length;j++) {
				if((!vi[i][j]) && (matriz[i][j]=='.'))  {
					marcarCorredor(i, j, c);
					c++;
				}
				if((c+'0')==64) c=123;
			}
			
		}
		
		vi = new boolean[a.length][a[0].length()];
		int cnt=0;
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j<matriz[0].length;j++) {
				if((!solveDelSolve.contains(matriz[i][j])) && matriz[i][j]!='#' && !(matriz[i][j]>='A' && matriz[i][j]<='Z') && !(matriz[i][j]>='a' && matriz[i][j]<='z'))  {
					if(solve(i, j)) cnt+=walls.get(matriz[i][j]);
					vi = new boolean[a.length][a[0].length()];
					solveDelSolve.add(matriz[i][j]);
					
				}
			}
			
		}
		return cnt;
	}

}
