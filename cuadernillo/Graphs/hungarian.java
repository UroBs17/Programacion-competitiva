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
