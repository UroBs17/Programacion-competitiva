import java.io.*;
import java.util.*;
public class uva_532 {
	public static int xI,yI,zI,xF,yF,zF;
	public static int bfs(char[][][] maze,boolean vi[][][],Triple ini,Triple fin) {
		Deque<Triple> dq=new LinkedList<Triple>();
		dq.push(new Triple(xI,yI,zI));
		
		return -1;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer line=new StringTokenizer(br.readLine());
			int z=Integer.parseInt(line.nextToken()),x=Integer.parseInt(line.nextToken()),y=Integer.parseInt(line.nextToken());
			char[][][] maze=new char[z][x][y];
			Triple ini=new Triple(0,0,0),fin=new Triple(0,0,0);
			for(int i=0;i<z;i++) {
				for(int j=0;j<x;j++) {
					maze[i][j]=br.readLine().toCharArray();
					for(int k=0;k<y;k++) {
						if(maze[i][j][k]=='S')ini=new Triple(j,k,i); 
						if(maze[i][j][k]=='E') fin=new Triple(j,k,i);
					}
				}
				br.readLine();
			}
			boolean[][][] vi=new boolean[z][x][y];
			int qt=bfs(maze,vi,ini,fin);
			if (qt==-1)System.out.println("Trapped!");
			else System.out.println("Escaped in "+qt+" minute(s).");
		}

	}
	public static class Triple{
		int x,y,z;
		public Triple(int x,int y,int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}

}
