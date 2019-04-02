import java.util.*;
import java.io.*;
public class uva_11506 {
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
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(stk.nextToken()),w=Integer.parseInt(stk.nextToken());
			if(n==0 && w==0)break;
			int V=2*n;
			int[][] graph=new int[V][V];
			for(int i=0;i<n-2;i++) {
				stk=new StringTokenizer(br.readLine());
				int v1=Integer.parseInt(stk.nextToken())-1,cap=Integer.parseInt(stk.nextToken());
				graph[v1*2][(v1*2)+1]=cap;
				graph[(v1*2)+1][v1*2]=cap;
			}
			graph[0][1] =graph[1][0] = Integer.MAX_VALUE;
			graph[V - 2][V - 1] = graph[V - 1][V - 2] = Integer.MAX_VALUE;
			for(int i=0;i<w;i++) {
				stk=new StringTokenizer(br.readLine());
				int u=Integer.parseInt(stk.nextToken())-1,v=Integer.parseInt(stk.nextToken())-1,c=Integer.parseInt(stk.nextToken());
				graph[u*2+1][v*2]=c;
				graph[v*2+1][u*2]=c;
			}
			System.out.println(fordFulkerson(graph,1,V-2,V));
		}
	}
}
