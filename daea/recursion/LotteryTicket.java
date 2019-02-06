

public class LotteryTicket {
	public String buy(int price,int b1,int b2,int b3,int b4) {
		int[] l= {b1,b2,b3,b4};
		if(solve(price,l,3)) {
			return "POSSIBLE";
		}
        else {
            return "IMPOSSIBLE";
        }
	}
	public boolean solve(int n,int[] l, int i) {
		if (n==0) {
            return true;
		}
        if (n<0 || (i<0 && n>0)){
            return false;
        }
        else {
            return solve(n-l[i],l,i-1) ||  solve(n,l,i-1);
        }
	}
}
