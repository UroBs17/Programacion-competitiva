import java.io.*;
import java.util.*;

public class uva_10391 {

	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String word;
		Set<String> set=new TreeSet<String>();
		while((word=br.readLine())!=null)set.add(word);
		for(String s:set) {
			for(int i=0;i<s.length();i++) {
				if(set.contains(s.substring(0, i))&& set.contains(s.substring(i))) {
					System.out.println(s);
					break;
				}
			}
			
		}
		
	}

}
