import java.io.*;
import java.util.*;
public class uva_10780 {
	public static ArrayList<Integer> primes;
	public static boolean[] isPrime;
	public static void sieve() {
		primes=new ArrayList<Integer>();
		isPrime=new boolean[10000];
		for(int i=2;i<10000;i++) {
			if(!isPrime[i]) {
				primes.add(i);
				for(int j=i;j<10000/i;j+=i) {
					isPrime[j]=true;
				}
			}
		}
	}
	public static int solve(int m, int n) {
		int iPf=0, pf=primes.get(iPf),ans=Integer.MAX_VALUE;
		while(m>1) {
			int power=0;
			while(m%pf==0) {
				power++;
				m/=pf;
			}
			if(power>0) {
				int cantN=0;
				for(long i=pf;i<=n;i*=pf) {
					cantN+= n/i;
				}
				if(power>cantN)return -1;
				ans=Math.min(ans, cantN/power);
			}
			iPf++;
			pf=primes.get(iPf);
					
		}
		return ans;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		sieve();
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(stk.nextToken()),n=Integer.parseInt(stk.nextToken());
			int k=solve(m,n);
			System.out.println("Case "+(i+1)+":");
			System.out.println(k>0?k:"Impossible to divide");
		}
	}

}