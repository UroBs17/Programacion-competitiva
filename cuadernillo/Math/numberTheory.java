public static ArrayList<Integer> primes;
public static boolean[] isPrime;
int N=50000;
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
----------------------------------------
int gcd(int a,int b){return b==0? a:gcd(b,a%b);}
int lcm(int a,int b){return a*b/gcd(a,b);}
----------------------------------------
public static int chineseRemainder(int[] n, int[] a) {
        int prod = 1;
		for(int i=0;i<n.length;i++)prod *= n[i];
        int p, sm = 0;
        for (int i = 0; i < n.length; i++) {
            p = prod / n[i];
            sm += a[i] * mulInv(p, n[i]) * p;
        }
        return sm % prod;
    }
    private static int mulInv(int a, int b) {
        int b0 = b, x0 = 0,int x1 = 1;
        if (b == 1)return 1;
        while (a > 1) {
            int q = a / b;
            int amb = a % b;
            a = b;
            b = amb;
            int xqx = x1 - q * x0;
            x1 = x0;
            x0 = xqx;
        }
        if (x1 < 0)x1 += b0;
        return x1;
    }
----------------------------------------
public static void primeFactors(long M) {
		long N = M;
		long idx = 0, p = primes.get(0);
		long numberCP = N;
		long numberPF=0;
		long numDiv=1;
		long sumDiv=1;
		double x=1.0;//si x=2 la sumdiv guardara la suma de los divisores al cuadrado si es 3 al cubo ...
		while(1l * p * p <= N){
			if(N % p == 0){
				numberPF++;
				numberCP -= numberCP / p;	
			}
			int power = 0;
			while(N % p == 0) { N /= p; ++power; }
			numDiv *= (power + 1);
			sumDiv *= ((long)Math.pow((double)p, (power + 1.0)*x) - 1) / ((long)Math.pow((double)p,x) - 1); 
			p = primes.get(++idx);
		}
		if(N != 1){
			numberPF++;
			numberCP -= numberCP / N;
			numDiv <<= 1;
			sumDiv *= ((long)Math.pow((double)p, 2.0 * x) - 1) / ((long)Math.pow((double)p,x) - 1);
		}
}