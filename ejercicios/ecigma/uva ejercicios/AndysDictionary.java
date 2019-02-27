
import java.io.*;
import java.util.*;
public class AndysDictionary {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String k;
		Set<String> set=new TreeSet<String>();
		while((k=br.readLine())!=null) {//(k=br.readLine())!=null
			String p="";
			for(int i=0;i<k.length();i++) {
				char ch=k.charAt(i);
				if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
					p+=ch;
				}else if(p.length()>0) {
					set.add(p.toLowerCase());
					p="";
				}
			}
			if(p.length()>0) {
				set.add(p.toLowerCase());
			}
		}
		ArrayList<String> arr=new ArrayList<String>();
		arr.addAll(set);
		Collections.sort(arr);
		for(String s:arr)System.out.println(s);
	}
}
