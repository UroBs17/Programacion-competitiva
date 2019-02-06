import java.io.*;
import java.util.*;
public class uva_195 {
	public static boolean[] vi;
	public static StringBuilder sb;
	public static HashMap<String,Boolean> is;
	public static String initialOrder = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=0;i<cases;i++) {
			
			List<Character> word=new ArrayList<Character>();
			for(Character ch:br.readLine().toCharArray()) {
				word.add(ch);
			}
			Collections.sort(word,new Comparator<Character>() {
		         @Override
		         public int compare(Character o1, Character o2) {
		        	 return initialOrder.indexOf(o1) - initialOrder.indexOf(o2);
		         }
		    });
			vi=new boolean[word.size()];
			sb=new StringBuilder("");
			is=new HashMap<>();
			f(word,word.size(),"");
			System.out.print(sb.toString());
		}
	}
	public static void f(List<Character> word,int k,String imp) {
		if(imp.length()==k ) {
			sb.append(imp);
			sb.append("\n");
		}else {
			for(int i=0;i<word.size();i++) {
				if(!vi[i]) {
					String s=imp+word.get(i);
					if(is.get(s)==null) {
						vi[i]=true;
						is.put(s,true);
						f(word,k,s);
						vi[i]=false;
					}
				}
			}
		}
	}
}
