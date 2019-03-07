import java.io.*;
import java.util.*;

class uva_10776{
	public static StringBuilder toDis;
	public static boolean[] vi;
	public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	String line;
    	while((line=br.readLine())!=null) {
    		StringTokenizer st=new StringTokenizer(line);
    		char[] word=st.nextToken().toCharArray();
    		int k=Integer.parseInt(st.nextToken());
    		Arrays.sort(word);
    		toDis=new StringBuilder();
    		vi =new boolean [word.length];
    		permutate(word,k,"",0);
    		System.out.print(toDis.toString());
    	}
    }
	
	public static void permutate (char [] c, int k, String result,int ind) {
		if (result.length()==k) {
			toDis.append(result);
			toDis.append("\n");
		} else {
			for (int i=ind;i<c.length;i++) {
				if (!vi[i]) {
					result+=c[i];
					vi[i]=true;
					permutate(c,k,result,i);
					result=result.substring(0, result.length()-1);
					vi[i]=false;
					while(i+1 < c.length  &&  c[i]==c[i+1] )i++;
				}
				
			}
		}
	}
}
