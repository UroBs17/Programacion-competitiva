import java.io.*;
import java.util.*;
public class icpc_5220 {
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
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=1;
		while(true) {
			int n=Integer.parseInt(br.readLine());
			if(n==0)break;
			StringTokenizer stk= new StringTokenizer(br.readLine());
			int s=Integer.parseInt(stk.nextToken())-1,t=Integer.parseInt(stk.nextToken())-1,c=Integer.parseInt(stk.nextToken());
			int[][] g=new int[n][n];
			for(int i=0;i<c;i++) {
				stk= new StringTokenizer(br.readLine());
				int u=Integer.parseInt(stk.nextToken())-1,v=Integer.parseInt(stk.nextToken())-1,cap=Integer.parseInt(stk.nextToken());
				if (u!=v){
					g[u][v]+=cap;
					g[v][u]+=cap;
				}
			}
			System.out.println("Network "+cases++);
			System.out.println("The bandwidth is "+fordFulkerson(g,s,t,n)+".");
			System.out.println();
		}
	}

}
