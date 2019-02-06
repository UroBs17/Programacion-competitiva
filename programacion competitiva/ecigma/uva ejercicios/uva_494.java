
import java.io.*;
public class uva_494 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String k;
		while((k=br.readLine())!=null) {//(k=br.readLine())!=null
			String p="";
			int	cont=0;
			for(int i=0;i<k.length();i++) {
				char ch=k.charAt(i);
				if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
					p+=ch;
				}else if(p.length()>0) {
					cont++;
					p="";
				}
			}
			if(p.length()>0) {
				cont++;
			}
			System.out.println(cont);
		}
	}
}
