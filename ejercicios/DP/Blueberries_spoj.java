import java.io.*;
import java.util.*;
public class Blueberries_spoj {
	public static int dp[][];
	public static int[] vi;
	public static int W;
	public static int solve(int i, int w) {
		if(i>=vi.length)return w;
		if (dp[i][w]!=-1) return dp[i][w];
		if((vi[i]+w)<=W)dp[i][w]=Math.max(solve(i+2,w+vi[i]),solve(i+1,w));
		else dp[i][w]=solve(i+1,w);
		return dp[i][w];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int cs=Integer.parseInt(br.readLine());
		for(int c=0;c<cs;c++) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(stk.nextToken());
			W=Integer.parseInt(stk.nextToken());
			dp=new int[1001][1001];
			for(int i=0;i<1001;i++)for(int j=0;j<1001;j++)dp[i][j]=-1;
			vi=new int[n];
			stk=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)vi[i]=Integer.parseInt(stk.nextToken());
			System.out.println("Scenario #"+(c+1)+": "+solve(0,0));
		}
	}
}
