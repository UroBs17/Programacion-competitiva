
import java.io.*;
import java.util.*;

public class babelfish10282 {

	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String k;
		HashMap<String,String> dic=new HashMap<String,String>();
		while(true) {
			k=br.readLine();
			if(k.length()==0)break;
			StringTokenizer st=new StringTokenizer(k);
			String p1=st.nextToken();
			String p2=st.nextToken();
			dic.put(p2,p1);
		}
		while((k=br.readLine())!=null) {
			
			if(dic.containsKey(k)) {
				System.out.println(dic.get(k));
			}else {
				System.out.println("eh");
			}
			
		}
	}

}
