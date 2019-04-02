import java.io.BufferedReader;
import java.io.InputStreamReader;

public class decodethetape {

	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null) {
			if(s.charAt(0)=='_')continue;
			s=s.replaceAll("[|.]","");
			s=s.replaceAll("o","1");
		    s=s.replaceAll(" ","0");
			System.out.print((char)Integer.parseInt(s,2));
		}
	}

}
