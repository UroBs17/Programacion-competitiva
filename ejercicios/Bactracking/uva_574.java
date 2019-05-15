import java.io.*;
import java.util.*;
public class uva_574 {
	public static int[] arr;
	public static int n,t;
	public static Set<String> vi;
	public static void print(int ind,int len,int sum, List<Integer> sol) {
		if(sum==t) {
			String S="";
			for(int i=0;i<len;i++)S+=(i>0?"+":"")+Integer.toString(sol.get(i));
			if(!vi.contains(S)) {
				vi.add(S);
				System.out.println(S);
			}
		}
		if(sum>t || ind==n)return;
		for(int i=ind;i<n;i++) {
			sol.add(arr[i]);
			print(i+1,len+1,sum+arr[i],sol);
			sol.remove(sol.size()-1);
		}
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			t=Integer.parseInt(stk.nextToken());
			n=Integer.parseInt(stk.nextToken());
			if(n==0)break;
			arr=new int[n];
			vi=new HashSet<String>();
			for(int i=0;i<n;i++)arr[i]=Integer.parseInt(stk.nextToken());
			System.out.println("Sums of "+t+":");
			print(0,0,0,new ArrayList<Integer>());
			if(vi.size()==0)System.out.println("NONE");
		}
	}
}
