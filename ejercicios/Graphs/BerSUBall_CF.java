
import java.util.*;
import java.io.*;
public class BerSUBall_CF {
    public static boolean bfs(int rGraph[][], int s, int t, int parent[],int V) {  
        boolean visited[] = new boolean[V]; 
        for(int i=0; i<V; ++i)  visited[i]=false;
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        queue.add(s); 
        visited[s] = true; 
        parent[s]=-1;
        while (queue.size()!=0) { 
            int u = queue.poll(); 
            for (int v=0; v<V; v++) { 
                if (visited[v]==false && rGraph[u][v] > 0) { 
                    queue.add(v); 
                    parent[v] = u; 
                    visited[v] = true; 
                } 
            }
        }
        return (visited[t] == true); 
    } 
    public static int fordFulkerson(int graph[][], int s, int t, int V) { 
        int u, v; 
        int rGraph[][] = new int[V][V]; 
        for (u = 0; u < V; u++) for (v = 0; v < V; v++)rGraph[u][v] = graph[u][v];  
        int parent[] = new int[V];
        int max_flow = 0;
        while (bfs(rGraph, s, t, parent,V)) {  
            int path_flow = Integer.MAX_VALUE; 
            for (v=t; v!=s; v=parent[v]){ 
                u = parent[v]; 
                path_flow = Math.min(path_flow, rGraph[u][v]); 
            } 
            for (v=t; v != s; v=parent[v]) { 
                u = parent[v]; 
                rGraph[u][v] -= path_flow; 
                rGraph[v][u] += path_flow; 
            } 
            max_flow += path_flow; 
        }  
        return max_flow; 
    } 
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] b=new int[N];
		StringTokenizer stk=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)b[i]=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(br.readLine());
		int[] g=new int[M];
		stk=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)g[i]=Integer.parseInt(stk.nextToken());
		int V=N+M;
		int graph[][]=new int[V+2][V+2];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(Math.abs(b[i]-g[j])<2) {
					graph[i][j+N]=1;
				}
			}
		}
		int s=V;
		int t=V+1;
		for(int i=0;i<N;i++)graph[s][i]=1;
		for(int i=N;i<N+M;i++)graph[i][t]=1;
		System.out.println(fordFulkerson(graph,s,t,V+2));
	}

}
