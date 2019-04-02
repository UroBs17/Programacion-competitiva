import java.io.*;
import java.util.*;
public class uva_11064 {
	public static ArrayList<Integer> primes;
	public static boolean[] isPrime;
	public static int N=100000;
	public static void sieve() {
		primes=new ArrayList<Integer>();
		isPrime=new boolean[N];
		for(int i=2;i<N;i++) {
			if(!isPrime[i]) {
				primes.add(i);
				for(int j=i;j<N/i;j+=i) {
					isPrime[j]=true;
				}
			}
		}			
	}
	public static long solve(long M) {
		long N = M;
		int div = 1, idx = 0, p = primes.get(0);
		long phi = N;
		while(1l * p * p <= N)
		{
			if(N % p == 0)
				phi -= phi / p;
			int e = 0;
			while(N % p == 0) { N /= p; ++e; }
			div *= e + 1;
			p = primes.get(++idx);
		}
		if(N != 1)
		{
			phi -= phi / N;
			div <<= 1;
		}

		return M - (div + phi) + 1;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line;
		sieve();
		while((line=br.readLine())!=null) {
			System.out.println(solve(Long.parseLong(line)));
		}

	}

}
