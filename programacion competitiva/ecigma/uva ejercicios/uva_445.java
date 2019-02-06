import java.io.*;

public class uva_445 {

	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String k;
		while((k=br.readLine())!=null) {
			int ntr=0;
			char[] ct=k.toCharArray();
			for(int i=0;i<ct.length;i++) {
				if(ct[i]-49>=0 && ct[i]-49<10) {

					//System.out.println(ct[i]);
					ntr+=(ct[i]-49+1);
				}else {
					String imp =ct[i]=='b'?" ":""+ct[i];
					if(ct[i]=='!'){
						System.out.println();
						ntr=0;
					}
					for(int j=0;j<ntr;j++)System.out.print(""+imp);
					ntr=0;
				}
			}
			System.out.println();
			
		}
	}

}
