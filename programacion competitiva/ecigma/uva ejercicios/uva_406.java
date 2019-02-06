import java.io.*;
import java.util.*;

public class uva_406 {

	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		int h=1;
		while((line=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(line);
			int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
			Set <String> keywords=new HashSet<String>();
			Map <String,Integer> dic=new TreeMap<String,Integer>();
			for(int i=0;i<a;i++)keywords.add(br.readLine().toLowerCase());
			for(int j =0;j<b;j++) {
				String k=br.readLine();
				String p="";
				for(int i=0;i<k.length();i++) {
					char ch=k.charAt(i);
					if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
						p+=ch;
					}else if(p.length()>0) {
						if(keywords.contains(p.toLowerCase())) {
							dic.put(k, dic.getOrDefault(k, 0)+1);
						}
						p="";
					}
				}
				if(p.length()>0 && keywords.contains(p)) {
					dic.put(k, dic.getOrDefault(k, 0)+1);
				}
			}
			int	max=0;
			for(String l:dic.keySet()) {
				max=Math.max(max, dic.get(l));
			}
			System.out.println("Excuse Set #"+h);
			for(String l:dic.keySet()) {
				if(max==dic.get(l))System.out.println(l);
			}
			System.out.println();
			h++;
		}
	}
}
