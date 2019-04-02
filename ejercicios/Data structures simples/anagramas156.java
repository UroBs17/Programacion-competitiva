import java.io.*;
import java.util.*;

public class anagramas156 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		HashMap <String,Boolean> rep=new HashMap<String,Boolean>();
		HashMap <String,String> imp1=new HashMap<String,String>();
		HashMap <String,String> imp2=new HashMap<String,String>();
		while(true) {
			line=br.readLine();
			if(line.equals("#"))break;
			StringTokenizer st=new StringTokenizer(line);
			while(st.hasMoreTokens()) {
				String wordP=st.nextToken();
				char[] wordArr=wordP.toLowerCase().toCharArray();
				Arrays.sort(wordArr);
				StringBuilder sb=new StringBuilder();
				for(Character ch:wordArr) {
					sb.append(ch);
				}
				String word=sb.toString();
				if(rep.containsKey(word)) {
					rep.put(word, false);
				}else {
					imp1.put(word, wordP);
					imp2.put(wordP, word);
					rep.put(word, true);
				}
			}
		}
		ArrayList<String> arr=new ArrayList<String>();
		arr.addAll(imp2.keySet());
		Collections.sort(arr);
		for(String s:arr) {
			if(rep.get(imp2.get(s)))System.out.println(s);
		}
	}
}
