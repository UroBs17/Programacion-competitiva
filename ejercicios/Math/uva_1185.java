import java.io.*;
import java.util.ArrayList;
public class uva_1185 {
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Double> sol=new ArrayList<Double>();
		sol.add((double)1);
		for(int i=1;i<=10000000;i++) {
			sol.add(sol.get(sol.size()-1)+Math.log10((double)i));
		}
		int c=Integer.parseInt(br.readLine());
		for(int i=0;i<c;i++) {
			int n=Integer.parseInt(br.readLine());
			System.out.println((int)Math.floor(sol.get(n)));
		}
	}
}
