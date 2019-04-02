import java.io.*;
import java.util.*;
public class uva_11137 {
	 public static long[] solve() {
		 long[] dp= new long [10001];
		 int[] cubes=new int[21];
		 for(int i=1;i<=21;i++)cubes[i-1]=i*i*i;
		 dp[0]=1;
		 for(int i=0;i<21;i++) {
			 for(int j=cubes[i];j<10001;j++) {
				 dp[j]+=dp[j-cubes[i]];
			 }
		 }
		 return dp;
	 }
	public static void main(String[] args) throws Exception{
		long[] sol=solve();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine())!=null) {
			StringTokenizer stk=new StringTokenizer(line);
			System.out.println(sol[Integer.parseInt(stk.nextToken())]);
		}
	}

}
