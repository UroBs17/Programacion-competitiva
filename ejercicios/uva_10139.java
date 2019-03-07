import java.util.*;
import java.io.*;
public class uva_10139 {
	public static ArrayList<Integer> primes;
	public static boolean[] isPrime;
	public static void sieve() {
		primes=new ArrayList<Integer>();
		isPrime=new boolean[50000];
		for(int i=2;i<50000;i++) {
			if(!isPrime[i]) {
				primes.add(i);
				for(int j=i;j<50000/i;j+=i) {
					isPrime[j]=true;
				}
			}
		}
				
	}
	public static boolean solve(int m, int n) {
		int iPf=0;
		int pf=primes.get(iPf);
		while(pf*pf<=m) {
			//times of pf in m
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
				if(power>cantN)return false;
			}
			iPf++;
			pf=primes.get(iPf);
					
		}
		if(m!=1) return n/m>=1;
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		sieve();
		String line;
		while((line=br.readLine())!=null) {
			StringTokenizer stk=new StringTokenizer(line);
			int n=Integer.parseInt(stk.nextToken()),m=Integer.parseInt(stk.nextToken());
			System.out.println(m+((solve(m,n)?" divides ":" does not divide "))+n+"!");
		}
	}

}
