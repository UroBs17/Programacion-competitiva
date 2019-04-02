import java.io.*;
import java.util.*;

class uva_10098{
	
	public static HashMap<String,Boolean> isGen;
	public static StringBuilder toDis;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int cases=Integer.parseInt(br.readLine());
    	for (int i=0;i<cases;i++) {
    		char [] c=br.readLine().toCharArray();
    		Arrays.sort(c);
    		isGen=new HashMap<>();
    		toDis=new StringBuilder();
    		permutate(c,new boolean [c.length],"");
    		System.out.println(toDis.toString());
    	}
    }
	
	public static void permutate (char [] c, boolean [] flag, String result) {
		if (result.length()==c.length) {
			toDis.append(result);
			toDis.append("\n");
		} else {
			for (int i=0;i<c.length;i++) {
				if (!flag[i]) {
					String s=result+c[i];
					if (isGen.get(s)==null) {
						flag[i]=true;
						isGen.put(s, true);
						permutate(c,flag,s);
						flag[i]=false;
					}
				}
			}
		}
	}
}
