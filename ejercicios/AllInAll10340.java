


import java.io.*;
import java.util.*;

public class AllInAll10340 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null) {
			StringTokenizer st =new StringTokenizer(s);
			String p1=st.nextToken();
			String p2=st.nextToken();
			int i=0,j=0;
			while(i<p1.length() && j<p2.length()) {
				if(p1.charAt(i)==p2.charAt(j)) {
					i++;
					j++;
				}else {
					j++;
				}
			}
			System.out.println(i==p1.length()?"Yes":"No");
		}
	}

}
