import java.io.*;
import java.util.*;

public class phonenumbers755 {

	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for (int i =0; i<n; i++) {
			br.readLine();
			int p=Integer.parseInt(br.readLine().trim());
			TreeMap <String,Integer>dic1=new TreeMap<String,Integer>();
			for(int j=0;j<p;j++){
				String pal=br.readLine();
				char[] line=pal.toCharArray();
	            String newW="";
	            StringBuffer sb=new StringBuffer();
	            for(int k=0;k<pal.length();k++) {
        			char ch = line[k];
        			switch(ch) {
        			case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
        				sb.append(ch);
        				break;
        			case 'A': case 'B': case 'C':
        				sb.append('2');
        				break;
        			case 'D': case 'E': case 'F':
        				sb.append('3');
        				break;
        			case 'G': case 'H': case 'I':
        				sb.append('4');
        				break;
        			case 'J': case 'K': case 'L':
        				sb.append('5');
        				break;
        			case 'M': case 'N': case 'O':
        				sb.append('6');
        				break;
        			case 'P': case 'R': case 'S':
        				sb.append('7');
        				break;
        			case 'T': case 'U': case 'V':
        				sb.append('8');
        				break;
        			case 'W': case 'X': case 'Y':
        				sb.append('9');
        				break;
        			}
        		}
	            newW=sb.toString();
	            if (dic1.containsKey(newW)) {
	                dic1.put(newW, dic1.get(newW)+1);
	            }else {
	                dic1.put(newW, 1);
	            }
			}
	        boolean v=false;
	        for(String num: dic1.keySet()){
	            if (dic1.get(num)>1) {
	                v=true;
	        		System.out.println(num.substring(0, 3)+"-"+num.substring(3)+" "+(dic1.get(num)));
	            }
			}
	        if (!v) {
	        	System.out.println("No duplicates.");
	        }
	        if (i < n - 1) {
                System.out.println();
            }
		}
	}

}
