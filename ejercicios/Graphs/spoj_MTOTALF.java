import java.util.*;
public class spoj_MTOTALF {
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
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] g=new int[52][52];
		for (int i=0;i<n;i++) {
			char u=sc.next().charAt(0),v=sc.next().charAt(0);
			int cap=sc.nextInt();
			int uu,vv;
			if('A'<=u &&u<='Z') {
				uu=u-'A';
			}else {
				uu=u-'a'+26;
			}
			if('A'<=v &&v<='Z') {
				vv=v-'A';
			}else {
				vv=v-'a'+26;
			}
			g[uu][vv]+=cap;
			g[vv][uu]+=cap;
		}
		System.out.println(fordFulkerson(g,0,25,52));
	}

}
