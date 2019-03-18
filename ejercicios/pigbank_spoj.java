import java.util.*;
import java.io.*;

class pigbank_spoj{
	public static void main (String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int c=0;c<n;c++) {
			String[] st=br.readLine().split(" ");
			int w1=Integer.parseInt(st[0]),w2=Integer.parseInt(st[1]);
			int W=w2-w1;
			int coins=Integer.parseInt(br.readLine());
			int v[]=new int[coins];
			int w[]=new int[coins];
			for(int coin=0;coin<coins;coin++) {
				st=br.readLine().split(" ");
				v[coin]=Integer.parseInt(st[0]);
				w[coin]=Integer.parseInt(st[1]);
			}
			int[] dp=new int[W+1];
			for(int i=0;i<=W;i++)dp[i]=Integer.MAX_VALUE;
			dp[0]=0;
			for(int i=0;i<coins;i++) {
				for(int j=1;j<=W;j++) {
					if (w[i]<=j && dp[j-w[i]]!=Integer.MAX_VALUE) {
						dp[j]=Math.min(dp[j],dp[j-w[i]]+v[i]);
					}
				}
			}
			System.out.println(dp[W]==Integer.MAX_VALUE?"This is impossible.":"The minimum amount of money in the piggy-bank is "+dp[W]+".");
		}
	}
}