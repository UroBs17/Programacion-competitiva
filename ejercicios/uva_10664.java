import java.io.*;

public class uva_10664 {
	public static int[] ws;
	public static int[][] dp; 
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int c=Integer.parseInt(br.readLine());
		for(int icc=0;icc<c;icc++) {
			String[] st=br.readLine().split(" ");
			int n=st.length;
			ws=new int[n];
			int sum=0;
			for(int i=0;i<n;i++) {
				ws[i]=Integer.parseInt(st[i]);
				sum+=ws[i];
			}
			dp=new int[sum][n];
			for(int i=0;i<sum;i++)for(int j=0;j<n;j++)dp[i][j]=-1;
			if(sum%2==1)System.out.println("NO");
			else System.out.println(solve(sum/2,n-1)==sum/2?"YES":"NO");
		}
	}
	public static int solve(int sum,int n) {
		if(n==-1)return 0;
		if(dp[sum][n]!=-1)return dp[sum][n];
		return dp[sum][n]=Math.max((sum-ws[n])>=0?solve(sum-ws[n],n-1)+ws[n]:0, solve(sum,n-1));
	}
}
