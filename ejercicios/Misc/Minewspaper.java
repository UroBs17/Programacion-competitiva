
import java.io.*;
import java.util.*;

public class Minewspaper {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ca=0;
		while(true) {
			ca++;
			StringTokenizer k=new StringTokenizer(br.readLine());
			int a,b;
			a=Integer.parseInt(k.nextToken());
			b=Integer.parseInt(k.nextToken());
			if(a==0 && b==0)break;
			int[][] p=new int[a][b];
			for (int i=0;i<a;i++) {
				char [] c=br.readLine().toCharArray();
				for (int i2=0;i2<b;i2++) {
					if (c[i2]=='*') {
						p[i][i2]=-1;
					}
				}
			}
			for(int ind1=0;ind1<a;ind1++) {
				for(int ind2=0;ind2<b;ind2++) {
					if(p[ind1][ind2]==-1) {
						for(int i=Math.max(0,ind1-1);i<=Math.min(ind1+1,a-1);i++) {
							for (int j=Math.max(0,ind2-1);j<=Math.min(ind2+1,b-1);j++) {
								if(p[i][j]!=-1) {
									p[i][j]++;
								}
							}
						}
					}
				}
			}
			StringBuilder sb=new StringBuilder();
			if (ca>1) {
				sb.append("\n");
			}
			sb.append("Field #");
			sb.append(ca++);
			sb.append(":\n");
			for(int i=0;i<a;i++) {
				for (int i2=0;i2<b;i2++) {
					if (p[i][i2]==-1) {
						sb.append('*');
					} else {
						sb.append(p[i][i2]);
					}
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}

	}

}
