import java.io.*;
import java.util.*;

public class uva_10420 {

	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Map<String,Integer> dic=new TreeMap<String,Integer>();
		for(int i=0;i<n;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String pais=st.nextToken();
			dic.put(pais, dic.getOrDefault(pais, 0)+1);
		}
		for(String pais:dic.keySet()) {
			System.out.println(pais+" "+dic.get(pais));
		}
	}

}
