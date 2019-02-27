import java.io.*;
import java.util.*;
public class uva_10703 {

	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean[][] m;
		int a,b,n;
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
			if(a==0 &&b==0&&n==0)break;
			m=new boolean[a][b];
			int cont=0;
			for(int ll=0;ll<n;ll++) {
				int x1,y1,x2,y2;
				st=new StringTokenizer(br.readLine());
				x1=Integer.parseInt(st.nextToken());
				y1=Integer.parseInt(st.nextToken());
				x2=Integer.parseInt(st.nextToken());
				y2=Integer.parseInt(st.nextToken());
				for(int i=Math.min(x1, x2);i<=Math.max(x1,x2);i++) {
					for(int j=Math.min(y1, y2);j<=Math.max(y1,y2);j++) {
						if(!m[i-1][j-1]) {
							m[i-1][j-1]=true;
							cont++;
						}
						
					}
				}
			}
			if (a*b-cont==0) System.out.println("There is no empty spots.");
			else if (a*b-cont==1) System.out.println("There is one empty spot.");
			else System.out.println("There are "+(a*b-cont)+" empty spots.");
			br.readLine();
		}

	}

}
