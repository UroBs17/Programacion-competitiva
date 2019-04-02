
import java.io.*;

public class uva_884 {
	public static int[] nFactors;
	public static void solve() {
		int i, j, t,N=1000001;
		nFactors=new int[N];
	    for (i = 0; i < N; ++i)nFactors[i] = 0;
	    int cum = 0;
	    for (i = 2; i < N; ++i) {
	        if (nFactors[i] == 0) {
	            nFactors[i] = 1;
	            if (i < N/ 2)
	                for (j = 2 * i; j > 0 && j < N; j += i) {
	                    t = j;
	                    do
	                        ++nFactors[j];
	                    while ((t /= i) % i == 0);
	                }
	        }
	        nFactors[i] = (cum += nFactors[i]);
	    }
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		solve();
		String line;
		while((line=br.readLine())!=null) {
			System.out.println(nFactors[Integer.parseInt(line)]);
		}
	}

}
