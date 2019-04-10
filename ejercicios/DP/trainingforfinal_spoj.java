import java.util.*;
public class trainingforfinal_spoj {
	public static int[][] mt;
	public static int[][] dp;
	public static int solve(int i,int j,int n, int m) {
	    if(i>=n|| j>=m) return Integer.MAX_VALUE;
		if(i==n-1 && j== m-1) return dp[i][j] = mt[i][j];
	    if( dp[i][j] != -1) return dp[i][j];
	    return dp[i][j] = mt[i][j]+ Math.min(solve(i,j+1,n,m), solve(i+1, j,n,m));
	}
	public static void main (String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int x=sc.nextInt()-1,y=sc.nextInt()-1;
		mt=new int[n][m];
		dp=new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				mt[i][j]=sc.nextInt();
				dp[i][j]=-1;
			}
		}
		int rta=2*mt[x][y]-solve(x,y,n,m);
		if (rta<0)System.out.println("N");
		else System.out.println("Y "+rta);
	}
}
