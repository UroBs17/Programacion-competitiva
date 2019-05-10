import java.util.*;
import java.io.*;
public class MATGAME_spoj {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine().trim());
		while(cases-->0) {
			StringTokenizer stk=new StringTokenizer(br.readLine().trim());
			int n=Integer.parseInt(stk.nextToken()),m=Integer.parseInt(stk.nextToken());
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				int max=Integer.MIN_VALUE;
				stk=new StringTokenizer(br.readLine().trim());
				for(int j=0;j<m;j++) {
					max=Math.max(max, Integer.parseInt(stk.nextToken()));
				}
				arr[i]=max;
			}
			int s=0;
			for(int i=0;i<n;i++)s^=arr[i];
			System.out.println(s==0?"SECOND":"FIRST");
			br.readLine();
		}
	}

}
