import java.io.*;
import java.util.*;
public class poj_1548 {
	public static class Node{
	    int x,y;
	    public Node(int x, int y) {
	    	this.x=x;
	    	this.y=y;
	    }
	    public boolean judge(Node rhs){
	        return (x<=rhs.x&&y<=rhs.y);
	    }
	}
	
	public static boolean dfs(int x,ArrayList<Integer>G[],boolean[] vis, int[] link){
	    for(int i=0;i<G[x].size();i++){
	        int y=G[x].get(i);
	        if(!vis[y]){
	            vis[y]=true;
	            if(link[y]==-1 || dfs(link[y],G,vis,link)) {
	                link[y]=x;
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public static int hungarian(int x,ArrayList<Integer>G[],boolean[] vis, int[] link){
	    int ans=0;
	    for(int i=1;i<=x;i++){
	        Arrays.fill(vis, false);
	        if(dfs(i,G,vis,link))ans++;
	    }
	    return ans;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    while(true){
	    	StringTokenizer stk=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(stk.nextToken()),y=Integer.parseInt(stk.nextToken());
	        if(x==-1&&y==-1) break;
	        if(x==0 && y==0) continue;
        	boolean[] vis=new boolean[1001];
        	int[] link=new int [1001];
        	ArrayList<Integer> G[]=new ArrayList[1001];
        	Node[] a =new Node[1001];
	        int cnt=1;
	        a[cnt]=new Node(x,y);
	        while(true){
	        	stk=new StringTokenizer(br.readLine());
		    	x=Integer.parseInt(stk.nextToken());
		    	y=Integer.parseInt(stk.nextToken());
	        	if(x+y==0)break;
	            cnt++;
	            a[cnt]=new Node(x,y);
	        }
	        Arrays.fill(link, -1);
	        for(int i=1;i<=cnt;i++)G[i]=new ArrayList<Integer>();
	        for(int i=1;i<=cnt;i++){
	            for(int j=1;j<=cnt;j++){
	                if(i!=j){
	                    if(a[i].judge(a[j])){
	                        G[i].add(j);
	                    }
	                }
	            }
	        }
	        System.out.println(cnt-hungarian(cnt,G,vis,link));
	    }
	}
}
