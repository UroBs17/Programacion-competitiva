import java.io.*;
import java.util.*;
public class uva_10801 {
	public static ArrayList<Pair>[] graph;
	public static int dijkstra(int end,int start) {
		return Integer.MAX_VALUE;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine())!=null) {
			StringTokenizer stk =new StringTokenizer(line);
			int n=Integer.parseInt(stk.nextToken()),k=Integer.parseInt(stk.nextToken());
			int[] speeds=new int[n];
			stk=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)speeds[i]=Integer.parseInt(stk.nextToken());
			graph=new ArrayList[100];
			for(int i=0;i<100;i++)graph[i]=new ArrayList<Pair>();
			for(int i=0;i<n;i++) {
				stk=new StringTokenizer(br.readLine());
			}
			int rta=dijkstra(k,0);
			if(rta==Integer.MAX_VALUE)System.out.println("IMPOSSIBLE");
			else System.out.println(rta);
		}
	}
	public static class Pair{
		int v,w,lift;
		public Pair(int v,int w,int lift) {
			this.v=v;
			this.w=w;
			this.lift=lift;
		}
	}
}
