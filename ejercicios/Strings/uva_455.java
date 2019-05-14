import java.io.*;
import java.util.Arrays;
public class uva_455 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int c=Integer.parseInt(br.readLine());
		boolean h=false;
		while(c-->0) {
			br.readLine();
			String str=br.readLine();
			int a=computeLspTable(str);
			int rta=str.length()-a;
			if(h)System.out.println();
			h=true;
			System.out.println((str.length()%rta==0)?rta:str.length());
			
		}
	}
	static int computeLspTable(String pattern) {
	    int[] lsp = new int[pattern.length()];
	    lsp[0] = 0;  // Base case
	    for (int i = 1; i < pattern.length(); i++) {
	        // Start by assuming we're extending the previous LSP
	        int j = lsp[i - 1];
	        while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
	            j = lsp[j - 1];
	        if (pattern.charAt(i) == pattern.charAt(j))
	            j++;
	        lsp[i] = j;
	    }
	    return lsp[pattern.length()-1];
	}
}
