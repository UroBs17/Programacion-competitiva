import java.io.*;
public class Aibohphobia_spoj {
	public static int[][] dp;
	public static char[] word;
	public static int solve(int i, int j) {
		if(i>=word.length || j<0)return 0;
		if(i==j)return 0;
		if(dp[i][j]!=-1)return dp[i][j];	
		if(i==j-1)return word[i]==word[j]?0:1;
		if(word[i]==word[j])return dp[i][j]=solve(i+1,j-1);
		else return dp[i][j]=Math.min(solve(i+1,j), solve(i,j-1))+1;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int c=0;c<n;c++) {
			word=br.readLine().toCharArray();
			dp=new int[word.length][word.length];
			for(int i=0;i<word.length;i++)for(int j=0;j<word.length;j++)dp[i][j]=-1;
			solve(0,word.length-1);
			System.out.println(dp[0][word.length-1]);
		}
	}
}
