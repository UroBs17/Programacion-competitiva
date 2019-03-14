
public static void primeFactors(long M) {
		long N = M;
		long idx = 0, p = primes.get(0);
		long numberCP = N;
		long numberPF=0;
		long numDiv=1;
		long sumDiv=1;
		double x=1.0;//sum(div^2)||sum(div^3)...
		while(1l * p * p <= N){
			if(N % p == 0){
				numberPF++;
				numberCP -= numberCP / p;	
			}
			int power = 0;
			while(N % p == 0) { N /= p; ++power; }
			numDiv *= (power + 1);
			sumDiv *= ((long)Math.pow((double)p, (power + 1.0)*x) - 1) 
			sumDiv /= ((long)Math.pow((double)p,x) - 1); 
			p = primes.get(++idx);
		}
		if(N != 1){
			numberPF++;
			numberCP -= numberCP / N;
			numDiv <<= 1;
			sumDiv *= ((long)Math.pow((double)p, 2.0 * x) - 1) 
			sumDiv /= ((long)Math.pow((double)p,x) - 1);
		}
}
