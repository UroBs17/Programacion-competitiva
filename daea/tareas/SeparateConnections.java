
public class SeparateConnections {
	
	public int howMany(String[] mat) {
		int n=mat.length;
		int n2=1<<n;
		int []dp=new int[n2];
		dp[0]=0;
		for(int i=1;i<n2;i++) {//no pense en que se llenaba dp[0] en el codigo en papel ya que alli lo inicie en 0
			int x= i & ~(i-1);
			int use= count(x);
			dp[i]=dp[x^i];
			for (int j=use+1;j<n;j++) {
				if( (i&(1<<j))!=0 && mat[use].charAt(j)=='Y') {
					dp[i]=Math.max(dp[i], dp[x^i^(1<<j)]+2);
				}
			}
					
		}
		return dp[n2-1];
	}
	public int count(int x) {
		int c=0;
		while(x>0) {
			if((x&1)!=0)break;
			c++;
			x=x>>1;
		}
		return c;
	}
	
	public static void main(String[] args) {
		SeparateConnections sc=new SeparateConnections();
		String[] mat1= {"NYYYY","YNNNN","YNNNN","YNNNN","YNNNN"};
		String[] mat2= {"NYYYY","YNNNN","YNNNY","YNNNY","YNYYN"};
		System.out.println(sc.howMany(mat1));
		System.out.println(sc.howMany(mat2));
	}

}
