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