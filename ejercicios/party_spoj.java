import java.io.*;
class party_spoj {
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String temp[]=br.readLine().split(" ");
			int budget=Integer.parseInt(temp[0]);
			int n=Integer.parseInt(temp[1]);
			if(budget==0&&n==0)break;
			int ar[][]=new int[n+1][budget+1];
			int cost[]=new int[n];
			int val[]=new int[n];
			for(int i=0;i<n;i++){
				temp=br.readLine().split(" ");
				cost[i]=Integer.parseInt(temp[0]);
				val[i]=Integer.parseInt(temp[1]);
			}
			for(int i=0;i<n+1;i++){
				for(int b=0;b<budget+1;b++){    
					if(i==0||b==0)ar[i][b]=0;
					else if(cost[i-1]<=b)ar[i][b]=Math.max(val[i-1]+ar[i-1][b-cost[i-1]],ar[i-1][b]);
					else ar[i][b]=ar[i-1][b];
				}
			}
			int i=n,b=budget;
			while(ar[i][b]==ar[i][b-1])b--;
			System.out.println(b+" "+ar[n][budget]);
			br.readLine();
		}
	}
}
