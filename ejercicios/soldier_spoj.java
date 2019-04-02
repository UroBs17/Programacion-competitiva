import java.util.*;
import java.io.*;
public class soldier_spoj {
	public static int dp[][];
	public static ArrayList<Pair> G[];
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(stk.nextToken()),t=Integer.parseInt(stk.nextToken());
		dp= new int[7][1001];
		G=new ArrayList[7];
		for(int i=0;i<7;i++)for(int j=0;j<1001;j++)dp[i][j]=-1;
		for(int i=0;i<7;i++)G[i]=new ArrayList<Pair>();
		for(int i = 0; i < n; i++) {
			stk=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(stk.nextToken()),q=Integer.parseInt(stk.nextToken()),r=Integer.parseInt(stk.nextToken());
			G[p].add(new Pair(q, r));
		}
		System.out.println(solve(1, t));
	}
	public static int solve(int item, int money) {
		if(money < 0) return 0;
		if(item > 6) return 100000;
		if(dp[item][money]!=-1) return dp[item][money];
		dp[item][money] = 0;
		for(int  i = 0; i < G[item].size(); i++) {
			if(money >= G[item].get(i).price) {
				dp[item][money] = Math.max(dp[item][money], Math.min(G[item].get(i).quality, solve(item+1, money - G[item].get(i).price)));
			}
		}
		return dp[item][money];
	}
	public static class Pair{
		int price,quality;
		public Pair(int f, int s) {
			price=f;
			quality=s;
		}
	}
}
