import java.io.*;
import java.util.*;
public class uva_10098 {
	static boolean[] vi;
	static ArrayList<Character> rta;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		for(int p=0;p<k;p++) {
			char[] word=br.readLine().toCharArray();
			vi=new boolean[word.length];
			rta=new ArrayList<Character>();
			Arrays.sort(word);
			solve(word,0);
		}
	}
	public static void solve(char[]word,int i) {
		if(rta.size()==word.length) {
			for(int iii=0;iii<rta.size();iii++)System.out.print(rta.get(iii));
			System.out.println();
		}
		for(int ii=0;ii<word.length;ii++) {
			if(!vi[ii]) {
				vi[ii]=true;
				rta.add(word[ii]);
				solve(word,ii);
				vi[ii]=false;
				rta.remove(rta.size()-1);
			}
		}
	}
}