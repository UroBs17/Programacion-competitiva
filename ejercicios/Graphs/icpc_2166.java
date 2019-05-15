import java.io.*;
import java.util.*;
public class icpc_2166 {
	public static class Triple{
		int x,y,z;
		public Triple(int x,int y,int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		public boolean equals(Triple sh) {
			return sh.x==x && sh.y==y && sh.z==z;
		}
	}
	public static int[][][] dist;
	public static boolean[][][] vi;
	public static int c1,c2,c3;
	public static int bfs(Triple in,Triple out) {
		Deque<Triple> dq=new LinkedList<Triple>();
		dq.addLast(in);
		vi[in.x][in.y][in.z]=true;
		dist[in.x][in.y][in.z]=0;
		while(!dq.isEmpty()) {
			//for(Triple tp:dq)System.out.println(tp.x+" "+ tp.y +" "+tp.z);
			Triple u=dq.removeFirst();
			if(u.equals(out))return dist[u.x][u.y][u.z];
			int k=dist[u.x][u.y][u.z]+1;
			if(u.x-(c2-u.y)>=0 && !vi[u.x-(c2-u.y)][c2][u.z]) {
				vi[u.x-(c2-u.y)][c2][u.z]=true;
				dist[u.x-(c2-u.y)][c2][u.z]=k;
				Triple FtS=new Triple(u.x-(c2-u.y),c2,u.z);
				dq.addLast(FtS);
			}
			if(u.x-(c3-u.z)>=0 && !vi[u.x-(c3-u.z)][u.y][c3]) {
				vi[u.x-(c3-u.z)][u.y][c3]=true;
				dist[u.x-(c3-u.z)][u.y][c3]=k;
				Triple FtT=new Triple(u.x-(c3-u.z),u.y,c3);
				dq.addLast(FtT);
			}
			if(u.y-(c1-u.x)>=0 && !vi[c1][u.y-(c1-u.x)][u.z]) {
				vi[c1][u.y-(c1-u.x)][u.z]=true;
				dist[c1][u.y-(c1-u.x)][u.z]=k;
				Triple StF=new Triple(c1,u.y-(c1-u.x),u.z);
				dq.addLast(StF);
			}
			if(u.y-(c3-u.z)>=0 && !vi[u.x][u.y-(c3-u.z)][c3]) {
				vi[u.x][u.y-(c3-u.z)][c3]=true;
				dist[u.x][u.y-(c3-u.z)][c3]=k;
				Triple StT=new Triple(u.x,u.y-(c3-u.z),c3);
				dq.addLast(StT);
			}
			if(u.z-(c1-u.x)>=0 && !vi[c1][u.y][u.z-(c1-u.x)]) {
				vi[c1][u.y][u.z-(c1-u.x)]=true;
				dist[c1][u.y][u.z-(c1-u.x)]=k;
				Triple TtF=new Triple(c1,u.y,u.z-(c1-u.x));
				dq.addLast(TtF);
			}
			if(u.z-(c2-u.y)>=0 && !vi[u.x][c2][u.z-(c2-u.y)]) {
				vi[u.x][c2][u.z-(c2-u.y)]=true;
				dist[u.x][c2][u.z-(c2-u.y)]=k;
				Triple TtS=new Triple(u.x,c2,u.z-(c2-u.y));
				dq.addLast(TtS);
			}
			if(u.x+u.y<=c2 && !vi[0][u.x+u.y][u.z]) {
				vi[0][u.x+u.y][u.z]=true;
				dist[0][u.x+u.y][u.z]=k;
				Triple FtS=new Triple(0,u.x+u.y,u.z);
				dq.addLast(FtS);
			}
			if(u.x+u.z<=c3 && !vi[0][u.y][u.x+u.z]) {
				vi[0][u.y][u.x+u.z]=true;
				dist[0][u.y][u.x+u.z]=k;
				Triple FtT=new Triple(0,u.y,u.x+u.z);
				dq.addLast(FtT);
			}
			if(u.y+u.x<=c1 && !vi[u.y+u.x][0][u.z]) {
				vi[u.y+u.x][0][u.z]=true;
				dist[u.y+u.x][0][u.z]=k;
				Triple StF=new Triple(u.y+u.x,0,u.z);
				dq.addLast(StF);
			}
			if(u.y+u.z<=c3 && !vi[u.x][0][u.y+u.z]) {
				vi[u.x][0][u.y+u.z]=true;
				dist[u.x][0][u.y+u.z]=k;
				Triple StT=new Triple(u.x,0,u.y+u.z);
				dq.addLast(StT);
			}
			if(u.z+u.x<=c1 && !vi[u.z+u.x][u.y][0]) {
				vi[u.z+u.x][u.y][0]=true;
				dist[u.z+u.x][u.y][0]=k;
				Triple TtF=new Triple(u.z+u.x,u.y,0);
				dq.addLast(TtF);
			}
			if(u.z+u.y<=c2 && !vi[u.x][u.z+u.y][0]) {
				vi[u.x][u.z+u.y][0]=true;
				dist[u.x][u.z+u.y][0]=k;
				Triple TtS=new Triple(u.x,u.z+u.y,0);
				dq.addLast(TtS);
			}
		}
		return -1;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			c1=Integer.parseInt(stk.nextToken());
			if(c1==0)break;
			c2=Integer.parseInt(stk.nextToken());
			c3=Integer.parseInt(stk.nextToken());
			int a1=Integer.parseInt(stk.nextToken());
			int a2=Integer.parseInt(stk.nextToken());
			int a3=Integer.parseInt(stk.nextToken());
			int b1=Integer.parseInt(stk.nextToken());
			int b2=Integer.parseInt(stk.nextToken());
			int b3=Integer.parseInt(stk.nextToken());
			vi=new boolean[c1+1][c2+1][c3+1];
			dist=new int[c1+1][c2+1][c3+1];
			System.out.println(bfs(new Triple(a1,a2,a3),new Triple(b1,b2,b3)));
		}
	}
	
}
